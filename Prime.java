import java.util.*;

public class Prime{
    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt(); 
         
        if(n == 2){
            System.out.println("n is prime");
        } else{

            boolean isprime = true;
            for(int i=2; i<=Math.sqrt(n); i++){
                if (n%i==0){
                    isprime = false;
                
                
                }
            }
             if (isprime == true){
                System.out.println("n is prime");
             }else { 
                System.out.println("n is not prime");
    
        }


   
         }
        
         }
    }
