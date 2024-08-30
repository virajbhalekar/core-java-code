import java.util.*;

public class nnum{
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int sum = 0;
        int i = 1;

        while(i <= n){
            sum+=i;
            i++;

        }
        System.out.println("Sum:" + sum);

    }
}