package method.benchmark;

import method.BruteForceMethod;
import method.MapBuildingMethod;
import method.SegmentTreeMethod;
import model.Point;
import model.Rectangle;

import java.util.List;

public class Benchmark {
    public static long benchmark(BruteForceMethod bruteForceMethod, List<Rectangle> rectangles, List<Point> points) {
        bruteForceMethod.construct(rectangles);
        long startTime = System.nanoTime();
        for (Point point : points) {
            bruteForceMethod.solve(point);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long benchmark(MapBuildingMethod mapBuildingMethod, List<Rectangle> rectangles, List<Point> points) {
        mapBuildingMethod.construct(rectangles);
        long startTime = System.nanoTime();
        for (Point point : points) {
            mapBuildingMethod.solve(point);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long benchmarkConstruct(SegmentTreeMethod segmentTreeMethod, List<Rectangle> rectangles) {
        long startTime = System.nanoTime();
        segmentTreeMethod.construct(rectangles);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long benchmarkConstruct(BruteForceMethod bruteForceMethod, List<Rectangle> rectangles) {
        long startTime = System.nanoTime();
        bruteForceMethod.construct(rectangles);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long benchmarkConstruct(MapBuildingMethod mapBuildingMethod, List<Rectangle> rectangles) {
        long startTime = System.nanoTime();
        mapBuildingMethod.construct(rectangles);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long benchmark(SegmentTreeMethod segmentTreeMethod, List<Rectangle> rectangles, List<Point> points) {
        segmentTreeMethod.construct(rectangles);
        long startTime = System.nanoTime();
        for (Point point : points) {
            segmentTreeMethod.solve(point);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void test(BruteForceMethod bruteForceMethod, MapBuildingMethod mapBuildingMethod, SegmentTreeMethod segmentTreeMethod, int number) {
        List<Rectangle> rectangles = Generator.generateRectangles(number);
        List<Point> points = Generator.generatesPoints(number);

        long timeForConstructBruteForce = Benchmark.benchmarkConstruct(bruteForceMethod, rectangles);
        long timeForConstructMap = 0;
        if (number <= 5000) {
            timeForConstructMap = Benchmark.benchmarkConstruct(mapBuildingMethod, rectangles);
        }
        long timeForConstructTree = Benchmark.benchmarkConstruct(segmentTreeMethod, rectangles);

        long timeForBruteForce = Benchmark.benchmark(bruteForceMethod, rectangles, points);
        long timeForMap = 0;
        if (number <= 5000) {
            timeForMap = Benchmark.benchmark(mapBuildingMethod, rectangles, points);
        }

        long timeForTree = Benchmark.benchmark(segmentTreeMethod, rectangles, points);


        System.out.println("Construct speed where N = " + number);
        System.out.println("Brute force: " + timeForConstructBruteForce);
        if (number <= 5000) {
            System.out.println("Map: " + timeForConstructMap);
        }
        System.out.println("Tree: " + timeForConstructTree);
        System.out.println("---------------------------------------------------");
        System.out.println("Algo speed where N = " + number);
        System.out.println("Brute force: " + timeForBruteForce);
        if (number <= 5000) {
            System.out.println("Map: " + timeForMap);
        }
        System.out.println("Tree: " + timeForTree);
        System.out.println("---------------------------------------------------");
    }

    public static void runTests(BruteForceMethod bruteForceMethod, MapBuildingMethod mapBuildingMethod, SegmentTreeMethod segmentTreeMethod) {
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 100);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 250);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 500);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 1000);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 1500);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 2000);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 2500);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 3750);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 5000);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 7500);
        System.gc();
        test(bruteForceMethod, mapBuildingMethod, segmentTreeMethod, 10000);
    }
}
