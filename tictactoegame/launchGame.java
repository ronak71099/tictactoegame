package tictactoegame;

import java.util.Scanner;

class TicTacToe{
    static char[][] board;
    public TicTacToe(){
        board = new char[3][3];
        initBoard();
    }
    void initBoard(){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=' ';
            }
        }
    }
    static void displayBoard(){
        System.out.println("-------------");
        for(int i=0;i< board.length;i++){
            System.out.print("| ");
            for (int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static void disMark(int row,int col,char mark){
        if((row>=0&&row<=2)&&(col>=0&&col<=2)){
            board[row][col] = mark;
        }
        else
            System.out.println("invalid input");
    }
    static boolean checkColWin(){
        for(int j=0;j<=2;j++){
            if(board[0][j]!=' '&&board[0][j]==board[1][j] && board[1][j]==board[2][j])
                return true;
        }
        return false;
    }
    static boolean checkRowWin(){
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' '&&board[i][0]==board[i][1] && board[i][1]==board[i][2])
                return true;
        }
        return false;
    }
    static boolean checkDiaWin(){
            if((board[0][0]!=' '&&board[0][0]==board[1][1] && board[1][1]==board[2][2])||(board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]))
                return true;
            else
                return false;
    }
    static boolean checkDraw(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

}
class humanMove{
    String name;
    char mark;
    humanMove(String name,char mark){
        this.name = name;
        this.mark = mark;
    }
    void makeMove(){
        Scanner scan = new Scanner(System.in);
        int row,col;
        do {
            System.out.println("Enter the row : ");
            row = scan.nextInt();
            System.out.println("Enter the column : ");
            col = scan.nextInt();
        }while(!(isValidMove(row,col)));
           TicTacToe.disMark(row,col,mark);

    }
    boolean isValidMove(int row,int col){
        if(row>=0&&row<=2&&col>=0&&col<=2){
            if(TicTacToe.board[row][col]==' '){
                return true;
            }
        }
        return false;
    }
}
public class launchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        humanMove h1 = new humanMove("Bob",'x');
        humanMove h2 = new humanMove("Raj",'o');
        humanMove cp;
        cp=h1;
        while (true){
            System.out.println(cp.name + " turn");
            cp.makeMove();
            TicTacToe.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiaWin()) {
                System.out.println(cp.name + " has won");
                break;
            } else if (TicTacToe.checkDraw()) {
                System.out.println("It's a draw");
                break;

            } else{
                if(cp==h1){
                    cp=h2;
                }
                else{
                    cp=h1;
                }
            }
        }
    }
}
