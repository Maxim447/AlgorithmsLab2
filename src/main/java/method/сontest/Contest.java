package method.сontest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Contest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rectangles.add(new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        int m = scanner.nextInt();
        if (rectangles.size() == 0) {
            for (int i = 0; i < m; i++) {
                System.out.print(0 + " ");
            }
            return;
        }
        SegmentTreeMethod segmentTreeMethod = new SegmentTreeMethod(rectangles);
        for (int i = 0; i < m; i++) {
            System.out.print(segmentTreeMethod.solve(new Point(scanner.nextInt(), scanner.nextInt())) + " ");
        }
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Rectangle {

    private Point lowerPoint;

    private Point upperPoint;

    public Rectangle(Point lowerPoint, Point upperPoint) {
        this.lowerPoint = lowerPoint;
        this.upperPoint = upperPoint;
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.lowerPoint = new Point(x1, y1);
        this.upperPoint = new Point(x2, y2);
    }

    public Point getLowerPoint() {
        return lowerPoint;
    }

    public void setLowerPoint(Point lowerPoint) {
        this.lowerPoint = lowerPoint;
    }

    public Point getUpperPoint() {
        return upperPoint;
    }

    public void setUpperPoint(Point upperPoint) {
        this.upperPoint = upperPoint;
    }
}

class Node {
    private Node left;
    private Node right;
    private int sum;

    public Node() {
        this.left = null;
        this.right = null;
        this.sum = 0;
    }

    public Node(Node left, Node right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    public Node(Node node) {
        this.left = node.left;
        this.right = node.right;
        this.sum = node.sum;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}

class Event {
    private int x;
    private int lowerBoundOfRectangle;
    private int upperBoundOfRectangle;
    boolean isOpening;

    public Event(int x, int lowerBoundOfRectangle, int upperBoundOfRectangle, boolean isOpening) {
        this.x = x;
        this.lowerBoundOfRectangle = lowerBoundOfRectangle;
        this.upperBoundOfRectangle = upperBoundOfRectangle;
        this.isOpening = isOpening;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getLowerBoundOfRectangle() {
        return lowerBoundOfRectangle;
    }

    public void setLowerBoundOfRectangle(int lowerBoundOfRectangle) {
        this.lowerBoundOfRectangle = lowerBoundOfRectangle;
    }

    public int getUpperBoundOfRectangle() {
        return upperBoundOfRectangle;
    }

    public void setUpperBoundOfRectangle(int upperBoundOfRectangle) {
        this.upperBoundOfRectangle = upperBoundOfRectangle;
    }

    public boolean isOpening() {
        return isOpening;
    }

    public void setOpening(boolean opening) {
        isOpening = opening;
    }
}

class SegmentTreeMethod {
    private List<Rectangle> rectangles;

    private List<Integer> compressedX;

    private List<Integer> compressedY;

    List<Node> roots = new ArrayList<>();

    List<Integer> compressedRoots = new ArrayList<>();

    public SegmentTreeMethod(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
        compressed();
        createTree();
    }


    private void compressed() {
        compressedX = new ArrayList<>();
        compressedY = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            compressedX.add(rectangle.getLowerPoint().getX());
            compressedX.add(rectangle.getUpperPoint().getX());
            compressedX.add(rectangle.getUpperPoint().getX() + 1);
            compressedY.add(rectangle.getLowerPoint().getY());
            compressedY.add(rectangle.getUpperPoint().getY());
            compressedY.add(rectangle.getUpperPoint().getY() + 1);

        }
        compressedX = compressedX.stream().sorted().distinct().collect(Collectors.toList());
        compressedY = compressedY.stream().sorted().distinct().collect(Collectors.toList());
    }

    private void createTree() {
        List<Event> events = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            events.add(new Event(findPosition(compressedX, rectangle.getLowerPoint().getX()),
                    findPosition(compressedY, rectangle.getLowerPoint().getY()),
                    findPosition(compressedY, rectangle.getUpperPoint().getY() + 1),
                    true));
            events.add(new Event(findPosition(compressedX, rectangle.getUpperPoint().getX() + 1),
                    findPosition(compressedY, rectangle.getLowerPoint().getY()),
                    findPosition(compressedY, rectangle.getUpperPoint().getY() + 1),
                    false));
        }
        events.sort(Comparator.comparingInt(Event::getX));

        Node root = new Node();
        int prevCompressedX = events.get(0).getX();
        for (Event event : events) {
            if (event.getX() != prevCompressedX) {
                roots.add(root);
                compressedRoots.add(prevCompressedX);
                prevCompressedX = event.getX();
            }
            root = add(root, 0, compressedY.size(), event.getLowerBoundOfRectangle(), event.getUpperBoundOfRectangle(), event.isOpening() ? 1 : -1);
        }
        compressedRoots.add(prevCompressedX);
        roots.add(root);
    }

    private Node add(Node root, int left, int right, int start, int end, int value) {
        if (left >= end || right <= start) {
            return root;
        }
        if (start <= left && right <= end) {
            Node node = new Node(root);
            node.setSum(node.getSum() + value);
            return node;
        }
        int mid = (left + right) / 2;
        Node node = new Node(root.getLeft(), root.getRight(), root.getSum());

        if (node.getLeft() == null) {
            node.setLeft(new Node());
        }
        node.setLeft(add(node.getLeft(), left, mid, start, end, value));

        if (node.getRight() == null) {
            node.setRight(new Node());
        }
        node.setRight(add(node.getRight(), mid, right, start, end, value));

        return node;
    }

    private int getAnswer(Node root, int left, int right, int target) {
        if (left - right == 1) {
            return root.getSum();
        }
        int mid = (right + left) / 2;
        if (target < mid) {
            if (root.getLeft() == null) {
                return root.getSum();
            }
            return root.getSum() + getAnswer(root.getLeft(), left, mid, target);
        } else {
            if (root.getRight() == null) {
                return root.getSum();
            }
            return root.getSum() + getAnswer(root.getRight(), mid, right, target);
        }
    }

    public int solve(Point point) {
        if (point.getX() < compressedX.get(0) || point.getY() < compressedY.get(0)) {
            return 0;
        }
        int positionX = findPosition(compressedX, point.getX());
        int positionY = findPosition(compressedY, point.getY());

        return getAnswer(roots.get(findPosition(compressedRoots, positionX)), 0, compressedY.size(), positionY);
    }

    private int findPosition(List<Integer> compressed, int value) {
        int low = 0;
        int high = compressed.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (compressed.get(mid) > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}