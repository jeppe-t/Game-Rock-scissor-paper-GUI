public class Player {

    private String rock;
    private String Scissor;
    private String paper;

    private int playerScore;

    public Player(){



    }

    void addPlayerScore(){
        playerScore++;

    }

    public int getPlayerScore() {
        return playerScore;
    }

    void resetScore(){
        playerScore = 0;
    }


}
