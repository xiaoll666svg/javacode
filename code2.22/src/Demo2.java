class MYRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println("hello,xiancheng");
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Thread t=new Thread(new MYRunnable());
        t.start();
    }
}
