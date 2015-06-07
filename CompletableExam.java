import java.util.Timer;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Created by ran on 02/06/2015.
 */
public class CompletableExam {

    public static void main(String[] args) {
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        ExecutorService executor2 = Executors.newFixedThreadPool(2);

        final CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 1000)
                System.out.println("aaa");
            return "3";
        }, executor1);

        final CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 1000)
            System.out.println("bbb");
            return "5";
        }, executor2);


        future2.join();
        future1.join();

        future1.thenAccept(System.out::println);
        future2.thenAccept(System.out::println);

        executor1.shutdown();
        executor2.shutdown();
    }
}
