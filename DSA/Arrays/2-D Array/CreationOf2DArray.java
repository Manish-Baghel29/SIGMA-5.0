import java.util.*;
public class CreationOf2DArray {
    public static void minAndMax(int arr[][]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                max=Math.max(max, arr[i][j]);
                min=Math.min(min, arr[i][j]);
            }
        }
        System.out.println("Minimum element is : "+min+"\nMaximum element is : "+max);
    }
    public static boolean searchIn2D(int arr[][],int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    System.out.println("Element found at index ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Element not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]=new int[4][3];
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter elements of arr : ");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        minAndMax(matrix);
        searchIn2D(matrix, 05);
        sc.close();

    }
}