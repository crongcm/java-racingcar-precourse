package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "1:1:0", "2:1:1"}, delimiter = ':')
    @DisplayName("자동차_이동_상태_비교")
    void car_compare_move_state(int position1, int position2, int expect) {
        Car crong = new Car(new CarName("crong"), new CarPosition(position1));
        Car honux = new Car(new CarName("honux"), new CarPosition(position2));
        assertThat(crong.compareTo(honux)).isEqualTo(expect);
    }

    @Test
    @DisplayName("자동차_상태_이름_하이픈_반환")
    void car_status() {
        Car car = new Car(new CarName("crong"), new CarPosition(2));
        assertThat(car.getState()).contains("crong : --");
    }

    @RepeatedTest(10)
    @DisplayName("자동차_이동")
    void move_car() {
        Car car = new Car(new CarName("crong"));
        car.moveOrStop();
        assertThat(car.getPosition().getPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("자동차_생성")
    void generate_car() {
        Car car = new Car(new CarName("crong"));
        assertThat(car.getName().getName()).isEqualTo("crong");
        assertThat(car.getPosition().getPosition()).isZero();
    }
}
