package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;
import br.com.capy.domain.Raca;

public class ValidarCamposPaciente implements IStrategy {
    @Override
    public String processar(EntidadeDominio entidade) {
        Paciente paciente = (Paciente) entidade;
        if(paciente.getResponsavel() != null &&
                !paciente.getNome().isEmpty() &&
                !paciente.getNome().isBlank() &&
                paciente.getIdade() > 0 &&
                paciente.getPeso() > 0 &&
                !paciente.getRaca().equals(new Raca())){
            return "";
        }else{
            return "Todos os campos obrigatorios precisam ser preenchidos!";
        }

    }
}
