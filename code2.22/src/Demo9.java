public class Demo9 {
     public static void main(String[] args) throws InterruptedException {
          Thread t1=new Thread(()->{
             for(int i=0;i<3;i++){
                  System.out.println("hello t1");
                  try {
                       Thread.sleep(1000);
                  } catch (InterruptedException e) {
                       throw new RuntimeException();
                  }
             }
               System.out.println("t1结束");
          });
          t1.start();
          t1.join();
          System.out.println("main线程结束");
     }
}
