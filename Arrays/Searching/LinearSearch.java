public class LinearSearch {
    public static int linearSearch(int arr[], int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,8,1,3,9,45,23,27};
        int a=linearSearch(arr, 23);
        if (a==-1) {
            System.out.println("Element Not Found.");
        }
        else{
            System.out.println("Element found at Index : " +a);
        }
    }
}
