public class Demo10 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
           while (true){
               //RUNNABLE
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException();
               }
           }

        });
        t1.start();
        System.out.println(t1.getState());
    }
}
