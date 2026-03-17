public class Demo16 {
    public static void main(String[] args) {
        Object locker1=new Object();
        Object locker2=new Object();
        Object locker3=new Object();
        Thread t1=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker1) {
                    try {
                        locker1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                synchronized (locker2) {
                    locker2.notify();
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker2) {
                    try {
                        locker2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                synchronized (locker3) {
                    locker3.notify();
                }
            }
        });
        Thread t3=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker3) {
                    try {
                        locker3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                synchronized (locker1) {
                    locker1.notify();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (locker1){
            locker1.notify();
        }

    }
}
