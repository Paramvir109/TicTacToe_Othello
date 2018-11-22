/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        setName(name);
        setSymbol(symbol);
    }

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setSymbol(char symbol) {
        if(symbol!= '\0'){
            this.symbol = symbol;
        }
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
