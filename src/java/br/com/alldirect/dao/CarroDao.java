package br.com.alldirect.dao;

import br.com.alldirect.connection.ConnectionFactory;
import br.com.alldirect.model.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDao {

    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection conecta;

    public CarroDao() {
        this.conecta = new ConnectionFactory().getConnection();
    }

    public void adicionaCarro(Carro carro) throws SQLException {
        String sql = "INSERT INTO CARRO (MODELO_CARRO,FABRICANTE_CARRO,COR_CARRO,ANO_CARRO) VALUES (?,?,?,?)";
        try {
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getFabricante());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getAno());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar a sua base" + e);
        }
    }

    public List<Carro> listarCarros() {
        try {
            this.conecta = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conecta.prepareStatement("SELECT * FROM CARRO");
            ResultSet resultSet = stmt.executeQuery();
            List<Carro> carros = new ArrayList<Carro>();
            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("ID_CARRO"));
                carro.setModelo(resultSet.getString("MODELO_CARRO"));
                carro.setFabricante(resultSet.getString("FABRICANTE_CARRO"));
                carro.setCor(resultSet.getString("COR_CARRO"));
                carro.setAno(resultSet.getInt("ANO_CARRO"));
                carros.add(carro);
            }
             return carros;

        } catch (SQLException e) {
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }  
}
