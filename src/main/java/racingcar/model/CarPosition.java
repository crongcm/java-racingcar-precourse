package racingcar.model;

public class CarPosition {
    public static final int START_POSITION = 0;
    public static final String HYPHEN = "-";

    private final int position;

    public CarPosition() {
        this.position = START_POSITION;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition moveForward() {
        return new CarPosition(this.position + 1);
    }

    public int getPosition() {
        return position;
    }

    public String convertHyphen() {
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            moveCount.append(HYPHEN);
        }
        return moveCount.toString();
    }
}
