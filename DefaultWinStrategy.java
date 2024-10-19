public class DefaultWinStrategy implements WinStrategy {

    public boolean checkWin(Board board, char symbol) {
        int size = board.getSize();

        for(int i=0;i<size;i++) {
            if(checkRow(board, symbol, i) || checkColumn(board, symbol, i)) {
                return true;
            }
        }

        return checkDiagonal(board, symbol) || checkAntiDiagonal(board, symbol);
    }

    public boolean checkRow(Board board, char symbol, int row) {
        for(int i=0;i<board.getSize();i++){
            if(board.getCell(row, i) != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(Board board, char symbol, int col) {
        for(int i=0;i<board.getSize();i++) {
            if(board.getCell(i, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(Board board, char symbol) {
        for(int i=0;i<board.getSize();i++){
            if(board.getCell(i, i) != symbol) {
                return false;
            }
        }

        return true;
    }

    public boolean checkAntiDiagonal(Board board, char symbol) {
        int size = board.getSize();

        for(int i=0;i<size;i++) {
            if(board.getCell(i, size - 1 - i) != symbol) {
                return false;
            }
        }
        return true;
    }

}
