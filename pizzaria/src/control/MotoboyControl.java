/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Motoboy;
import model.strategy.StrategyPedido;
import view.factoryMethod.Pessoa;

/**
 *
 * @author Italo
 */
public class MotoboyControl{
    private StrategyPedido motoboy;
    
    public MotoboyControl(){
        motoboy = new Motoboy();
    }
    
    public boolean entregarPizza(int id, String status) throws Exception{
        return motoboy.entregar_pedido(status, id);
    }
}
