package com.br.game.models.stagestate;

public abstract class State {
	private Stage stage;
	
	State(Stage stage) {
        this.stage = stage;
    }

    public abstract String onChoose();
    public abstract String onTryHelp();
}
