class Singleton1{
    //饿汉模式
    private static Singleton1 instance=new Singleton1();
    private Singleton1(){};
    private Singleton1(int n){};
    public static Singleton1 getInstance(){
        return instance;
    }
}
public class Demo17 {
    public static void main(String[] args) {
        Singleton1 t1 = Singleton1.getInstance();
        Singleton1 t2=Singleton1.getInstance();
        System.out.println(t1==t2);
    }
}
