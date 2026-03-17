public class Demo5 {
    public static void main(String[] args) {
        Thread t1=new Thread(()-> System.out.println("hello,单行Lambda"));
        Thread t2=new Thread(()->{
             //多行Lambda
            System.out.println("helllo，多行Lambda");
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }
}
