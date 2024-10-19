import java.util.Scanner;

public class TickTacToe {
    
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private MoveStrategy moveStrategy;
    private WinStrategy winStrategy;

    public TickTacToe() {
        board = new Board(3);
        player1 = PlayerFactory.createPlayer('X');
        player2 = PlayerFactory.createPlayer('0');
        currentPlayer = player1;
        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();
        board.addObserver(player1);
        board.addObserver(player2);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Player "+currentPlayer.getSymbol() + "'s turn");
            System.out.println("Enter row (0, 1, or 2) : ");
            int x = scanner.nextInt();
            System.out.println("Enter column (0, 1, or 2) : ");
            int y = scanner.nextInt();

            // validate move
            if(moveStrategy.isValidMove(board, x, y)) {
                board.updateBoard(x, y, currentPlayer.getSymbol());

                // chec if win
                if(winStrategy.checkWin(board, currentPlayer.getSymbol())){
                    System.out.println("Player "+ currentPlayer.getSymbol() + " wins!");
                    break;
                }

                // check for draw
                if(isDraw()) {
                    System.out.println("Game is a draw!");
                    break;
                }

                printState(board);
                switchPlayer();
            } else {
                System.out.println("Invalid move! Try again");
            }
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isDraw() {
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getCell(i, j) == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printState(Board board) {
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                System.out.print("  " + board.getCell(i, j) + " ");
            }
            System.out.println("");
            System.out.println(" -------------- ");
        }
    }

    public static void main(String[] args) {
        TickTacToe game = new TickTacToe();
        game.playGame();
    }
}
