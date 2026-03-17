public class Demo7{
    public static void main(String[] args) {
        Thread t1=new Thread(()->{

            while (!Thread.interrupted()){
                System.out.println("hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("中止t1");
                    break;
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
