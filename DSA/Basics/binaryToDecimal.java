import java.util.*;
public class binaryToDecimal{
    public static int binToDec(int n ){
        int pow=0;
        int decimal=0,LastDigit;
        while(n>0){
            LastDigit=n%10;
            decimal+=LastDigit*(int)Math.pow(2,pow);
            n=n/10;
            pow++;
        }
        return decimal;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary number : ");
        int n=sc.nextInt();
        System.out.println("Decimal form of " +n +" is " + binToDec(n));
        sc.close();
    }
}