public class FriendPair {
    public static int pairs(int n){
        if(n==1 || n==2){
            return n;
        }
        int Singal=pairs(n-1);
        int Pair=(n-1)*pairs(n-2);
        return Singal+Pair;
        // return pairs(n-1)+(n-1)*pairs(n-2);
    }
    public static void main(String[] args) {
        System.out.println(pairs(3));
    }
}
