public class Demo4 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,xiancheng");
            }
        });
        t.start();
        System.out.println("main");
    }
}
