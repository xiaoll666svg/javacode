public class Demo8 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("中止t1");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
