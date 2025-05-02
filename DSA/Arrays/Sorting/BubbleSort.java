import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int arr[]){
        for(int pass=0;pass<arr.length-1;pass++){
            boolean swapped=false;
            for(int j=0;j<arr.length-1-pass;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,3,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}