public class Demo14 {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Object locker=new Object();
        Thread t1=new Thread(()->{
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
        });
        Thread t2=new Thread(()->{
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
