import java.util.*;
public class decimalTobinary {
    public static void decToBin(int n){
        int pow=0,binary=0,LastDigit,m=n;
        while (n>0) {
            LastDigit=n%2;
            binary+=LastDigit*(int)Math.pow(10,pow);
            pow++;
            n/=2;
        }
        System.out.println("Binary form of "+m+" = "+ binary);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Decimal Number to Convert into binary : ");
        int n=sc.nextInt();
        decToBin(n);
        sc.close();
    }
}
