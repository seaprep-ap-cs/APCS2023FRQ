package q3;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherData {
    private ArrayList<Double> temperatures;

    public void cleanData(double lower, double upper) {
        for (int i = 0; i < temperatures.size(); i++) {
            double temp = this.temperatures.get(i);
            if (temp < lower || temp > upper) {
                this.temperatures.remove(temp);
            }
        }
    }

    public int longestHeatWave(double threshold) {
        int heatwaveMax = 0;
        int currentHeatWave = 0;
        for (double temp: this.temperatures) {
            if (temp > threshold) {
                currentHeatWave++;
            } else {
                if (currentHeatWave > heatwaveMax) {
                    heatwaveMax = currentHeatWave;
                }
                currentHeatWave = 0;
            }
        }
        return heatwaveMax;
    }
    public WeatherData(ArrayList<Double> temperatures) {
        this.temperatures = temperatures;
    }

    public static void main(String[] args) {
        WeatherData wd = getWeatherDataPartA();
        print("Before: ");
        print(wd.temperatures);
        wd.cleanData(85.0, 120.0);
        print("cleanData(85.0, 120.0)" );
        print(wd.temperatures);
        print("");

        WeatherData wd2 = getWeatherDataPartB();
        print("Temperatures for Part B tests: \n" + wd2.temperatures);
        int heatwave = wd2.longestHeatWave(100.5);
        print("longestHeatWave(100.5) returns " + heatwave);

        heatwave = wd2.longestHeatWave(95.2);
        print("longestHeatWave(95.2) returns " + heatwave);
    }

    private static WeatherData getWeatherDataPartA() {
        double[] temps = new double[]{99.1, 142.0, 85.0, 85.1, 84.6, 94.3, 124.9, 98.0, 101.0, 102.5};
        List<Double> temps_t = Arrays.stream(temps).boxed().collect(Collectors.toList());
        ArrayList<Double> temperatures = new ArrayList<Double>(temps_t);
        return new WeatherData(temperatures);
    }

    private static WeatherData getWeatherDataPartB() {
        double[] temps = new double[]{100.5, 98.5, 102.0, 103.9, 87.5, 105.2, 90.3, 94.8, 109.1, 102.1, 107.4, 93.2};
        List<Double> temps_t = Arrays.stream(temps).boxed().collect(Collectors.toList());
        ArrayList<Double> temperatures = new ArrayList<Double>(temps_t);
        return new WeatherData(temperatures);
    }

    private static void print(Object o) {
        System.out.println(o);
    }


}
