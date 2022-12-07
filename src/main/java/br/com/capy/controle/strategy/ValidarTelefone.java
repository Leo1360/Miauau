package br.com.capy.controle.strategy;

import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Telefone;

public class ValidarTelefone implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        Telefone telefone  = (Telefone) entidade;
        if(telefone.getDdd().length()>0 && telefone.getNumero().length()>0){
            return "";
        }else{
            return "Telefone invalido;";
        }
    }

}
