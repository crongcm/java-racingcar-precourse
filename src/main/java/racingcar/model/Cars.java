package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(String inputCarNames) {
        String[] carNames = validDuplicateName(inputCarNames);
        this.cars = mapCars(carNames);
    }

    private static String[] validDuplicateName(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        Set<String> distinctCarNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != distinctCarNames.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
        return carNames;
    }

    private static List<Car> mapCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            cars.add(car);
        }
        return cars;
    }

    public PlayResult playRound() {
        PlayResult result = new PlayResult();
        for (Car car : cars) {
            car.moveOrStop();
        }
        result.roundResult(this);
        return result;
    }

    public PlayResult finishGame() {
        PlayResult result = new PlayResult();
        Winners winners = getWinners();
        result.gameResult(winners);
        return result;
    }

    public Winners getWinners() {
        CarPosition topPosition = getTopPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, topPosition);
        }
        return new Winners(winners);
    }

    private void addWinner(List<String> winners, Car car, CarPosition topPosition) {
        if (car.getPosition().equals(topPosition)) {
            winners.add(car.getName().getName());
        }
    }

    private CarPosition getTopPosition() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0).getPosition();
    }

    public List<Car> getCars() {
        return cars;
    }
}
