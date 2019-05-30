package control;
import model.Pizzaiolo;
import view.factoryMethod.Pessoa;

public class PizzaioloControl{
    private Pizzaiolo pizzaiolo;
    
    public PizzaioloControl(){
        pizzaiolo = new Pizzaiolo();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return pizzaiolo.prepararPizza(id);
    }
}
