public class Reverse {
    public static void reverseArray(int[] arr){
        int start=0,end=arr.length-1;
        while(start<end){
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;
            start++;
            end--;
        }
    }
    public static void printArray(int arr[]){
        int i;
        for(i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[i]);
    }
    public static void main(String[] args) {
        int[] arr={5,3,7,9,2,1};
        reverseArray(arr);
        printArray(arr);
        reverseArray(arr);
        printArray(arr);
    }
}
