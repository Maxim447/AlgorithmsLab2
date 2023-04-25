package method;

import model.Point;
import model.Rectangle;

import java.util.List;

public class BruteForceMethod {
    private List<Rectangle> rectangles;

    public BruteForceMethod(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public BruteForceMethod() {
    }

    public int solve(Point point) {
        int answer = 0;
        for (Rectangle rectangle : rectangles) {
            if (rectangle.getLowerPoint().getY() <= point.getY()
                    && rectangle.getLowerPoint().getX() <= point.getX()
                    && rectangle.getUpperPoint().getY() >= point.getY()
                    && rectangle.getUpperPoint().getX() >= point.getX()) {
                answer++;
            }
        }
        return answer;
    }

    public void construct(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }
}
