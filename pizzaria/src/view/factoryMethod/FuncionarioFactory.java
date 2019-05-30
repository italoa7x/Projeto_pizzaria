package view.factoryMethod;

import control.FuncionarioControl;
import control.MotoboyControl;
import control.PizzaioloControl;
import dto.FuncionarioDTO;

public class FuncionarioFactory implements Pessoa {

    @Override
    public Object gerar(String tipo) {
        if (tipo.toUpperCase().equals("FUNCIONARIO")) {
            return new FuncionarioControl();
        } else if (tipo.toUpperCase().equals("PIZZAIOLO")) {
            return new PizzaioloControl();
        } else if (tipo.toUpperCase().equals("MOTOBOY")) {
            return new MotoboyControl();
        } else if (tipo.toUpperCase().equals("DTO")) {
            return new FuncionarioDTO();
        }
        return null;
    }

}
