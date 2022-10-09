package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarPositionTest {
    @Test
    @DisplayName("자동차_위치_생성")
    void create_car_position() {
        CarPosition carPosition = new CarPosition();
        assertThat(carPosition.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차_전진")
    void move_forward() {
        CarPosition carPosition = new CarPosition();
        CarPosition movePosition = carPosition.moveForward();
        assertThat(carPosition.getPosition()).isZero();
        assertThat(movePosition.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    @DisplayName("자동차_위치_수_하이픈_반환")
    void car_position(int position, String hyphen) {
        CarPosition carPosition = new CarPosition(position);
        assertThat(carPosition.convertHyphen()).isEqualTo(hyphen);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "1:1:0", "2:1:1"}, delimiter = ':')
    @DisplayName("자동차_위치_비교")
    void car_compare_position(int position1, int position2, int expect) {
        CarPosition carPosition1 = new CarPosition(position1);
        CarPosition carPosition2 = new CarPosition(position2);
        assertThat(carPosition1.compareTo(carPosition2)).isEqualTo(expect);
    }
}
