/* Sudoku
Problem Description
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
Problem Constraints
N = 9
Input Format
First argument is an array of array of characters representing the Sudoku puzzle.
Output Format
Modify the given input to the required answer.

TC = O(N^N^2)
SC = O(N^2)

 */


package BackTracking;

public class Sudoku {
    int N = 0;
    public void solveSudoku(char[][] A) {
        N = A.length;
        sudoku(0,0,A);
    }

    boolean sudoku(int r, int c,char[][] A){
        if(c==N){
            r = r+1;
            c=0;
        }
        if(r==N){
            return true;
        }
        if(A[r][c]!='.'){
            return sudoku(r,c+1,A);
        }

        //All possible cases
        for(int d=1;d<=A.length;d++){
            if(isValid(r,c,d,A)){
                A[r][c]=(char)(d+'0');
                if(sudoku(r,c+1,A)){
                    return true;
                }
                A[r][c] = '.';
            }
        }
        return false;
    }

    boolean isValid(int r, int c, int d,char[][] A){
        for(int p=0;p<A.length;p++){
            if(A[p][c]== (char) (d+'0') || A[r][p]==(char)(d+'0')){
                return false;
            }
        }
        int n = (int)Math.sqrt(A.length);
        int x = r - (r%n);
        int y = c - (c%n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (A[x+i][y+j]==(char)(d+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}
