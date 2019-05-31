/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author italo
 */
public class Fabrica {

    public static Object gerar(String tipo) {
        if (tipo.equalsIgnoreCase("cliente")) {
            return new FactoryCliDTO().criar();
        } else if (tipo.equalsIgnoreCase("funcionario")) {
            return new FactoryFuncionarioDTO().criar();
        } else {
            throw new IllegalArgumentException("Argumento inválido!");
        }
    }
}
