package racingcar.model;

public class GameRound {
    public static final String ERROR_MESSAGE_ROUND_IS_NONE_NUMERIC = "시도 횟수는 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_ROUND_IS_ZERO = "시도 횟수는 0이상으로 입력해주세요.";

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
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_IS_NONE_NUMERIC);
        }
    }

    private static void validZero(int intRound) {
        if (isZero(intRound)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_IS_ZERO);
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
