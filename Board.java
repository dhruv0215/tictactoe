import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final int rows = 3;
    public static final int columns = 3;
    JButton[][] _cells;

    public Board() {
        _cells = new JButton[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                _cells[i][j] = new JButton(CellType.EMPTY.toString());
                JButton button = _cells[i][j];
                add(button);
            }
        }
        setLayout(new GridLayout(rows, columns));
    }

    public void reset(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(_cells[i][j].getText() != CellType.EMPTY.toString()){
                    _cells[i][j].setText(CellType.EMPTY.toString());
                }
            }
        }
    }
}