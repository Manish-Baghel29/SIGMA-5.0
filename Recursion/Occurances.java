public class Occurances {
    public static void printAllOccurances(int arr[],int target,int size){
        if(size==arr.length){
            return;
        }
        if(arr[size]==target){
            System.out.println(size);
        }
        printAllOccurances(arr, target, size+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,2,3,4,2,5,6,2,4,2,7,8,2,4,5,2};
        printAllOccurances(arr, 2, 0);
    }
}
