/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

import java.util.Scanner;

/**
 *
 * @author Param
 */
public class Othello {
    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;
    final static int[] xDir = {1,1,1,0,-1,-1,-1,0};
    final static int[] yDir = {-1,0,1,1,1,0,-1,-1};

	public Othello() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

    public boolean move(int symbol, int x, int y){
		
      if(x  < 0 || x >= 8 || y  < 0 || y >= 8) {
        return false;
      }
      if(board[x][y] != 0) {
        return false;
      }
     
      int flag = 0;
      int s = (symbol == player1Symbol) ? player2Symbol : player1Symbol;
      for(int i = 0;i < 8; i++) {
        boolean check = false;
        int moveX = xDir[i];
        int moveY = yDir[i];
        int count = 1;
        while(x + count*moveX >= 0 && x + count*moveX < 8 && y + count*moveY >= 0 && y + count*moveY < 8){
          if(board[x + count*moveX][y + count*moveY] == 0) {
            break;
          } 
          if(board[x + count*moveX][y + count*moveY] == s){
            check = true;
            count++;
          }
          if(board[x + count*moveX][y + count*moveY] == symbol){
            if(check) {
              flag = 1;
              for(int j = 0;j < count; j++) {
                board[x + j*moveX][y + j*moveY] = symbol;
              }
            }
            break;
          }
          
        }
        
      }
      if(flag == 0) {
        return false;
      }
      return true;

    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
	Othello b = new Othello();
	int n = s.nextInt();
	boolean p1Turn = true;
	while(n > 0) {
		int x = s.nextInt();
		int y = s.nextInt();
		boolean ans = false;
		if(p1Turn) {
			ans = b.move(player1Symbol, x, y);
		}
		else {
			ans = b.move(player2Symbol, x, y);
		}
		if(ans) {
			b.print();
			p1Turn = !p1Turn;
			n--;
		}
		else {
			System.out.println(ans);
		}
	}
    }
    
}
