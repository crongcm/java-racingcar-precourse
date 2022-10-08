package racingcar.model;

import racingcar.util.RandomNumber;

public class Car {
    public static final int MOVE_CRITERIA = 4;

    private final CarName name;
    private CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public void moveOrStop() {
        RandomNumber randomNumber = new RandomNumber();
        if (randomNumber.getNumber() >= MOVE_CRITERIA) {
            position = position.moveForward();
        }
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.getName().toString() + " : " + this.getPosition().toString();
    }
}
