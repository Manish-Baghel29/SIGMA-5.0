public class BinarySearch {
    public static int binarySearch(int nums[],int key){
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start + end)/2;
            if (nums[mid]==key) {
                return mid;
            }
            else if(nums[mid]>key){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // SORTED ARRAY
        int nums[]={2,4,6,7,8,9,10,13,15,17,38,45,56,78};
        int a=binarySearch(nums, 13);
        if (a==-1) {
            System.out.println("Element Not Found.");
        }
        else{
            System.out.println("Element found at Index : " +a);
        }
    }
}
