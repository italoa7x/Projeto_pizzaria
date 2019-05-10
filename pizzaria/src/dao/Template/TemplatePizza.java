package dao.Template;

import dao.PizzaDAO;
import dto.PizzaDTO;

/**
 *
 * @author italo
 */
public class TemplatePizza extends SalvaPizza{
    private PizzaDAO pizzaD;

    public TemplatePizza() {
        pizzaD = new PizzaDAO();
    }

    @Override
    public int salva_pizza(PizzaDTO obj) throws Exception {
        return this.pizzaD.salva(obj);
    }

    @Override
    public boolean salva_ingredientes(int idPizza, String[] ingredientes) throws Exception {
        return this.pizzaD.salva_ingredientes(idPizza, ingredientes);
    }
    
    
    
    
}
