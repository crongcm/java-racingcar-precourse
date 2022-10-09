package racingcar.model;

import racingcar.util.Message;

public class PlayResult {
    public static final String LINE_SEPARATOR = "line.separator";

    private String roundResult;
    private String gameResult;

    public void roundResult(Cars cars) {
        StringBuilder roundState = new StringBuilder();
        for (Car car : cars.getCars()) {
            roundState.append(car.getState());
            roundState.append(System.getProperty(LINE_SEPARATOR));
        }
        this.roundResult = roundState.toString();
    }

    public void gameResult(Winners winners) {
        this.gameResult = Message.VICTORY_PREFIX.getMessage() + winners.getWinners();
    }

    public String getRoundResult() {
        return roundResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
