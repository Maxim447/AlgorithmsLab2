import method.BruteForceMethod;
import method.MapBuildingMethod;
import method.SegmentTreeMethod;
import method.benchmark.Benchmark;

public class Main {
    public static void main(String[] args) {
        Benchmark.runTests(new BruteForceMethod(), new MapBuildingMethod(), new SegmentTreeMethod());
    }
}
