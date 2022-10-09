package racingcar.model;

import racingcar.util.Message;

public class GameRound {
    private final int round;

    public GameRound(String inputRound) {
        validNumeric(inputRound);
        int intRound = convertInt(inputRound);
        validZero(intRound);
        this.round = intRound;
    }

    private static int convertInt(String inputRound) {
        return Integer.parseInt(inputRound);
    }

    private void validNumeric(String inputRound) {
        if (isNoneNumeric(inputRound)) {
            throw new IllegalArgumentException(Message.ERROR_ROUND_IS_NONE_NUMERIC.getMessage());
        }
    }

    private static void validZero(int intRound) {
        if (isZero(intRound)) {
            throw new IllegalArgumentException(Message.ERROR_ROUND_IS_ZERO.getMessage());
        }
    }

    private boolean isNoneNumeric(String inputRound) {
        return !inputRound.chars().allMatch(Character::isDigit);
    }

    private static boolean isZero(int intRound) {
        return intRound == 0;
    }

    public int getRound() {
        return round;
    }
}
