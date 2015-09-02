package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost/cliente";
	private String usuario = "root";
	private String senha = "root";
	private Connection connection;

	public Conexao(){
		try{
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(URL,usuario,senha);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public void fecharConexao(){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
