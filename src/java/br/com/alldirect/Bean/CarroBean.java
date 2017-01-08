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
public class CarroBean {

    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    private CarroDao carrodao = new CarroDao();

    public void adiciona() throws SQLException {
        carros.add(carro);
        carrodao.adicionaCarro(carro);
    }

    public void listar() {
        carros = carrodao.listarCarros();
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
