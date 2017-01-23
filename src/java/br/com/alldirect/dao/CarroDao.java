package br.com.alldirect.dao;

import br.com.alldirect.connection.ConnectionFactory;
import br.com.alldirect.model.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection conecta;

    public CarroDao(){
        this.conecta = new ConnectionFactory().getConnection();
    }

    public void adicionaCarro(Carro carro) throws SQLException {
        if (carro.getId() == null) {
            stmt = conecta.prepareStatement("INSERT INTO CARRO (MODELO_CARRO,FABRICANTE_CARRO,COR_CARRO,ANO_CARRO) VALUES (?,?,?,?)");
        } else {
            stmt = conecta.prepareStatement("update carro set MODELO_CARRO=?, FABRICANTE_CARRO=?, COR_CARRO=?, ANO_CARRO=?, where id=?");
            stmt.setInt(5, carro.getId());
        }
        try {
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

    public void deletarCarro(Integer idCarro){
        String sql = "DELETE FROM CARRO WHERE = ?";
        try {
            stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, idCarro);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível deletar\n"+ e );
        }
    }

    public List<Carro> listarCarros(){
        try {
            this.conecta = new ConnectionFactory().getConnection();
            stmt = conecta.prepareStatement("SELECT * FROM CARRO");
            rs = stmt.executeQuery();
            List<Carro> carros = new ArrayList<Carro>();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("ID_CARRO"));
                carro.setModelo(rs.getString("MODELO_CARRO"));
                carro.setFabricante(rs.getString("FABRICANTE_CARRO"));
                carro.setCor(rs.getString("COR_CARRO"));
                carro.setAno(rs.getInt("ANO_CARRO"));
                carros.add(carro);
            }
            return carros;

        } catch (SQLException e) {
            System.out.println("Não foi possível listar " + e);
            return null;
        }
    }
}
