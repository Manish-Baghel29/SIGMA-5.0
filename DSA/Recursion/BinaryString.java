public class BinaryString {
    // print all the binary Strings without Consecutive ones
    public static void printBiString(int n,int lastPosition,String s){
        if(n==0){
            System.out.println(s);
            return;
        }
        printBiString(n-1, 0, s+"0");
        if(lastPosition==0){
            printBiString(n-1, 1, s+"1");
        }
    }
    public static void main(String[] args) {
        printBiString(3, 0, "");
    }
}
