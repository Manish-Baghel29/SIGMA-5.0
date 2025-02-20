// It's time complexity is O(n^2) which better than basic technique.
public class PrfixSum {
    public static void prefixSum(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int sum=0;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                sum= start==0? prefix[end] : prefix[end]-prefix[start-1];
                if(maxSum<sum){
                    maxSum=sum;
                }
                if (minSum>sum) {
                    minSum=sum;
                }
            }
        }
        System.out.println("Max sum= "+maxSum+"\nMin sum= "+minSum);
    }
    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        prefixSum(arr);
    }
}
