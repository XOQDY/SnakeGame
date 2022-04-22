import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private Board board;
    private int boardSize;
    private int foodCount;
    private GridUI gridUI;

    public Game() {
        board = new Board(boardSize);
        gridUI = new GridUI();
        add(gridUI);
        pack();
    }

    class GridUI extends JPanel {
        public static final int CELL_PIXEL_SIZE = 30;

        private Image imageHead;
        private Image imageSnake;
        private Image imageWall;
    }

}
