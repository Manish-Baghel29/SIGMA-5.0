public class DiagonalSum {
    public static int diagonalSum(int matrix[][]){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            // PD
            sum+=matrix[i][i];
            // SD
            if(i!=matrix.length-1-i){
                sum+=matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
        int a=diagonalSum(matrix);
        System.out.println("The sum of diagonal is : "+a);
    }
}
