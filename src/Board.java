public class Board {

    private Cell [][] cells;
    private int size;

    public Board(int size) {
        this.size = size;
        initCell();
    }

    private void initCell() {
        cells = new Cell[size][size];
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                cells[row][col] = new Cell();
                if (row == 0 || row == size-1 || col == 0 || col == size-1) {
                    cells[row][col].setWall(true);
                }
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            return null;
        }
        return cells[row][col];
    }
}
