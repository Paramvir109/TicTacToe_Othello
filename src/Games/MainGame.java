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
public class MainGame {
    private Player p1, p2;
    private Board b;
    
    private Player takeInput(int num) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of " + num + " player : ");
        String name = in.next();
        System.out.println("Enter symbol of " + num + " player : ");
        char sym = in.next().charAt(0);
        Player p = new Player(name,sym);
        return p;
        
    }
    
    public void startGame() {
        Scanner in = new Scanner(System.in);
        p1 = takeInput(1);
        p2 = takeInput(2);
        while(p1.getSymbol() == p2.getSymbol()) {
            System.out.println("Symbol taken. Enter another");
            char a = in.next().charAt(0);
            p2.setSymbol(a);
        }
        b = new Board(p1.getSymbol(), p2.getSymbol());
        
        int status = Board.INCOMPLETE;
        int turns = 0;
        while(status == Board.INCOMPLETE || status == Board.INVALID){
            if(turns%2 == 0) {
                System.out.println("Enter x for player 1");
                int x = in.nextInt();
                System.out.println("Enter y for player 1");
                int y = in.nextInt();
                 status = b.move(p1.getSymbol(),x,y);
                if(status != Board.INVALID) {
                    turns++;
                    b.print();
                }else {
                    System.out.println("Try again");
                }
            } else {
                
                System.out.println("Enter x for player 2");
                int x = in.nextInt();
                System.out.println("Enter y for player 2");
                int y = in.nextInt();
                status = b.move(p2.getSymbol(),x,y);
                if(status != Board.INVALID) {
                    turns++;
                    b.print ();
                } else {
                    System.out.println("Try again");
                }
            }
            
        }
        if(status == Board.PLAYER_1_WINS) {
            System.out.println(p1.getName() + " wins");
        } else if(status == Board.PLAYER_2_WINS) {
            System.out.println(p2.getName() + " wins");
        } else {
            System.out.println("DRAW!");
        }
    }
    
    public static void main(String[] args) {
        MainGame g1 = new MainGame();
        g1.startGame();
    }
    
}
