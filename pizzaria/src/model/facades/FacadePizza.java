/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import dao.PizzaDAO;
import dao.interfaces.InterfacePizza;
import dto.PizzaDTO;
import model.strategy.InterfaceCrudPizza;

/**
 *
 * @author Italo
 */
public class FacadePizza implements InterfaceCrudPizza{
    private InterfacePizza pizzaD;

    public FacadePizza() {
        pizzaD = new PizzaDAO();
    }

    @Override
    public boolean salvar(Object obj) throws Exception {
       return pizzaD.salva((PizzaDTO) obj);
    }

    @Override
    public int salvarPersonalizada(Object obj) throws Exception {
       return pizzaD.salvaPizzaPersonalizada((PizzaDTO) obj);
    }

    @Override
    public Object listar() throws Exception {
       return pizzaD.listar();
    }

    @Override
    public Object verSabores(int id) throws Exception {
       return pizzaD.verSabores(id);
    }


    @Override
    public boolean excluir(int id) throws Exception {
      return pizzaD.deletar(id);
    }
    
    
   
    
}
