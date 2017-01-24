package br.com.alldirect.dao;

// Letra E representa uma entidade 

import java.util.List;

public interface CrudDao <E> {
    
    public void adicionar(E entendidade);
        
    public void deletar (E entidadade);
    
    public List<E> listar();
    }

