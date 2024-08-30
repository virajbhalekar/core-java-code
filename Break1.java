import java.util.*;

public class Break1 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        do{
            System.out.print("enter your number : ");
            int n = Sc.nextInt();
            if(n % 10==0) {
                continue;
            }
              
        
         System.out.print("number was" +n);
    }  while(true);
}

}