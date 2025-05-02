import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int arr[],int si,int ei){
        // Base
        if(si>=ei){
            return;
        }
        // work
        int mid=si+(ei-si)/2;
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei); //right part
        merge(arr, si, mid, ei); //merge both parts
        
    }  
    public static void merge(int arr[],int si,int mid,int ei){
        int i=si,j=mid+1,k=0;
        int temp[]=new int[ei-si+1];
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        // Remaing elements of left Part
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        // Remaing elements of right Part
        while(j<=ei){
            temp[k]=arr[j];
            k++;
            j++;
        }
        // Copy temp array to Original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }  
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
