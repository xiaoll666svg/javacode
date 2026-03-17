class Singleton{
    //懒汉模式
    private static volatile Singleton instance=null;
    private Singleton(){};
    private Singleton(int n){};

    public static Singleton getInstance() {
        if (instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
public class Demo18 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
