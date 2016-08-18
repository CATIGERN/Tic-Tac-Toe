package com.tictactoe;

import java.util.List;
import java.util.ArrayList;
import com.tictactoe.Board;

public class TicTacToeEngine {
    
    private int player;
    private int tempPlayer;
    private Board board;
    private static final int PLAYERSCORE = 1;
    private static final int OPPONENTSCORE = -1;
    private static final int DRAW = 0;
    
    public TicTacToeEngine(int player, Board board){
        this.player = player;
        this.board = board;
    }
    
    public List<Integer> move(){
        List<Integer> scores = new ArrayList<Integer>();
        
        return scores;
    }

}
