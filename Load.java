import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Load {
    public static List<Double> loadPrices(String filename) throws IOException {
        List<Double> prices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            if(line.matches("\\d+\\.\\d+")) { // crude filter for rows with price numbers
                prices.add(Double.parseDouble(line));
            }
        }
        br.close();
        return prices;
    }
}
