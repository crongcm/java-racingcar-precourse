package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "we", "leo", "tony", "crong"})
    @DisplayName("자동차_이름_5자_이하_검증_성공")
    void car_name_test_less_than_5_characters_valid_success(String name) {
        CarName carName = new CarName(name);
        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차_이름_5자_이하_검증_에러")
    void car_name_test_less_than_5_characters_valid_error() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarName.ERROR_MESSAGE_VALID_CAR_NAME);
        assertThatThrownBy(() -> new CarName("sonata"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarName.ERROR_MESSAGE_VALID_CAR_NAME);
    }
}
