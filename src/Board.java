import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Board extends Observable {

    private Cell [][] cells;
    private int size;
    private Snake snake;
    public boolean gameOver;

    public Board(int size) {
        this.size = size;
        this.gameOver = false;
        start();
    }

    public void start() {
        initCell();
        initObject();
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

    private void initObject() {
        int mid = size / 2;
        int half = (mid + 1) / 2;
        int rightHalf = ((mid - 1) + size) / 2;

        cells[mid][half].setHead(true);
        for (int i = 0; i < 3; ++i) {
            cells[mid][half - i].setSnake(true);
        }
//        for (int i = 3; i >= 0; --i) {
//            snake.addCell(cells[mid][half - i]);
//        }

        cells[mid][rightHalf].setFood(true);
    }

    private boolean isCovered(int row, int col) {
        Cell cell = getCell(row, col);
        return cell == null || !cell.isHead() || !cell.isSnake();
    }

    public void generateFood() {
        Random random = new Random();
        int resultY = random.nextInt(size - 1) + 1; // random number between 1 to size
        int resultX = random.nextInt(size - 1) + 1;

        while (!isCovered(resultY, resultX)) {
            resultY = random.nextInt(size - 1) + 1; // random number between 1 to size
            resultX = random.nextInt(size - 1) + 1;
        }

        cells[resultY][resultX].setFood(true);
    }

    public Snake getSnake() {
        return snake;
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            return null;
        }
        return cells[row][col];
    }
}
