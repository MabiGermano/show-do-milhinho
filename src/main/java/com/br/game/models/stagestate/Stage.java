package com.br.game.models.stagestate;

import java.util.Set;

import com.br.game.models.Question;
import com.br.game.models.gamemode.GameMode;

public class Stage {
	State state;
	private GameMode gameMode;
	private Set<Question> questionsAnswered;
	
	public State getState() {
		return this.state;
	}
	
	public void changeState(State state) {
		this.state = state;
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public Set<Question> getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(Set<Question> questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

	public void execute() {
		// identificar quantas questões tem no banco de dados |v|
		// pegar uma questão aleatória |v|
		// deixar o usuário escolher.
		
		// Após a escolha, verificar se a resposta foi correta
			// -- Se a resposta for correta adicionar pergunta ao set de prerguntas respondidas
			// buscar nova pergunta 
			// -- Se a resposta não foi correta lançar exceção junto com a quantidade de perguntas acertadas
	}
}
