package racingcar.model;

import java.util.Objects;
import racingcar.util.RandomNumber;

public class Car implements Comparable<Car> {
    public static final int MOVE_CRITERIA = 4;
    public static final String CAR_STATE_SEPARATOR = " : ";

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

    public String getState() {
        return this.getName().getName() + CAR_STATE_SEPARATOR + this.getPosition().convertHyphen();
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
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
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car car) {
        return this.position.compareTo(car.position);
    }
}
