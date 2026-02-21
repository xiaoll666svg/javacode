import java.util.Scanner;
public class test1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int count=0,sum=0;
        for(int i=0;i<=n;i++)
        {
            sum=issxh(i);
            if(sum==i)
                count++;

        }
        System.out.printf(count);
    }
    public int issxh(int n)
    {
        int sum=0;
       for(int i=0;i<n;i++)
        {
            if(n>9)
            {
               int j=n%10;
               sum=sum+j*j*j;
            }
            n=n/10;
        }
        return sum;
    }

}
