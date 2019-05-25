package view.factoryMethod;

import control.FuncionarioControl;
import control.MotoboyControl;
import control.PizzaioloControl;
import dto.FuncionarioDTO;

public class FuncionarioFactory extends FabricaMaster {

    private Pessoa funcionario;

    @Override
    public Pessoa gerar(String tipo) {
        if (tipo.toUpperCase().equals("FUNCIONARIO")) {
            funcionario = new FuncionarioControl();
        } else if (tipo.toUpperCase().equals("PIZZAIOLO")) {
            funcionario = new PizzaioloControl();
        } else if (tipo.toUpperCase().equals("MOTOBOY")) {
            funcionario = new MotoboyControl();
        }else if(tipo.toUpperCase().equals("DTO")){
            funcionario = new FuncionarioDTO();
        }
        
        return funcionario;
    }

}
