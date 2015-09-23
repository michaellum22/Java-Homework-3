//I had help from websites: http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html & http://smahesh.com/blog/2013/03/29/eight-queens-puzzle/
// I didn't really understand how to do the backtracking that the websites used, so I was only able to print one solution with all the queens

import java.util.Scanner;

public class Queens {
    
    public static void main (String args[])
    {
    	System.out.println ("Enter number of Queens"); // Asks user for input
    	   
        Scanner input = new Scanner(System.in); 
    	int N = input.nextInt();;
        
        int [][] board = new int[N][N+2]; //Creates board for queens based on user input
        solve(0, board, N); //Checks if a queen can be placed
        for (int i = 0; i <N; i++)
        System.out.print("___");
        System.out.println();
        for (int i = 0; i <N; i++){    // For loop for row
            for (int j = 0; j< N; j++) // For loop for column
                if(board[i][j]==1)
                	System.out.print(" Q ");
                else
                	System.out.print(" - ");
        
        System.out.println();
        }
        for (int i = 0; i <N; i++)
            System.out.print("___");
        System.out.println();
        }
    	
    
    
    static boolean solve(int row, int[][] board, int N) // Method changes values in the array from 0 to 1 
    {
        if (row>=N) return true; // Returns to main
        for (int position = 0; position < N; position++) // Checks the column on each row
        {
            if (isValid(board, row, position, N)) //Sees if it is possible to have a queen
            {
                board[row][position] = 1; // Sets a value for the main
                if(!solve(row+1, board, N)) // Method checks recursively
                
                board[row][position] = 0;
                
                else
                    return true;
            }
        }
        return false;
    }
    
    static boolean isValid(int[][] board, int row, int column, int N) // Method checks if space is valid
    {
        int i, j;
        for (i = 0; i< row; i++) //Checks the row from the left side
            if(board[i][column] == 1)
        return false;
        i = row-1;
        j= column-1;
        while((i>=0)&&(j>=0)) //Checks diagonally on the upper left side
        if(board[i--][j--]==1)
        return false;
        i = row-1;
        j= column+1;
        while((i >=0)&&(j<N)) // Checks diagonally on the lower left side
        if(board[i--][j++]==1)
        return false;
        return true;
        
        
    }
}