public class Game {

    private int round;
    private int draw;

    void addDraw(){
        draw++;
    }

    public int getDraw() {
        return draw;
    }

    void addRound(){
        round++;
    }

    public int getRound() {
        return round +1;
    }

    void resetScore(){
        draw = 0;
    }
}
