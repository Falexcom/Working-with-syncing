import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        int numberOfRoutes = 1000;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfRoutes; i++) {
            Thread thread = new Thread(new RouteProcessor());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Map.Entry<Integer, Integer> mostFrequent = FrequencyAnalyzer.findMostFrequent(sizeToFreq);

        System.out.println("Самое частое количество повторений " + mostFrequent.getKey() +
                " (встретилось " + mostFrequent.getValue() + " раз)");

        System.out.println("Другие размеры:");
        FrequencyAnalyzer.printFrequencies(sizeToFreq);
    }
}
