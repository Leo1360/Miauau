package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Responsavel;

public class ValidarCpf implements IStrategy {
    @Override
    public String processar(EntidadeDominio entidade) {
        Responsavel responsavel = (Responsavel) entidade;
        if(responsavel.getCpf().isBlank() || responsavel.getCpf().length()!=11){
            return "CPF invalido";
        }else {
            return "";
        }
    }
}
