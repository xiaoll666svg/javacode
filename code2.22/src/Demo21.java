import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo21 {
    //使用标准库中的线程池
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.submit(() -> {
            System.out.println("hello");
        });
    }
}
