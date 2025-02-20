import java.util.*;
public class PRIME_No{
    // isPrime() is used to check the number is prime or not.
    public static boolean isPrime(int n){
       if(n==2){
        return true;
       }
       for(int i=2;i<=Math.sqrt(n);i++){
        if(n%i==0){
            return false;
        }
       }
       return true; 
    }
    // rangePrime() is used to check prime numbers from 2 to n.
    public static void rangePrime(int n){
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number to check prime : ");
        // int a=sc.nextInt();
        // System.out.print(isPrime(a));
        System.out.print("Enter the Range : ");
        int n=sc.nextInt();
        rangePrime(n);
        sc.close();
    }
}