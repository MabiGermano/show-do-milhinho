package com.br.game.services;

import java.util.Random;

public class QuestionService {

	public int getRandomicId(int totalQuestions) {
		Random random = new Random();
		return random.nextInt(totalQuestions);
	}
}
