package racingcar.model;

public class CarName {
    public static final int NAME_MAX_LENGTH = 5;
    public static final String ERROR_MESSAGE_VALID_CAR_NAME = "자동차 이름은 1자 이상 5자 이하로 입력하세요.";

    private final String name;

    public CarName(String name) {
        validLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void validLength(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_VALID_CAR_NAME);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
