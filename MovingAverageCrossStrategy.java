import java.util.List;

public class MovingAverageCrossStrategy implements Strategy {
    private int shortWindow;
    private int longWindow;

    public MovingAverageCrossStrategy(int shortWindow, int longWindow) {
        this.shortWindow = shortWindow;
        this.longWindow = longWindow;
    }

    @Override
    public boolean shouldEnter(int day, List<Double> prices) {
        return movingAverage(prices, day, shortWindow) > movingAverage(prices, day, longWindow);
    }

    @Override
    public boolean shouldExit(int day, List<Double> prices) {
        return movingAverage(prices, day, shortWindow) < movingAverage(prices, day, longWindow);
    }

    private double movingAverage(List<Double> prices, int day, int window) {
        if (day < window) return 0;
        double sum = 0.0;
        for (int i = day - window; i < day; i++) sum += prices.get(i);
        return sum / window;
    }
}
