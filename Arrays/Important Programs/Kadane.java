public class Kadane {
    public static void kadane(int[] arr){
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currentSum+=arr[i];
            if(currentSum<0){
                currentSum=0;
            }
            maxSum=Math.max(maxSum, currentSum);
        }
        System.out.println("Max Subarray sum = "+maxSum);
    }
    public static void main(String[] args) {
        int[] nums={-2,-3,4,-1,-2,1,5,-3};
        // int nums[]={2,4,6,8,10};
        kadane(nums);
    }
}
