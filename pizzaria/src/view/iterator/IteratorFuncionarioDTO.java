/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iterator;

import dto.FuncionarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class IteratorFuncionarioDTO implements IteratorF {

    private List<FuncionarioDTO> vetor;
    private int quantidade = 0;

    public IteratorFuncionarioDTO(ArrayList<FuncionarioDTO> v) {
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
    public FuncionarioDTO next() {
        FuncionarioDTO obj = vetor.get(quantidade);
        quantidade++;
        return obj;
    }

}
