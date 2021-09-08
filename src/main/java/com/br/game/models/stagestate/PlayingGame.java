package com.br.game.models.stagestate;

import com.br.game.models.Question;
import com.br.game.repositories.QuestionRepository;

public class PlayingGame extends State {

	public PlayingGame(Stage stage) {
		super(stage);
	}

	@Override
	public void onChoose() {
		String currentAnswer = this.stage.getCurrentAnswer();
		if (currentAnswer == null) {
			throw new RuntimeException("It must have an answer");
		}

		if (this.stage.getCurrentQuestion().getRightAnswer().equals(currentAnswer)) {
			QuestionRepository repository = new QuestionRepository();
			Question nextQuestion = repository.findByRandomId();

			this.stage.getQuestionsAnswered().add(this.stage.getCurrentQuestion());

			this.stage.setCurrentQuestion(nextQuestion);
			this.stage.setCurrentAnswer(null);
		} else {
			this.stage.setPlaying(false);
		}
	}

	@Override
	public String onTryHelp() {
		if (this.stage.getGameMode().itHasTip()) {
			return this.stage.getCurrentQuestion().getTip();
		}
		return "There are no Tip to this Game mode";
	}

}
