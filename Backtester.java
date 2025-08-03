import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Backtester {
    private List<Double> prices;
    private Strategy strategy;
    private boolean inPosition = false;
    private double entryPrice = 0.0;
    private double pnl = 0.0;

    public Backtester(List<Double> prices, Strategy strategy) {
        this.prices = prices;
        this.strategy = strategy;
    }

    public void run() {
        for (int day = 1; day < prices.size(); day++) {
            if (!inPosition && strategy.shouldEnter(day, prices)) {
                inPosition = true;
                entryPrice = prices.get(day);
                System.out.println("Entered at day " + day + " price " + entryPrice);
            } else if (inPosition && strategy.shouldExit(day, prices)) {
                inPosition = false;
                double exitPrice = prices.get(day);
                double tradePnl = exitPrice - entryPrice;
                pnl += tradePnl;
                System.out.println("Exited at day " + day + " price " + exitPrice + " PnL: " + tradePnl);
            }
        }
        System.out.println("Total PnL: " + pnl);
    }
}
