package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberTest {
    @RepeatedTest(10)
    @DisplayName("랜덤_수_생성")
    void generate_random_number() {
        RandomNumber number = new RandomNumber();
        assertThat(number.getNumber()).isGreaterThanOrEqualTo(RandomNumber.MIN_RANDOM_NUMBER);
        assertThat(number.getNumber()).isLessThanOrEqualTo(RandomNumber.MAX_RANDOM_NUMBER);
    }
}
