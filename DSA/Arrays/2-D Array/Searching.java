public class Searching {
    public static boolean searchInSorted2DArray(int[][] matrix, int key){
        int i=0,j=matrix[0].length-1;
        while (i<=matrix.length && j>=0) {
            if(matrix[i][j]==key){
                System.out.println("Element found at Index ("+i+","+j+")");
                return true;
            }
            else if(matrix[i][j]>key){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Element not found.");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},{12,22,33,44},{15,24,35,46},{18,27,37,48}};
        searchInSorted2DArray(matrix, 37);
    }
}
