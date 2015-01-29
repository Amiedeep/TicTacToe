
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board extends JFrame
{
    JButton[][] cell;
    JLabel status;
    JButton bt_restart;
    JPanel panel;
    boolean open[][];
    JLabel player1Name;
    JLabel player2Name;
    Board()
    {
        open=new boolean[3][3];
        cell=new JButton[3][3];
        player1Name = new JLabel();
        player2Name = new JLabel();
        bt_restart = new JButton("New Game");
        panel=new JPanel();
        panel.setLayout(null);
        
        status=new JLabel("Player1 turn");
        bt_restart=new JButton("restart");
        this.setLayout(null);
        
        status.setBounds(140, 0, 150, 50);
        player1Name.setBounds(0, 0, 140, 50);
        player2Name.setBounds(280, 0, 140, 50);
        bt_restart.setBounds(100, 50, 150, 50);
        panel.setBounds(50, 50, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int x=100;
        int y=100;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                cell[i][j]=new JButton("");
                cell[i][j].setBounds(x, y, 50, 50);
                x=x+50;
                cell[i][j].setVisible(true);
                
                panel.add(cell[i][j]);
                
            }
            x=100;
            y=y+50;
        }
        panel.add(status);
        panel.add(player2Name);
        panel.add(player1Name);
        panel.add(bt_restart);
        
        panel.setVisible(true);
        add(panel);
        this.setVisible(true);
        this.setSize(450, 400);
        
    }
}
