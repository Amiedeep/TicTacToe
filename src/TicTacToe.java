
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class TicTacToe extends Board implements ActionListener
{
    Player player1;
    Player player2;
    TicTacToe()
    {
        this.setTitle("zero kaanta implemented by Amie(Amandeep Singh) :D");
        player1=new Player("Amie");
        player2=new Player("Gobind");
        player1Name.setText("Player1: "+player1.name);
        player2Name.setText("Player2: "+player2.name);
        player1.sign="O";
        player2.sign="X";
        player1.turn=true;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                cell[i][j].addActionListener(this);
            }
            
        }
        bt_restart.addActionListener(this);
    }
    
    public static void main(String[] args) 
    {
        TicTacToe obj=new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e)  
    {
        if(e.getSource()==bt_restart)
        {
            new TicTacToe();
            this.dispose();
        }
        else
        {
            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++) 
                {
                    if(e.getSource()==cell[i][j])
                    {
                        if(open[i][j]==false)
                        {
                            open[i][j]=true;
                            if(player1.turn==true)
                            {
                                status.setText("Player2 turn");
                                cell[i][j].setText(player1.sign);
                                gameStatus(player1.sign);
                                player1.turn = false;
                                player2.turn = true;
                                
                            }
                            else
                            {
                                status.setText("Player1 turn");
                                cell[i][j].setText(player2.sign);
                                gameStatus(player2.sign);
                                player2.turn = false;
                                player1.turn = true;
                            }
                        }
                        else//plz select a valid box
                        {
                            JOptionPane.showMessageDialog(this,"Box already clicked");
                        }
                    }
                }
            
            }
        }
    }
    
    void gameStatus(String sign)
    {
        for (int i = 0; i < 3; i++) 
        {
            if(cell[i][0].getText()==sign && cell[i][1].getText()==sign && cell[i][2].getText()==sign)//game over player wins
            {
                if(player1.sign==sign)
                    status.setText("Player1 Wins");
                else
                    status.setText("Player2 Wins");
                gameOver();
                return;
            }
            else if(cell[0][i].getText()==sign && cell[1][i].getText()==sign && cell[2][i].getText()==sign)//game over player wins
            {
                if(player1.sign==sign)
                    status.setText("Player1 Wins");
                else
                    status.setText("Player2 Wins");
                gameOver();
                return;
            }
            
        }
            if(cell[0][0].getText()==sign && cell[1][1].getText()==sign && cell[2][2].getText()==sign)//game over player wins
            {
                if(player1.sign==sign)
                    status.setText("Player1 Wins");
                else
                    status.setText("Player2 Wins");
                gameOver();
                return;
            }
            else if(cell[0][2].getText()==sign && cell[1][1].getText()==sign && cell[2][0].getText()==sign)//game over player wins
            {
                if(player1.sign==sign)
                    status.setText("Player1 Wins");
                else
                    status.setText("Player2 Wins");
                gameOver();
                return;
            }
                stalemate();
//                if(stalemate()==true)
//                {
//                    System.out.println("comm");
//                    status.setText("Stalemate");
//                    gameOver();
//                }
    }
    
    void gameOver()
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
                cell[i][j].setEnabled(false);
        }
    }
    
    void stalemate()
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if(open[i][j]==false)
                    return;
            }
        }
        status.setText("Stalemate");
        gameOver();
    }
}
