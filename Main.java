import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Double> prices = Load.loadPrices("prices.csv");
        Strategy strategy = new MovingAverageCrossStrategy(5, 20);
        Backtester backtester = new Backtester(prices, strategy);
        backtester.run();
    }
}
