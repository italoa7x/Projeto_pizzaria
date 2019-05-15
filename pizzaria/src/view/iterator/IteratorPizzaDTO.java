/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iterator;

import dto.PizzaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class IteratorPizzaDTO implements IteratorP {

    private List<PizzaDTO> vetor;
    private int quantidade = 0;

    public IteratorPizzaDTO(ArrayList<PizzaDTO> v) {
        this.vetor = v;

    }

    @Override
    public boolean hasNext() {
        if (quantidade >= vetor.size() || vetor.get(quantidade) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public PizzaDTO next() {
        PizzaDTO obj = vetor.get(quantidade);
        quantidade++;
        return obj;
    }

}
