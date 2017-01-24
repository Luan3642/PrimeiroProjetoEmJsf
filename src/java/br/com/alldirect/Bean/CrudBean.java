package br.com.alldirect.Bean;

public class CrudBean {

    private String estadoTela = "busca"; // adiciona, edita, e lista

    
    // Métodos para controle da tela 
    public boolean adiciona(){
        return "adiciona".equals(estadoTela);   
    }
    
    public boolean listar(){
        return "listar".equals(estadoTela);
    }
    
    public boolean editar(){
        return "editar".equals(estadoTela);
    }
    
    public void mudarParaAdicionar(){
            estadoTela = "adiciona";
    }
    
    public void mudarParaListar(){
        estadoTela = "listar";
    }
    
    public void mudarParaEditar(){
        estadoTela = "editar";
    }
}
