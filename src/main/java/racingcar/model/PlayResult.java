package racingcar.model;

public class PlayResult {
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String VICTORY_PREFIX = "최종 우승자 : ";

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
        this.gameResult = VICTORY_PREFIX + winners.getWinners();
    }

    public String getRoundResult() {
        return roundResult;
    }

    public String getGameResult() {
        return gameResult;
    }
}
