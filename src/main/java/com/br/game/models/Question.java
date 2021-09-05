package com.br.game.models;

import java.util.Set;

public class Question {

	private Long id;
	private String title;
	private Set<String> wrongAnswers;
	private String rightAnswer;
	
	public Question() {}
	
	public Question(Long id, String title, Set<String> wrongAnswers, String rightAnswer) {
		this.id = id;
		this.title = title;
		this.rightAnswer = rightAnswer;
		this.wrongAnswers = wrongAnswers;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	
}
