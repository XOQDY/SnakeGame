import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {

    private Snake snake;
    private Board board;
    private int boardSize;
    private int mid;
    private int half;
    private int foodCount;
    private GridUI gridUI;
    private static final Color darkGreen = new Color(120,121,93);

    public Game() {
        this.boardSize = 19 + 2; // +2 for the walls
        this.mid = boardSize / 2;
        this.half = (mid + 1) / 2;
        snake = new Snake(mid, half);
        for (int i = 3; i >= 0; --i) {
            snake.addSnake(board.getCell(half, half - i));
        }
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

    class Controller extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                snake.up();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                snake.down();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                snake.left();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.right();
            }
        }
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
