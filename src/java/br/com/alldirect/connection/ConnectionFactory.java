package br.com.alldirect.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    
    //Classe de conexão 
    public Connection getConnection() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "127.0.0.1:3306";
            String myDataBase = "sistemacarros";
            String url = "jdbc:mysql://" + serverName + "/" + myDataBase;
            String userName = "root";
            String passWord = "123456";
            Connection connection = DriverManager.getConnection(url, userName, passWord);
            return connection;
            // Try Catch para tratamento de erros 
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado." + e);
            return null;
        } catch (SQLException e) {
            System.out.println("Não possivel conectar a sua database ." + e);
            return null;
        }
    }
}