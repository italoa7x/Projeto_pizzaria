/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iterator;

import dto.PedidoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class IteratorPedidoDTO implements IteratorPe {

    private List<PedidoDTO> vetor;
    private int quantidade = 0;

    public IteratorPedidoDTO(ArrayList<PedidoDTO> v) {
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
    public PedidoDTO next() {
        PedidoDTO obj = vetor.get(quantidade);
        quantidade++;
        return obj;
    }

}
