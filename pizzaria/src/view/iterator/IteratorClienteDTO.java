/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iterator;

import dto.ClienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class IteratorClienteDTO implements IteratorC {

    private List<ClienteDTO> vetor;
    private int quantidade = 0;

    public IteratorClienteDTO(ArrayList<ClienteDTO> v) {
        this.vetor = v;
    }

    @Override
    public boolean hasnext() {
        if (quantidade >= vetor.size() || vetor.get(quantidade) == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public ClienteDTO next() {
        ClienteDTO obj = vetor.get(quantidade);
        quantidade++;
        return obj;
    }

}
