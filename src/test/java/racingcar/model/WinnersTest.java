package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("pobi");
    }

    @Test
    @DisplayName("우승자_한명")
    void one_winner() {
        assertThat(new Winners(carNames).getWinners()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자_두명_이상_,로_구분")
    void more_than_two_winner() {
        carNames.add("crong");
        assertThat(new Winners(carNames).getWinners()).isEqualTo("pobi, crong");
        carNames.add("honux");
        assertThat(new Winners(carNames).getWinners()).isEqualTo("pobi, crong, honux");
    }
}