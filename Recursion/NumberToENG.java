public class NumberToENG {
    public static void printMathToEng(int n){
        String digits[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        if(n==0){
            return;
        }
        int lastDigit=n%10;
        printMathToEng(n/10);
        System.out.print(digits[lastDigit]+" ");
    }
    public static void main(String[] args) {
        printMathToEng(290804);
    }
}
