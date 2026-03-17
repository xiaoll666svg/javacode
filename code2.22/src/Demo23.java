import java.util.PriorityQueue;
import java.util.concurrent.Executors;

class MyTask implements Comparable<MyTask>{
    public Runnable runnable;
    public long time;
    public MyTask(Runnable runnable,long time){
        this.runnable=runnable;
        this.time=time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time-o.time);
    }
    public void run(){
        runnable.run();
    }
    public long getTime(){
        return  time;
    }
}
class Mytimer{
    PriorityQueue<MyTask> queue=new PriorityQueue<>();
    Object locker=new Object();
    public void Schedule(Runnable runnable,long delay){
        synchronized (locker){
            MyTask myTask=new MyTask(runnable,System.currentTimeMillis()+delay);
            queue.offer(myTask);
            locker.notify();
        }
    }
    public Mytimer(){
        Thread t=new Thread(()->{
           while (true){
               synchronized (locker) {
                   while (queue.isEmpty()) {
                       try {
                           locker.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

                   MyTask myTask = queue.peek();
                   if (System.currentTimeMillis() >= myTask.getTime()) {
                       myTask.run();
                       queue.poll();
                   } else {
                       try {
                           locker.wait(myTask.getTime() - System.currentTimeMillis());
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
        });
        t.start();
    }
}
public class Demo23 {
    public static void main(String[] args) {
        Mytimer mytimer=new Mytimer();
        mytimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,3000");
            }
        },3000);
        mytimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,1000");
            }
        },1000);
        mytimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,2000");
            }
        },2000);
    }
}
