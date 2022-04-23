import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private Cell [][] cells;
    private List<Cell> snakes = new ArrayList<>();
    private int size;
    private Snake snake;
    private int snakeLength = 3;
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

        snake = new Snake(half, mid);
        for (int i = snakeLength; i >= 0; --i) {
            cells[mid][half - i].setSnake(true);
            snakes.add(cells[mid][half - i]);
        }

        cells[mid][rightHalf].setFood(true);
    }

    private boolean isCovered(int row, int col) {
        Cell cell = getCell(row, col);
        return cell == null || !cell.isSnake();
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

    public void move() {
        snake.move();
        Cell next = getCell(snake.getY(), snake.getX());

        if (next.isWall() || next.isSnake()) {
            gameOver = true;
        } else {
            if (next.isFood()) {
                ++snakeLength;
                next.setFood(false);
                generateFood();
            } else {
                Cell tail = getTailSnakes();
                tail.setSnake(false);
                snakes.remove(0);
            }
            next.setSnake(true);
            add(snakeLength, next);
        }
    }

    public void add(int index, Cell cell) {
        snakes.add(index, cell);
    }

    public Cell getTailSnakes() {
        return snakes.get(0);
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            return null;
        }
        return cells[row][col];
    }
}
