import java.util.Random;

public class RouteProcessor implements Runnable {
    @Override
    public void run() {
        String route = RouteGenerator.generateRoute("RLRFR", 100);
        int rCount = (int) route.chars().filter(ch -> ch == 'R').count();

        synchronized (Main.sizeToFreq) {
            Main.sizeToFreq.put(rCount, Main.sizeToFreq.getOrDefault(rCount, 0) + 1);
        }
    }
}