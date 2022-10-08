package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    private final int number;

    public RandomNumber() {
        this.number = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public int getNumber() {
        return number;
    }
}
