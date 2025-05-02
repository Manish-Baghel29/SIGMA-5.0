public class NQueens {
    public static int count=0;
    public static boolean isSafe(char chessBoard[][],int row,int col){
        // Vertically UP
        for(int i=row-1;i>=0;i--){
            if(chessBoard[i][col]=='Q'){
                return false;
            }
        }
        // Diagonally left
        for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--){
            if(chessBoard[i][j]=='Q'){
                return false;
            }
        }
        // Diagonally left
        for(int i=row-1,j=col+1;i>=0 && j<chessBoard.length; i--,j++){
            if(chessBoard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void possiblePostions(char chessBoard[][],int row){
        if(row==chessBoard.length){
            count++;
            System.out.println("____________ChessBoard__________");
            print(chessBoard);
            return;
        }
        for(int j=0;j<chessBoard.length;j++){
            if(isSafe(chessBoard, row, j)){
                chessBoard[row][j]='Q';
                possiblePostions(chessBoard, row+1);//Function call
                chessBoard[row][j]='X';//Backtracking Step
            }
        }
    }

    public static boolean oneSolution(char chessBoard[][],int row){
        if(row==chessBoard.length){
            count++;
            // System.out.println("____________ChessBoard__________");
            // print(chessBoard);
            return true;
        }
        for(int j=0;j<chessBoard.length;j++){
            if(isSafe(chessBoard, row, j)){
                chessBoard[row][j]='Q';
                if(oneSolution(chessBoard, row+1)){
                    return true;
                }
                chessBoard[row][j]='X';//Backtracking Step
            }
        }
        return false;
    }

    public static void print(char chessBoard[][]){
        for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=5;
        char chessBoard[][]= new char[n][n];
        for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                chessBoard[i][j]='X';
            }
        }
        // possiblePostions(chessBoard,0);
        // System.out.println("Total no. of possible positions are : " +count);
        if(oneSolution(chessBoard,0)){
            print(chessBoard);
        }else{
            System.out.println("There is not any possible Solution.");
        }
    }
}
//  possiblePostions() is a method which prints all possible positions of n-Queens in n*n board.
//  oneSolution() is a method which prints only one Solution of n-Queens in n*n board.
