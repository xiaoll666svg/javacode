import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool{
    BlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();
    public void Submit(Runnable runnable) throws InterruptedException{
        queue.put(runnable);
    }//将任务加入线程池
    public MyThreadPool(int n){
        for (int i = 0; i <n ; i++) {
            Thread t=new Thread(()->{
               while (true){
                   try {
                       Runnable runnable=queue.take();
                       runnable.run();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
            t.start();
        }
    }

}
public class Demo20 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool=new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id=i;
            pool.Submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +" " +id);
                }
            });
        }

    }
}