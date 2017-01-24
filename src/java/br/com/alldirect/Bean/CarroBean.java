package br.com.alldirect.Bean;

import br.com.alldirect.dao.CarroDao;
import br.com.alldirect.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarroBean implements java.io.Serializable{

    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    private CarroDao carroDao = new CarroDao();

    public void adiciona() {
        try{
        carros.add(carro);
        carroDao.adicionaCarro(carro);
        }catch(SQLException e){
            System.out.println("Não foi possível adicionar " + e);
        }
    } 

        public void deletar(Carro c){
        carroDao.deletarCarro(c.getId());
    }
    public void listar(){
        carros = carroDao.listarCarros();
    }
    
    public void editar(Carro c){
        carro = c;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

}
