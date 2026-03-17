public class Demo15 {
    //死锁的第二种情况：两个线程，两把锁，每个线程获取到一把锁之后，尝试获取对方的锁
    public static void main(String[] args) throws InterruptedException {
        Object locker1=new Object();
        Object locker2=new Object();
        Thread t1=new Thread(()-> {
            synchronized (locker1) {
                System.out.println("t1获取到锁1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker2) {
                System.out.println("t1尝试获取锁2");
            }
        }
        });
        Thread t2=new Thread(()->{
            synchronized (locker2) {
                System.out.println("t2获取到锁2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker1) {
                    System.out.println("t2尝试获取锁1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
