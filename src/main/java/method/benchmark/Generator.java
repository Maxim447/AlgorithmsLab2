package method.benchmark;

import model.Point;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    private static final int X_PRIME = 53;

    private static final int Y_PRIME = 43;


    public static List<Point> generatesPoints(int number) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            points.add(new Point((int) (Math.pow(X_PRIME * i, 31) % (20 * number)), (int) (Math.pow(Y_PRIME * i, 31) % (20 * number))));
        }
        return points;
    }

    public static List<Rectangle> generateRectangles(int number) {
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            rectangles.add(new Rectangle(10 * i, 10 * i, 10 * (2 * number - i), 10 * (2 * number - i)));
        }
        return rectangles;
    }
}
