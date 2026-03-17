import java.util.concurrent.atomic.AtomicInteger;

public class Demo24 {
    //使用原子类AtomicInteger代替int,能够保证线程安全
        public static AtomicInteger count=new AtomicInteger(0);
        public static void main(String[] args) throws InterruptedException{

            Thread t1=new Thread(()->{
                for (int i = 0; i < 50000; i++) {
                    //count++;
                    count.getAndIncrement();
                }
            });
            Thread t2=new Thread(()->{
                for (int i = 0; i < 50000; i++) {
                    //count++;
                    count.getAndIncrement();
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(count);
            //并发执行
        }
}

