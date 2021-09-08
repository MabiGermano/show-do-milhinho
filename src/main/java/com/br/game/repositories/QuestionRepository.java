package com.br.game.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.br.game.database.DatabaseConnection;
import com.br.game.models.Question;

public class QuestionRepository {

	public ArrayList<Question> list() {
		ArrayList<Question> questionList = new ArrayList<>();
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();

			String query = "SELECT * FROM question";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			while (dbResult.next()) {
				Question question = new Question();
				question.setId(dbResult.getInt("id"));
				question.setTitle(dbResult.getString("title"));
				question.setRightAnswer(dbResult.getString("right_answer")); 
				question.setTip(dbResult.getString("tip")); 

				String wrongAnswersFromDb = dbResult.getString("wrong_answers");
				
				Set<String> wrongAnswers = new HashSet<>();
				Collections.addAll(wrongAnswers, wrongAnswersFromDb.split(","));
				question.setWrongAnswers(wrongAnswers);
				
				questionList.add(question);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;
	}
	
	public Question findById(int id) {
		Question question = new Question();
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();
			String query = "SELECT * FROM question WHERE id = " + id;
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			while (dbResult.next()) {
				
				question.setId(dbResult.getInt("id"));
				question.setTitle(dbResult.getString("title"));
				question.setRightAnswer(dbResult.getString("right_answer")); 
				question.setTip(dbResult.getString("tip")); 

				String wrongAnswersFromDb = dbResult.getString("wrong_answers");
				
				Set<String> wrongAnswers = new HashSet<>();
				Collections.addAll(wrongAnswers, wrongAnswersFromDb.split(","));
				question.setWrongAnswers(wrongAnswers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}

	public Question findByRandomId() {
		Question question = new Question();
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();
			String query = "SELECT ROUND(RAND() * ( SELECT MAX(id) FROM  table_name)) AS id";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			while (dbResult.next()) {
				
				question.setId(dbResult.getInt("id"));
				question.setTitle(dbResult.getString("title"));
				question.setRightAnswer(dbResult.getString("right_answer")); 
				question.setTip(dbResult.getString("tip")); 

				String wrongAnswersFromDb = dbResult.getString("wrong_answers");
				
				Set<String> wrongAnswers = new HashSet<>();
				Collections.addAll(wrongAnswers, wrongAnswersFromDb.split(";"));
				question.setWrongAnswers(wrongAnswers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}
}
