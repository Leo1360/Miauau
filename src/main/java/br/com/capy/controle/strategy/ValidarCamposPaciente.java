package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;
import br.com.capy.domain.Raca;

public class ValidarCamposPaciente implements IStrategy {
    @Override
    public String processar(EntidadeDominio entidade) {
        Paciente paciente = (Paciente) entidade;
        System.out.println("paciente.getNome().length()= " + paciente.getNome().length());
        if(paciente.getResponsavel() != null &&
                paciente.getNome().length() > 0 &&
                paciente.getIdade() > 0 &&
                paciente.getPeso() > 0 &&
                paciente.getRaca().getNome().length() >0 &&
                paciente.getRaca().getAnimal() != null &&
                paciente.getRaca().getPorte() != null){
            return "";
        }else{
            return "Erro validacao Paciente. Todos os campos obrigatorios precisam ser preenchidos!;";
        }

    }
}
