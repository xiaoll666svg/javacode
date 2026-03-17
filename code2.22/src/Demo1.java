public class Demo1 {
    public static  class MYthread extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("hello,线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t=new MYthread();
        t.start();
        while (true){
            System.out.println("hello,main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
