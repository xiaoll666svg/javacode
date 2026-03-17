public class Demo12 {
    public static int  count=0;
    public static void main(String[] args) throws InterruptedException{

        Thread t1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(count);
        //串行执行
    }
}

