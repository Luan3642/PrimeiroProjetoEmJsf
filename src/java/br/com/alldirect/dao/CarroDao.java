package br.com.alldirect.dao;

import br.com.alldirect.connection.ConnectionFactory;
import br.com.alldirect.model.Carro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDao {
    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection conecta;
    
    public CarroDao() {
       this.conecta = new ConnectionFactory().getConnection();
    }
    
    public void adicionaCarro(Carro carro) throws SQLException{
        String sql = "INSERT INTO CARRO (MODELO_CARRO,FABRICANTE_CARRO,COR_CARRO,ANO_CARRO) VALUES (?,?,?,?)";
        try{
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getFabricante());
            stmt.setString(3, carro.getCor());
            stmt.setDate(4, new Date(carro.getAno().getTime()));
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Não foi possível conectar a sua base " +e);
        }
    }
}
