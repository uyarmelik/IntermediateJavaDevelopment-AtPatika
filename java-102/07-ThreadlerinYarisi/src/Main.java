import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        OddEvenThread thr = new OddEvenThread();
        ExecutorService exe = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10001; i++) exe.execute(thr);

        exe.shutdown();

    }
}