import java.util.concurrent.locks.ReentrantLock;

public class Demo26  {
    //可重入互斥锁

    private static int count=0;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    reentrantLock.lock();
                    try {
                        count++;
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    reentrantLock.lock();
                        count++;
                        reentrantLock.unlock();

                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
