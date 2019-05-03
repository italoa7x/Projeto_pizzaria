/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.PizzaDTO;
import java.util.ArrayList;
import model.facades.FacadePizza;

/**
 *
 * @author Italo
 */
public class PizzaControl {

    private FacadePizza facadePizza;

    public PizzaControl() {
        facadePizza = new FacadePizza();
    }

    public boolean salvaPizza(PizzaDTO obj) throws Exception {
      return facadePizza.salvar(obj);
    }

    public PizzaDTO listarPizza() throws Exception{
        return (PizzaDTO) facadePizza.listar();
    }

    public ArrayList<String> verSabores(int id) throws Exception {
        return (ArrayList<String>) facadePizza.verSabores(id);
    }
    
    public boolean excluirPizza(int id) throws Exception{
        return facadePizza.excluir(id);
    }
    
    public int salvaPizzaPersonalizada(PizzaDTO obj) throws Exception{
      return facadePizza.salvarPersonalizada(obj);
    }
}
