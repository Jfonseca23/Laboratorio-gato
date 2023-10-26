public class Board {
    
  
    private char[][] board;
    
    /**
     * Se define la matriz tablero que va tener una dimension de 3x3 
     */
    public Board() {
        board = new char[3][3];
        initializeBoard();
    }
    /**
     *  Se crea el metodo para inicializar el tablero
     */
    public void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }
    
    /**
     * Se crea el metodo para recorrer la matriz y mostrar el tablero
     */
     public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }
    /**
     * Este metodo verifica si la matriz esta vacia
     * @param row
     * @param col
     * @return 
     */
     public boolean isCellEmpty(int row, int col) {
        return (board[row][col] == ' ');
    }
    /**
     * Este metodo verifica si la matriz esta llena
     * @return 
     */
    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Este metodo coloca el simbolo en una celda especifica
     * @param row
     * @param col
     * @param symbol 
     */
    public void placeSymbol(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
    /**
     * Este metodo proporciona el simbolo
     * @param row
     * @param col
     * @return 
     */
    public char getSymbol(int row, int col) {
        return board[row][col];
    }

}

     
     
     
     
     
     
     
     





