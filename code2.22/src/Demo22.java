import java.util.Scanner;

public class Demo22 {
    //内存可见性造成的线程安全问题
    public static int flag=0;
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
           while (flag==0){

           }
            System.out.println("线程结束");
        });
        Thread t2=new Thread(()->{
            Scanner  in=new Scanner(System.in);
            System.out.println("请输入flag的值：");
            flag=in.nextInt();
        });
        t1.start();
        t2.start();
    }
}
