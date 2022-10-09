package racingcar.model;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {
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

    public String convertHyphen() {
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            moveCount.append(HYPHEN);
        }
        return moveCount.toString();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(CarPosition o) {
        return Integer.compare(this.position, o.position);
    }
}
