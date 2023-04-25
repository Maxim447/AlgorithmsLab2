package method;

import model.Point;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapBuildingMethod {
    private List<Rectangle> rectangles;

    private int map[][];

    private List<Integer> compressedX;

    private List<Integer> compressedY;


    public MapBuildingMethod(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
        compressed();
        createMap();
    }

    public MapBuildingMethod() {
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

    private void createMap() {
        map = new int[compressedX.size()][compressedY.size()];
        for (Rectangle rectangle : rectangles) {
            int indexStartX = findPosition(compressedX, rectangle.getLowerPoint().getX());
            int indexStartY = findPosition(compressedY, rectangle.getLowerPoint().getY());
            int indexEndX = findPosition(compressedX, rectangle.getUpperPoint().getX());
            int indexEndY = findPosition(compressedY, rectangle.getUpperPoint().getY());
            for (int i = indexStartX; i <= indexEndX; i++) {
                for (int j = indexStartY; j <= indexEndY; j++) {
                    map[i][j]++;
                }
            }
        }
    }

    private int findPosition(List<Integer> compressed, int value) {
        if (value >= compressed.get(compressed.size() - 1)) {
            return compressed.size();
        }
        int left = 0;
        int right = compressed.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (compressed.get(middle) > value) {
                right = middle - 1;
            } else if (compressed.get(middle) < value) {
                left = middle + 1;
            } else {
                while (compressed.get(middle) == value) {
                    middle++;
                }
                return middle;
            }
        }
        return left;
    }

    public int solve(Point point) {
        int positionX = findPosition(compressedX, point.getX());
        int positionY = findPosition(compressedY, point.getY());
        if (positionX == compressedX.size() || positionY == compressedY.size()) {
            return 0;
        } else {
            return map[positionX][positionY];
        }
    }

    public void construct(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
        compressed();
        createMap();
    }
}
