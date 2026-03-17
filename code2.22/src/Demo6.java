public class Demo6 {
    public static volatile boolean isQUit=false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            while (!isQUit){
                System.out.println("hello.t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isQUit=true;
        System.out.println("finish t1");
    }
}
