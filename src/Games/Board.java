/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

public class Board {
    private char[][]board;
    private final int size = 3;
    private char p1Symbol,p2Symbol;
    private int count;
    
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;
    
    public Board(char p1Symbol, char p2Symbol) {
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
        this.board = new char[size][size];
        for(int i = 0;i < size; i++) {
            for(int j = 0;j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public int move(char symbol, int x, int y) {
        if(x >= size || y >= size || x < 0 || y < 0 || board[x][y] != ' ') {
            return INVALID;
        }
        board[x][y] = symbol;
        count++;
        if(board[x][0] == board[x][1] &&  board[x][1] == board[x][2]) {
            return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if(board[0][y] == board[1][y] &&  board[1][y] == board[2][y]) {
           return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        if(board[0][0] != ' ' && board[0][0] == board[1][1] &&  board[1][1] == board[2][2]) {
           return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }
        
        if(board[2][0] != ' '&&board[2][0] == board[1][1] &&  board[1][1] == board[0][2]) {
           return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        } 
        
        if(count == size * size){
            return DRAW;
	}
        return INCOMPLETE;
    }
    
    public void print() {
	System.out.println("________________");
	for(int i =0; i < size; i++){
            for(int j =0; j < size; j++){
                System.out.print("| " + board[i][j] + " |");
            }
	System.out.println();
	}
	System.out.println();
	System.out.println("________________");
	}
}
