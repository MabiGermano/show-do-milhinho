package com.br.game.models;

import java.util.Set;

public class Question {

	private int id;
	private String title;
	private Set<String> wrongAnswers;
	private String rightAnswer;
	private String tip;

	public Question() {
	}

	public Question(int id, String title, Set<String> wrongAnswers, String rightAnswer) {
		this.id = id;
		this.title = title;
		this.rightAnswer = rightAnswer;
		this.wrongAnswers = wrongAnswers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(Set<String> wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
