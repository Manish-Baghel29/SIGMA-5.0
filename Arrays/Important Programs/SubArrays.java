//WE use basic proramming approach in this program Whose time complexity is O(n^3) , So in next program we are going to use better approach.
public class SubArrays {
    public static void printSubArrays(int arr[]){
        int m=arr.length*(arr.length+1)/2;
        System.out.println("Maximum possible sub arrays are :"+m);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE; 
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    System.out.print(arr[k]+",");
                    if(k==j){
                        System.out.println(" Sum of this subarray is : "+sum);
                        if(max<sum){
                            max=sum;
                        }
                        if (min>sum) {
                            min=sum;
                        }
                    }
                }System.out.println();
            }System.out.println();
        } System.out.println("Max sum= "+max+"\nMin sum= "+min);
    }
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        printSubArrays(arr);
    }
}
