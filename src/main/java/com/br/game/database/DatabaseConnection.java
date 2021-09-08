package com.br.game.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.br.game.properties.Manipulator;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;
	private String url;
	private String username;
	private String password;

	private DatabaseConnection() throws SQLException {
            Properties properties;
            try {
                properties = Manipulator.getProp();
                this.url = properties.getProperty("database.url");
                this.username = properties.getProperty("database.username");
                this.password = properties.getProperty("database.password");
		Class.forName(properties.getProperty("database.classForName"));
		this.connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public static DatabaseConnection getInstance() throws SQLException {
            if (instance == null) {
		instance = new DatabaseConnection();
            } else if (instance.getConnection().isClosed()) {
            	instance = new DatabaseConnection();
            }
            return instance;
	}
}
