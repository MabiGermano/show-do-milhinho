package com.br.game.models.stagestate;

public abstract class State {
	protected Stage stage;
	
	State(Stage stage) {
        this.stage = stage;
    }

    public abstract void onChoose();
    public abstract String onTryHelp();
}
