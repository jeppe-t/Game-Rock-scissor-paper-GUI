import java.util.Random;

public class Computer {

    private int computerChoose;
    private int computerScore;


    public Computer(){


        Random random = new Random();

        computerChoose = random.nextInt(3) +1;

        //If random returns:
        // nr. 1 = rock
        // nr. 2 = scissor
        // nr. 3 = paper



    }

    void addComputerScore(){
        computerScore++;

    }

    void resetScore(){
       computerScore = 0;
    }

    public int getComputerChoose() {
        return computerChoose;
    }

    public int getComputerScore() {
        return computerScore;
    }



}
