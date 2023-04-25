package model;

public class Rectangle {

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
