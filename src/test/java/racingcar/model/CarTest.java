package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차_이름_하이픈_반환")
    void car_status() {
        Car car = new Car(new CarName("crong"), new CarPosition(2));
        assertThat(car.toString()).contains("crong : --");
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
