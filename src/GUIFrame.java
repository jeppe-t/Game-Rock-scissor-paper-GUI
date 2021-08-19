import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame{

    Game game;
    Computer computer;
    Player player;
    JButton rock;
    JButton scissor;
    JButton paper;
    JLabel chooseLabel;
    JLabel resultLabel;
    JLabel playerLabel;
    JLabel computerLabel;
    JLabel computerScoreLabel;
    JLabel playerScoreLabel;
    JLabel drawScoreLabel;

    public GUIFrame(String title){
        super(title);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(150,500);

        computer = new Computer();
        player = new Player();
        game = new Game();

        getContentPane().setLayout(new FlowLayout());

        addComponents();

        rock.addActionListener(new ActionListener() {
            @Override
            //You choose rock

            public void actionPerformed(ActionEvent e) {

                if(computer.getComputerChoose() == 1){
                    playerLabel.setText("Player Choose: " + Choosing.ROCK);
                    computerLabel.setText("Computer choose: " + Choosing.ROCK);
                    resultLabel.setText("Its a draw!!!");
                    game.addDraw();
                } else if(computer.getComputerChoose() == 2){
                    playerLabel.setText("Player Choose: " + Choosing.ROCK);
                    computerLabel.setText("Computer choose: " + Choosing.SCISSOR);
                    resultLabel.setText("You won the round man!!!");
                    player.addPlayerScore();
                }else if(computer.getComputerChoose() == 3){
                    playerLabel.setText("Player Choose: " + Choosing.ROCK);
                    computerLabel.setText("Computer choose: " + Choosing.PAPER);
                    resultLabel.setText("Damn, you lost the round!!!");
                    computer.addComputerScore();
                }
                nextRound();
            }
        });
        scissor.addActionListener(new ActionListener() {
            @Override
            //You choose Scissor

            public void actionPerformed(ActionEvent e) {

                if(computer.getComputerChoose() == 1){
                    playerLabel.setText("Player Choose: " + Choosing.SCISSOR);
                    computerLabel.setText("Computer choose: " + Choosing.ROCK);
                    resultLabel.setText("Damn, you lost the round!!!");
                    computer.addComputerScore();
                } else if(computer.getComputerChoose() == 2){
                    playerLabel.setText("Player Choose: " + Choosing.SCISSOR);
                    computerLabel.setText("Computer choose: " + Choosing.SCISSOR);
                    resultLabel.setText("Its a draw!!!");
                    game.addDraw();
                }else if(computer.getComputerChoose() == 3){
                    playerLabel.setText("Player Choose: " + Choosing.SCISSOR);
                    computerLabel.setText("Computer choose: " + Choosing.PAPER);
                    resultLabel.setText("You won the round man!!!");
                    player.addPlayerScore();
                }
                nextRound();
            }
        });
        paper.addActionListener(new ActionListener() {
            @Override
            //You choose paper

            public void actionPerformed(ActionEvent e) {

                if(computer.getComputerChoose() == 1){
                    playerLabel.setText("Player Choose: " + Choosing.PAPER);
                    computerLabel.setText("Computer choose: " + Choosing.ROCK);
                    resultLabel.setText("You won the round man!!!");
                    player.addPlayerScore();
                } else if(computer.getComputerChoose() == 2){
                    playerLabel.setText("Player Choose: " + Choosing.PAPER);
                    computerLabel.setText("Computer choose: " + Choosing.SCISSOR);
                    resultLabel.setText("Damn, you lost the round!!!");
                    computer.addComputerScore();
                }else if(computer.getComputerChoose() == 3){
                    playerLabel.setText("Player Choose: " + Choosing.PAPER);
                    computerLabel.setText("Computer choose: " + Choosing.PAPER);
                    resultLabel.setText("Its a draw!!!");
                    game.addDraw();
                }
                nextRound();
            }

        });



    }

    void addComponents(){

        chooseLabel = new JLabel("Round: " + game.getRound() + " Please choose. ");
        getContentPane().add(chooseLabel);

        rock = new JButton("Rock ");
        getContentPane().add(rock);

        scissor = new JButton("Scissor ");
        getContentPane().add(scissor);

        paper = new JButton("Paper ");
        getContentPane().add(paper);

        playerLabel = new JLabel("Players choice: ");
        getContentPane().add(playerLabel);

        computerLabel = new JLabel("Computers choice: ");
        getContentPane().add(computerLabel);

        resultLabel = new JLabel("Result:   ");
        getContentPane().add(resultLabel);

        computerScoreLabel = new JLabel("Computer Score: " + computer.getComputerScore());
        getContentPane().add(computerScoreLabel);

        playerScoreLabel = new JLabel("Player Score: " + player.getPlayerScore() + "              " );
        getContentPane().add(playerScoreLabel);

        drawScoreLabel = new JLabel("Draws: " + game.getDraw());
        getContentPane().add(drawScoreLabel);





    }


    void nextRound(){

        game.addRound();

        chooseLabel.setText("Round " + game.getRound() + " Please choose.");
        playerScoreLabel.setText("Player Score: " + player.getPlayerScore());
        computerScoreLabel.setText("Computer Score: " + computer.getComputerScore());
        drawScoreLabel.setText("Draw: " + game.getDraw());
        getContentPane();

        if(player.getPlayerScore() == 2){
            JOptionPane.showMessageDialog(null, "CONGRATULATIONS - You won the game!!!");
            resetScore();

        } else if(computer.getComputerScore() == 2){
            JOptionPane.showMessageDialog(null, "Damn, you lost the game!!!\nBetter luck next time!!!");
            resetScore();
        }


    }

    void resetScore(){

        player.resetScore();
        computer.resetScore();
        game.resetScore();
        playerScoreLabel.setText("Player Score: " + player.getPlayerScore());
        computerScoreLabel.setText("Computer Score: " + computer.getComputerScore());
        drawScoreLabel.setText("Draw: " + game.getDraw());
        playerLabel.setText("Players choice: ");
        computerLabel.setText("Computers choice: ");
        resultLabel.setText("Result:   ");




    }



}
