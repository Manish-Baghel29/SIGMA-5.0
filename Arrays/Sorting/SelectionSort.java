import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minPosition=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPosition]>arr[j]){
                    minPosition=j;
                }
            }
            int temp=arr[minPosition];
            arr[minPosition]=arr[i];
            arr[i]=temp;
            // if you want to see the process of sorting uncomment below statement.
            // System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int nums[]={5,4,1,3,2};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
