// import java.util.*;
// public class prac {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         if(n==2){
//             System.out.println(n);
//         }
//         else if(n<2){
//             System.out.println("Entered range must be greater than 1");
//         }
//         else{
//             System.out.print(2+" ");
//             for(int i=3;i<=n;i++){
//                 int k=0;
//                 for(int j=2;j<i;j++){
//                     if(i%j==0){
//                         k++;
//                         break;
//                     }
//                 }
//                 if(k==0){
//                     System.out.print(i+" ");
//                 }
//             }
//         }
//         sc.close();
//     }
// }
class prac {
    public static int sum=0;
    public static long findScore(int[] nums) {
        long score=0;
        while(sum!=nums.length){
            int idx=findMinElement(nums);
            if(idx==-1){
                break;
            }
            score+=nums[idx];
            sum++;
            nums[idx]=-1;
            if(sum!=nums.length){
                mark(nums, idx);
            }
        }
        return score;
    }
    public static int findMinElement(int arr[]){
        int min=Integer.MAX_VALUE,i,k=-1;
        for(i=0;i<arr.length;i++){
            if(arr[i]!=-1 && min>arr[i]){
                min=arr[i];
                k=i;
            }
        }
        return k;
    }
    public static void mark(int arr[],int idx){
        if(idx==0 && arr[idx+1]!=-1){
            sum++;
            arr[idx+1]=-1;
        }
        else if(idx==arr.length-1 && arr[idx-1]!=-1){
            sum++;
            arr[idx-1]=-1;
        }
        else{
            if(arr[idx+1]!=-1){
                sum++;
                arr[idx+1]=-1;
            }
            if(arr[idx-1]!=-1){
                sum++;
                arr[idx-1]=-1;
            }
        }
        return;
    }
    public static void main(String[] args) {
        int nums[]={2,3,5,1,3,2};
        System.out.println(findScore(nums));
        System.out.println(nums.length);
    }
}