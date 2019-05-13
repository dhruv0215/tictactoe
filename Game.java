import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel _statusPanel, _actionPanel;
    private JLabel _statusLabel;
    private JButton _resetButton;
    private Board _board;
    private static Player _player1, _player2, _curPlayer;

    public Game(){
        setTitle("Tic-tac-toe");
        setSize(400,400);
        
        // Status panel
        _statusPanel = new JPanel();
        _statusLabel = new JLabel(_player1._name+"'s turn");
        _statusPanel.add(_statusLabel);
        _statusPanel.setBackground(Color.lightGray);
        add(_statusPanel, BorderLayout.NORTH);
        
        // action panel
        _actionPanel = new JPanel();
        _resetButton = new JButton("Reset");
        _resetButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                _board.reset();
            } 
        } );
        _actionPanel.add(_resetButton);
        _actionPanel.setBackground(Color.lightGray);
        add(_actionPanel, BorderLayout.SOUTH);

        _board = new Board();
        add(_board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = _board._cells[i][j];
                button.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        move(button);
                    } 
                } );
            }
        }
    }

    public void move(JButton button){
        if(button.getText() == CellType.EMPTY.toString()){
            button.setText(_curPlayer._type.toString());
            _curPlayer = (_curPlayer == _player1) ? _player2 : _player1;
            _statusLabel.setText(_curPlayer._name+"'s turn");
        }
    }
    public static void main(String[] args) {
        _player1 = new Player(args[0], CellType.CROSS);
        _player2 = new Player(args[1], CellType.CIRCLE);
        _curPlayer = _player1;
        new Game();
    }
}