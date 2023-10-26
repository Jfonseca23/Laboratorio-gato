import java.util.Scanner;
/**
 * La clase Tictac_toe es la clase principal que representa el juego de Tres 
 * en línea (Tic-Tac-Toe).
 */
public class Tictac_toe {
    private Player player1;
    private Player player2;
    private Board board;
    private Player playerTurn;

    /**
     * Constructor de la clase que inicializa el juego con los nombres de los 
     * jugadores.
     * @param player1Name Nombre del primer jugador.
     * @param player2Name Nombre del segundo jugador.
     */
    public Tictac_toe(String player1Name, String player2Name) {
        player1 = new Player(player1Name, 'X');
        player2 = new Player(player2Name, 'O');
        board = new Board();
        playerTurn = player1;
    }

    /**
     * Cambia el turno de juego al otro jugador.
     */
    public void switchPlayer() {
        if (playerTurn == player1) {
            playerTurn = player2;
        } else {
            playerTurn = player1;
        }
    }

    /**
     * Inicia el juego y controla el flujo del juego.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Turno actual:");
            board.printBoard();
            System.out.println(playerTurn.getName() + ", Indique un numero de "
                    + "fila entre 0 y 2 y una columna entre 0 y 2: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty
        (row, col)) {
                board.placeSymbol(row, col, playerTurn.getSymbol());

                if (checkWin(row, col)) {
                    System.out.println("Turno actual:");
                    board.printBoard();
                    System.out.println(playerTurn.getName() + " gano!");
                    gameOver = true;
                } else if (board.isFull()) {
                    System.out.println("Turno actual:");
                    board.printBoard();
                    System.out.println("¡Es un empate!");
                    gameOver = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Movimiento inválido, indique otro.");
            }
        }
        scanner.close();
    }

    /**
     * Comprueba si el jugador actual ha ganado después de realizar 
     * un movimiento.
     * @param row Fila en la que se hizo el último movimiento.
     * @param col Columna en la que se hizo el último movimiento.
     * @return Verdadero si el jugador actual ha ganado, falso en caso 
     * contrario.
     */
    public boolean checkWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals() ||
                checkAntiDiagonals();
    }

    /**
     * Comprueba si el jugador actual ha ganado en una fila específica.
     * @param row Fila que se está verificando.
     * @return Verdadero si el jugador actual ha ganado en la fila dada, falso
     * en caso contrario.
     */
    public boolean checkRow(int row) {
        return (board.getSymbol(row, 0) == playerTurn.getSymbol() &&
                board.getSymbol(row, 1) == playerTurn.getSymbol() &&
                board.getSymbol(row, 2) == playerTurn.getSymbol());
    }

    /**
     * Comprueba si el jugador actual ha ganado en una columna específica.
     * @param col Columna que se está verificando.
     * @return Verdadero si el jugador actual ha ganado en la columna dada, 
     * falso en caso contrario.
     */
    public boolean checkColumn(int col) {
        return (board.getSymbol(0, col) == playerTurn.getSymbol() &&
                board.getSymbol(1, col) == playerTurn.getSymbol() &&
                board.getSymbol(2, col) == playerTurn.getSymbol());
    }

    /**
     * Comprueba si el jugador actual ha ganado en las diagonales.
     * @return Verdadero si el jugador actual ha ganado en las diagonales, falso
     * en caso contrario.
     */
    public boolean checkDiagonals() {
        return (board.getSymbol(0, 0) == playerTurn.getSymbol() &&
                board.getSymbol(1, 1) == playerTurn.getSymbol() &&
                board.getSymbol(2, 2) == playerTurn.getSymbol());
    }

    /**
     * Comprueba si el jugador actual ha ganado en las antidiagonales.
     * @return Verdadero si el jugador actual ha ganado en las antidiagonales, 
     * falso en caso contrario.
     */
    public boolean checkAntiDiagonals() {
        return (board.getSymbol(0, 2) == playerTurn.getSymbol() &&
                board.getSymbol(1, 1) == playerTurn.getSymbol() &&
                board.getSymbol(2, 0) == playerTurn.getSymbol());
    }

    /**
     * Método principal que inicia el juego.
     * @param args Los argumentos de la línea de comandos (no se utilizan en 
     * este juego).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indique el nombre del jugador 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Indique el nombre del jugador 2: ");
        String player2Name = scanner.nextLine();

        Tictac_toe game = new Tictac_toe(player1Name, player2Name);
        game.play();
        scanner.close();
    }
}