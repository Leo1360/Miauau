package br.com.capy.controle.strategy;

import br.com.capy.domain.Endereco;
import br.com.capy.domain.EntidadeDominio;

public class ValidarEndereco implements IStrategy{
    @Override
    public String processar(EntidadeDominio entidade) {
        Endereco endereco = (Endereco) entidade;
        if(endereco.getBairro().length()>0 &&
                endereco.getCep().length()>0 &&
                endereco.getNumero().length()>0 &&
                endereco.getLogradouro().length()>0 &&
                endereco.getCidade().getNome().length()>0 &&
                endereco.getCidade().getEstado().getNome().length()>0
            ){
            return "";
        }else{
            return "Endereço faltante;";
        }

    }
}
