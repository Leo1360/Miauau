package br.com.capy.controle.command;

import br.com.capy.util.Resultado;
import br.com.capy.domain.EntidadeDominio;

public interface ICommand {
    public Resultado executar(EntidadeDominio entidade);
}
