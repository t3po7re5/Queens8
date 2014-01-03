
public class chessboard {

    //1 for queen, 0 for empty
    private static int board[][];
    private int numQueens;
    
    /**
     * Constructor
     */
    public chessboard(){
        numQueens = 0;
        board = new int[8][8];
        for (int j = 0; j < 8; j++) //Fills board with 0's, should be done already automatically, should not be necessary
        {
            for (int k = 0; k < 8; k++)
            {
                board[j][k] = 0;
            }
        }
    }
    
    public int[][] getBoard()
    {
        return board;
    }
    
    public void start()
    {
        solve(0);
    }
    
    //Needs to be recursive
    public boolean solve(int numQueens)
    {
        if(numQueens == 8)
        {
            System.out.println("DONE");
            this.printBoard();
            return true;
        }
        else{
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 8; k++)
                {
                    if (validMove(j,k) == 0)
                    {
                        this.placeQueen(j, k, 0);
                        //board.printBoard();
                        //Recursion part goes here
                        numQueens++;
                        if(solve(numQueens))
                        {
                            return true;
                        }
                        else{
                            this.placeQueen(j,k,1);
                            numQueens--;
                        }
                    }                 
                }
            }
        }
        return false;
    }
    
    public static int validMove(int x, int y)
    {
        //Need to check x, y, AND DIAG
        for(int j = 0; j < 8; j++)
        {
            if(get(x, j) == 1)
            {
                return -1;
            }
            if(get(j, y) == 1)
            {
                return -1;
            }
        }
        for(int j = 0; j < 8; j++)
        {
            if(get(x-j, y-j) == 1)
            {
                return -1;
            }
            if(get(x-j, y+j) == 1)
            {
                return -1;
            }
            if(get(x+j, y-j) == 1)
            {
                return -1;
            }
            if(get(x+j, y+j) == 1)
            {
                return -1;
            }
        }
        return 0;
    }
    
    public int getNumQueens()
    {
        return numQueens;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param type 0 for place 1 for remove
     * @return
     */
    public int placeQueen(int x, int y, int type){
        //validate move either here or in main
        
        if (x > 7 || y > 7 || x < 0 || y < 0)
        {
            System.out.println("INVALID MOVE X:" + x + "Y:" + y);
            return -1;
        }
        else if(type == 0){
            board[x][y] = 1;
            numQueens++;
            return 0;
        }
        else if (type == 1)
        {
            board[x][y] = 0;
            return 0;
        }
        return -3;
    }
    
    /**
     * Returns the dire
     * @param x
     * @param y
     * @return
     */
    public static int get(int x, int y)
    {
        if(x < 0 || y < 0 || x > 7 || y > 7){   //Goes to 7 bc of counting
            return -1;
        }
        //System.out.println("x:" + x + "y:" + y);
        return board[x][y];
    }
    
    /**
     * Prints the board
     * @param board the board to be printed
     */
    public void printBoard()
    {
        for (int j = 0; j < 8; j++)
        {
            for(int k = 0; k < 8; k++)
            {
                System.out.print(this.get(j,k) + " ");
            }
            System.out.println("");
        }
    }
}
