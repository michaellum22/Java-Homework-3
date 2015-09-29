/*I had help from websites: http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html & http://smahesh.com/blog/2013/03/29/eight-queens-puzzle/
//Originally I tried using a multidimensional array, but I found out that it would not work with backtracking, so I switched to a single array to store 
the columns instead. As you suggested in the feedback I got, I looked up a tutorial for backtracking and had help from https://www.youtube.com/watch?v=ZM7RGa8W2KA
import java.util.Scanner;
*/
import java.util.Scanner;
public class Queens {
    
    public static void main (String args[])
    {
    	System.out.println ("Enter number of Queens"); // Asks user for input
    	   
        Scanner input = new Scanner(System.in); 
    	int N = input.nextInt();
        
         //Creates board for queens based on user input
    	int[] board = new int[N];
        Search(board, 0, N);
        }
     static  void	print(int [] board, int N) // Prints board with queens
       {
    	 for (int i = 0; i <N; i++)
             System.out.print("___");
             System.out.println();
    		for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i] == j) 
                    	System.out.print(" Q ");
                    else          
                    	System.out.print(" - ");
                }
                System.out.println();
            }  
    	
    	for (int i = 0; i <N; i++)
            System.out.print("___");
        System.out.println();
       }
    
     static void Search(int[] board, int n, int M) { // Searches board to place Queens. Int n is needed for base case
         int N = M;
         if (n == N) print(board, M); // Prints solution for 1 combination
         else {
             for (int i = 0; i < N; i++) {
                 board[n] = i;
                 if (Checkboard(board, n, 0) == 1) 
                	Search(board, n+1, M); //Recursively calls the function until n becomes the number of queens
             }
         }
     }  
     
     static int Checkboard(int[] board, int N, int i) { // Method checks board for locations.
         
         while((i < N))
         {
        	 if (board[i] == board[N]) // Checks if the queen is on the column
             return 0;
        	 else if ((board[N] - board[i]) == (N - i) || (board[i] - board[N]) == (N - i)) // checks if the queen is diagonal from the proposed location
        	 return 0;
            i++;
         }
         return 1;
         }
     


    


   
}