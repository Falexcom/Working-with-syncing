import java.util.Map;

public class FrequencyAnalyzer {

    public static Map.Entry<Integer, Integer> findMostFrequent(Map<Integer, Integer> sizeToFreq) {
        int mostFrequentCount = 0;
        int maxFrequency = 0;

        Map.Entry<Integer, Integer> mostFrequentEntry = null;

        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentCount = entry.getKey();
                mostFrequentEntry = entry;
            }
        }

        return mostFrequentEntry;
    }

    public static void printFrequencies(Map<Integer, Integer> sizeToFreq) {
        sizeToFreq.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)"));
    }
}