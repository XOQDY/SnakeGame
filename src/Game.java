import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private Board board;
    private int boardSize;
    private int foodCount;
    private GridUI gridUI;
    private static final Color darkGreen = new Color(120,121,93);

    public Game() {
        this.boardSize = 20 + 2; // +2 for the walls
        board = new Board(boardSize);
        gridUI = new GridUI();
        add(gridUI);
        pack();
    }

    public void start() {
        setVisible(true);
    }

    class GridUI extends JPanel {
        public static final int CELL_PIXEL_SIZE = 30;

        private Image imageHead;
        private Image imageSnake;
        private Image imageWall;
        private Image imageFood;

        public GridUI() {
            setPreferredSize(new Dimension(boardSize * CELL_PIXEL_SIZE,
                    boardSize * CELL_PIXEL_SIZE));
        }

        @Override
        public void paint(Graphics graphics) {
            super.paint(graphics);
            for (int row = 0; row < boardSize; ++row) {
                for (int col = 0; col < boardSize; ++col) {
                    paintCell(graphics, row, col);
                }
            }
        }

        private void paintCell(Graphics graphics, int row, int col) {
            int x = col * CELL_PIXEL_SIZE;
            int y = (row * CELL_PIXEL_SIZE);

            Cell cell = board.getCell(row, col);

            if (cell.isWall()) {
                graphics.setColor(Color.black);
                graphics.fillRect(x, y, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);
            } else {
                graphics.setColor(darkGreen);
                graphics.fillRect(x, y, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
