package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;

public class ValidarResponsavel implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Paciente paciente = (Paciente) entidade;
        if(paciente.getResponsavel() != null && paciente.getResponsavel().getId() > 0){
            return "";
        }else{
            return "Erro na validação de responsavel";
        }
    }
}
