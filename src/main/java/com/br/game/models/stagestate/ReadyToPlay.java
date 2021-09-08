package com.br.game.models.stagestate;

import com.br.game.models.Question;
import com.br.game.repositories.QuestionRepository;

public class ReadyToPlay extends State {

	public ReadyToPlay(Stage stage) {
		super(stage);
	}

	@Override
	public void onChoose() {
		QuestionRepository repository = new QuestionRepository();
		Question nextQuestion = repository.findByRandomId();
		this.stage.setCurrentQuestion(nextQuestion);
		this.stage.changeState(new PlayingGame(this.stage));
	}

	@Override
	public String onTryHelp() {
		return "Clicking here you may have a Tip when you're playing a game. "
				+ "But only if the game mode is able to tip. "
				+ "Good luck";
	}
}
