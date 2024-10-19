public class DefaultMoveStrategy implements MoveStrategy {
    public boolean isValidMove(Board board, int x, int y) {
        int size = board.getSize();
        if(x >= size || x < 0) return false;
        if(y >= size || y < 0) return false; 
        return board.getCell(x, y) == '\0';
    }
}
