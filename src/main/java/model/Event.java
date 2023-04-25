package model;

public class Event {
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
