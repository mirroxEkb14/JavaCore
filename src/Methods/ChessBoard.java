package Methods;

public class ChessBoard {

    public static void main(String[] args) {
        String[][] chessBoard = new String[8][8];
        for (int row = 0; row < chessBoard.length; row++) {
            for (int column = 0; column < chessBoard[row].length; column++) {
                if (row % 2 == 0) {
                    chessBoard[row][column] = column % 2 == 0? "white": "black";
                } else {
                    chessBoard[row][column] = column % 2 == 0? "black": "white";
                }
            }
        }
        print2DArray(chessBoard);
    }

    public static void print2DArray(String[][] array) {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                string = string + array[i][j] + " ";
            }
            System.out.println(string);
            string = "";
        }
    }
}
