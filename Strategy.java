import java.util.List;

public interface Strategy {
    boolean shouldEnter(int day, List<Double> prices);
    boolean shouldExit(int day, List<Double> prices);
}

