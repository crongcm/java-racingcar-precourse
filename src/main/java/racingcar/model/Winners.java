package racingcar.model;

import java.util.List;

public class Winners {
    private final List<String> winners;

    public Winners(List<String> carNames) {
        this.winners = carNames;
    }

    public String getWinners() {
        return String.join(", ", winners);
    }
}
