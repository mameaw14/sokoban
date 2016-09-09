/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author cpe-ku
 */
public class GameBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     
    private int height;
    private int width;
    private String[] baseBoard;
 
    private int playerRow;
    private int playerCol;
 
    private int numBoxes;
    private int[] boxRows;
    private int[] boxCols;
 
    public GameBoard(String[] map) {
        loadBoard(map);
    }
 
    public void loadBoard(String[] map) {
        height = map.length;
        width = map[0].length();
        numBoxes = 0;
        boxRows = new int[height*width];
        boxCols = new int[height*width];
 
        baseBoard = new String[height];
        for(int r = 0; r < height; r++) {
            baseBoard[r] = "";
            for(int c = 0; c < width; c++) {
                char mch = map[r].charAt(c);
                char sch = '.';
                switch(mch) {
                case 'A': 
                    playerRow = r;
                    playerCol = c;
                    break;
                case 'O':
                    boxRows[numBoxes] = r;
                    boxCols[numBoxes] = c;
                    numBoxes++;
                    break;
                default:
                    sch = mch;
                }
                baseBoard[r] += sch;
            }
        }
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
 
    public int getPlayerRow() {
        return playerRow;
    }
 
    public int getPlayerCol() {
        return playerCol;
    }
 
    public void setPlayerPosition(int r, int c) {
        playerRow = r;
        playerCol = c;
    }
 
    public int getNumBoxes() {
        return numBoxes;
    }
 
    public int[] getBoxPosition(int i) {
        return new int[] { 
                boxRows[i],
                boxCols[i]
        };
    }
 
    public void setBoxPosition(int i, int r, int c) {
        boxRows[i] = r;
        boxCols[i] = c;
    }
 
    public boolean hasPlayerAt(int r, int c) {
        return (playerRow == r) && (playerCol == c);
    }
 
    public boolean hasBoxAt(int r, int c) {
        for(int i =0;i<numBoxes;i++){
            if(boxRows[i]==r && boxCols[i]==c) return true;
        }
        return false;
    }
 
    public boolean hasExitAt(int r, int c) {
        if(r<0||c<0||r>=height||c>=width) return false;
        return baseBoard[r].charAt(c) == '*';
    }
 
    public String toString() {
        return "";
    }

}
