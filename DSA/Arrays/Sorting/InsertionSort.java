import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int current=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>current){
                arr[prev+1]=arr[prev];
                prev--;
            }
            if(prev!=i-1){
                arr[prev+1]=current;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,3,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
