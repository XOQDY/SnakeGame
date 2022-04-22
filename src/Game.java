import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    private Board board;
    private int boardSize;
    private int foodCount;
    private GridUI gridUI;
    private static final Color darkGreen = new Color(120,121,93);

    public Game() {
        this.boardSize = 19 + 2; // +2 for the walls
        board = new Board(boardSize);
        gridUI = new GridUI();
        add(gridUI);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        private JButton foodButton = new JButton("Generate Food");

        public GridUI() {
            setPreferredSize(new Dimension(boardSize * CELL_PIXEL_SIZE,
                    boardSize * CELL_PIXEL_SIZE));
//            this.add(foodButton);
//            foodButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    board.generateFood();
//                    repaint();
//                }
//            });
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

            graphics.setColor(darkGreen);
            graphics.fillRect(x, y, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);

            if (cell.isWall() || cell.isSnake()) {
                graphics.setColor(Color.black);
                graphics.fillRect(x, y, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);
            } else if (cell.isFood()) {
                graphics.setColor(Color.black);
                graphics.drawRect(x + 2, y + 2, CELL_PIXEL_SIZE - 4, CELL_PIXEL_SIZE - 4);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
