public class TrappedRainWater {
    public static int trappedWater(int arr[]){
        int leftMax[]= new int[arr.length];
        int rightMax[]= new int[arr.length];
        int maxLeft=arr[0],maxRight=arr[arr.length-1];
        leftMax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            maxLeft=Math.max(maxLeft, arr[i]);
            leftMax[i]=maxLeft;
        }
        rightMax[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            maxRight=Math.max(maxRight, arr[i]);
            rightMax[i]=maxRight;
        }
        int wt=0;
        for(int i=0;i<arr.length;i++){
            int wl=0;
            wl=Math.min(rightMax[i], leftMax[i]);
            wt+=wl-arr[i];
        }
        return wt;
        
    }
    public static void main(String[] args) {
        int nums[]={4,2,0,6,3,2,5};
        int water=trappedWater(nums);
        System.out.println("Trapped water = "+water);
    }
}
