/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Template;

import dao.PizzaDAO;
import dto.PizzaDTO;

/**
 *
 * @author italo
 */
public abstract class SalvaPizza {
    
    public abstract int salva_pizza(PizzaDTO obj) throws Exception;
    public abstract boolean salva_ingredientes(int idPizza, String[] ingredientes) throws Exception;
    
    public final boolean persistir_pizza(PizzaDTO pizza) throws Exception{
        // primeiro o método persiste no banco os dados referente a pizza.
        int id_gerado = this.salva_pizza(pizza);
        
        /** após salvar a pizza, é guardado o ID que foi gerado pelo SGBD e será passado para o método abaixo que
        salva os ingredientes na tabela de ingredientes.
        * **/
        return this.salva_ingredientes(id_gerado, pizza.getSabores());
    }
    
    public final int persistir_pizza_personalizada(PizzaDTO pizza) throws Exception{
         // primeiro o método persiste no banco os dados referente a pizza.
        int id_gerado = this.salva_pizza(pizza);
        
        /** após salvar a pizza, é guardado o ID que foi gerado pelo SGBD e será passado para o método abaixo que
        salva os ingredientes na tabela de ingredientes.
        * **/
        this.salva_ingredientes(id_gerado, pizza.getSabores());
        
        // retorno o ID gerado da pizza que foi salva.
        return id_gerado;
    }
}
