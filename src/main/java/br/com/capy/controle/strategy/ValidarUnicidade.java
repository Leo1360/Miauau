package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Responsavel;
import br.com.capy.persistencia.ResponsavelDAO;

public class ValidarUnicidade implements IStrategy {
    @Override
    public String processar(EntidadeDominio entidade) {
        Responsavel responsavel = (Responsavel) entidade;

        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel respCad = dao.findByCPF(responsavel.getCpf());

        if(respCad == null){
            return "";
        }else{
            return "Responsavel ja cadastrado!";
        }

    }
}
