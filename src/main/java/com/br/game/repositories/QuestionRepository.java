package com.br.game.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.br.game.database.DatabaseConnection;
import com.br.game.models.Question;

public class QuestionRepository {

	public void list() {
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();

			String query = "SELECT * FROM question";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			while (dbResult.next()) {

				// Colocar um builder aqui???
				int id = dbResult.getInt("id");
				String title = dbResult.getString("title");
				String wrongAnswers = dbResult.getString("wrong_answers");
				String rightAnswers = dbResult.getString("right_answer");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int count() {
		int count = 0;
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();

			String query = "SELECT COUNT(*) FROM question";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);

			dbResult.next();
			count = dbResult.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Question findById(int id) {
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();

			String query = "SELECT * FROM question WHERE id = ";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			
			while (dbResult.next()) {

			
				String title = dbResult.getString("title");
				String wrongAnswers = dbResult.getString("wrong_answers");
				String rightAnswers = dbResult.getString("right_answer");

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Question findByRandomId() {
		return null;
	}

}
