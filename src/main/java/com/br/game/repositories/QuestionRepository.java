package com.br.game.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.br.game.database.DatabaseConnection;

public class QuestionRepository {

	public void list() {
		try {
			DatabaseConnection database = DatabaseConnection.getInstance();

			String query = "SELECT * FROM question";
			Statement statement = database.getConnection().createStatement();
			ResultSet dbResult = statement.executeQuery(query);
			while (dbResult.next()) {
				
				//Colocar um builder aqui???
		        Long id = dbResult.getLong("id");
				String title = dbResult.getString("title");
		        String wrongAnswers = dbResult.getString("wrong_answers");
		        String rightAnswers = dbResult.getString("right_answer");
		        
		        
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
