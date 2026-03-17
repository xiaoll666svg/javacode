public class Demo3 {
    public static void main(String[] args) {
        Thread  t=new Thread(()-> System.out.println("hello,xiancheng"));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello,main");
    }
}
