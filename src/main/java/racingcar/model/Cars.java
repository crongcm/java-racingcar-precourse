package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.Message;

public class Cars {
    public static final int MINIMUM_PARTICIPATE_CAR_COUNT = 2;
    public static final String CAR_NAME_SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        validDuplicateSeparator(inputCarNames);
        String[] carNames = validDuplicateName(inputCarNames);
        validParticipateCarCount(carNames);
        this.cars = mapCars(carNames);
    }

    private void validParticipateCarCount(String[] carNames) {
        if (carNames.length < MINIMUM_PARTICIPATE_CAR_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_MINIMUM_PARTICIPATE_CAR.getMessage());
        }
    }

    private void validDuplicateSeparator(String inputCarNames) {
        if (inputCarNames.contains(",,")) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_DUPLICATE_SEPARATOR.getMessage());
        }
    }

    private String[] validDuplicateName(String inputCarNames) {
        String[] carNames = inputCarNames.split(CAR_NAME_SEPARATOR);
        Set<String> distinctCarNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != distinctCarNames.size()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_DUPLICATE.getMessage());
        }
        return carNames;
    }

    private List<Car> mapCars(String[] carNames) {
        List<Car> newCars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            newCars.add(car);
        }
        return newCars;
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
