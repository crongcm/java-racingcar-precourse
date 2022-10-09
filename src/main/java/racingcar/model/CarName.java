package racingcar.model;

import racingcar.util.Message;

public class CarName {
    public static final int NAME_MAX_LENGTH = 5;

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
            throw new IllegalArgumentException(Message.ERROR_VALID_CAR_NAME.getMessage());
        }
    }
}
