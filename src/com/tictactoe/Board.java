package com.tictactoe;

public class Board {
    
    private static final int EMPTY = 0;
    private static final int PLAYERX = 1;
    private static final int PLAYERO = 2;
    private static final int DRAW = 3;
    private static final int GAMENOTOVER = 4;
    
    private int dimensions;
    private int[][] board;
    
    //Default Constructor
    public Board(int n){
        if(n < 3){
            throw new IllegalArgumentException("Dimensions should be equal to or greater than 3");
        }
        dimensions = n;
        board = new int[n][n];
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                board[i][j] = EMPTY;
            }
        }
        //System.out.println(this.toString());
    }
    
    //Constructor for a state of a board
    public Board(int[][] board){
        if(board.length < 3){
            throw new IllegalArgumentException("Dimensions should be equal to or greater than 3");
        }
        dimensions = board.length;
        this.board = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                this.board[i][j] = board[i][j];
            }
        }
    }
    
    /*
     * Return true if it was able to make the move, else false.
     * Makes a move on the board with given square i, j
     * If the player passed is neither X nor O, it throws an IllegalArgumentException.
     * Also, if i or j is greater than dimensions of the board, it throws an IllegalArgumentException.
     * Finally, it checks whether the square on the board is empty, if it's not, it returns a false.
     * If it was able to make the move, it returns a true.
     */
    public boolean makeMove(int i, int j, int player){
        if(player != PLAYERX && player != PLAYERO){
            throw new IllegalArgumentException("Illegal player state");
        }
        if(i > dimensions || j > dimensions || i <= 0 || j <= 0){
            throw new IllegalArgumentException("Invalid move");
        }
        if(this.board[i - 1][j - 1] != EMPTY){
            return false;
        }
        board[i - 1][j - 1] = player;
        return true;
    }
    
    public int checkWin(){
        
        //Checking win along Horizontal rows
        
        int horizontal_result = DRAW;
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions - 1; j++){
                if(board[i][j] == EMPTY || board[i][j + 1] == EMPTY){
                    horizontal_result = DRAW;
                    break;
                }
                if(board[i][j] == board[i][j + 1]){
                    horizontal_result = board[i][j];
                }
                else{
                    horizontal_result = DRAW;
                    break;
                }
            }
            if(horizontal_result != DRAW){
                return horizontal_result;
            }
        }
        
        //Checking for win along Vertical columns
        
        int vertical_result = DRAW;
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions - 1; j++){
                if(board[j][i] == EMPTY || board[j + 1][i] == EMPTY){
                    vertical_result = DRAW;
                    break;
                }
                if(board[j][i] == board[j + 1][i]){
                    vertical_result = board[j][i];
                }
                else{
                    vertical_result = DRAW;
                    break;
                }
            }
            if(vertical_result != DRAW){
                return vertical_result;
            }
        }
        
        //Checking for result across diagonal going from top left to bottom right.
        
        int diagonal1_result = DRAW;
        for(int i = 0; i < dimensions - 1; i++){
            if(board[i][i] == EMPTY || board[i + 1][i + 1] == EMPTY){
                diagonal1_result = DRAW;
                break;
            }
            if(board[i][i] == board[i + 1][i + 1]){
                diagonal1_result = board[i][i];
            }
            else{
                diagonal1_result = DRAW;
                break;
            }
        }
        if(diagonal1_result != DRAW){
            return diagonal1_result;
        }
        
        //Checking for result across diagonal going from bottom left to top right.
        
        int diagonal2_result = DRAW;
        for(int i = dimensions - 1; i > 0; i--){
            if(board[i][i] == EMPTY || board[i - 1][i - 1] == EMPTY){
                diagonal2_result = DRAW;
                break;
            }
            if(board[i][i] == board[i - 1][i - 1]){
                diagonal2_result = board[i][i];   
            }
            else{
                diagonal2_result = DRAW;
                break;
            }
        }
        if(diagonal2_result != DRAW){
            return diagonal2_result;
        }
        
        //Checking if game is not over
        
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                if(board[i][j] == EMPTY){
                    return GAMENOTOVER;
                }
            }
        }
        
        return DRAW;
    }
    
    @Override
    public String toString(){
        String ans = "";
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                if(board[i][j] == EMPTY){
                   ans += "   |";
                }
                else if(board[i][j] == PLAYERX){
                   ans += " X |";
                }
                else if(board[i][j] == PLAYERO){
                   ans += " O |";
                }
            }
            ans += "\n---|---|---|\n";
        }
        return ans;
    }
    
    @Override
    public Board clone(){
        Board b = new Board(this.board);
        return b;
    }
    
    public static void main(String[] args){
        Board b = new Board(3);
        b.makeMove(1, 1, 1);
        b.makeMove(2, 2, 2);
        b.makeMove(3,  3, 1);
        b.makeMove(1, 3, 2);
        b.makeMove(3, 1, 1);
        b.makeMove(2, 1, 2);
        b.makeMove(3, 2, 2);
        b.makeMove(1, 2, 1);
        System.out.println(b.checkWin());
        b.makeMove(2, 3, 1);
        System.out.println(b);
    }

}
