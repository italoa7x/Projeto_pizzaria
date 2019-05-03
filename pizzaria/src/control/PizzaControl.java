/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.PizzaDTO;
import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author Italo
 */
public class PizzaControl {

    private Pizza pizza;

    public PizzaControl() {
        pizza = new Pizza();
    }

    public boolean salvaPizza(PizzaDTO obj) throws Exception {
      return pizza.salvar(obj);
    }

    public PizzaDTO listarPizza() throws Exception{
        return (PizzaDTO) pizza.listar();
    }

    public ArrayList<String> verSabores(int id) throws Exception {
        return (ArrayList<String>) pizza.verSabores(id);
    }
    
    public boolean excluirPizza(int id) throws Exception{
        return pizza.excluir(id);
    }
    
    public int salvaPizzaPersonalizada(PizzaDTO obj) throws Exception{
      return pizza.salvarPersonalizada(obj);
    }
}
