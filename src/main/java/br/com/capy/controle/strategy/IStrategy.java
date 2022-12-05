package br.com.capy.controle.strategy;

import br.com.capy.domain.EntidadeDominio;

public interface IStrategy {
    public String processar(EntidadeDominio entidade);
}
