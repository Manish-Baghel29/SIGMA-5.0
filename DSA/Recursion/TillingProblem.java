public class TillingProblem {
    public static int possibleWays(int n){
        if(n==1 || n==2){
            return n;
        }
        // horizontal
        int hz=possibleWays(n-2);
        // vertical
        int vr=possibleWays(n-1);
        
        return hz+vr;
    }
    public static void main(String[] args) {
        System.out.println(possibleWays(5));
    }
}
