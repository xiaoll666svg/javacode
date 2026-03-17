class BlockingQueue{
    private String[] data = null;
    // 队首
    private int head = 0;
    // 队尾
    private int tail = 0;
    // 元素个数
    private int size = 0;
    public BlockingQueue(int capacity) {
        data = new String[capacity];
    }

    public  void put(String elem) {
        synchronized (this) {
            while (size >= data.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data[tail] = elem;
            tail++;
            if (tail >= data.length) {
                tail = 0;
            }
            size++;
            this.notify();
        }
    }
    public String take(){
        synchronized (this){
            while (size<=0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String ret=data[head];
            head++;
            if(head >= data.length){
                head=0;
            }
            size--;
            this.notify();
            return ret;
        }
    }
}
public class Demo19 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new BlockingQueue(1000);
        Thread customer=new Thread(()->{
           while (true){
               try {
               String value=blockingQueue.take();
               System.out.println("消费元素"+value);
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        Thread producer=new Thread(()->{
            int n=0;
            while (true){
                try {
                    blockingQueue.put(String.valueOf(n));
                    System.out.println("生产元素"+n);
                    n++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        customer.start();
    }
}
