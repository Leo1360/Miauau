package br.com.capy.controle.command;

import br.com.capy.util.Resultado;
import br.com.capy.domain.EntidadeDominio;

public class SalvarCMD extends AbstractCommand{

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        return this.fachada.salvar(entidade);
    }
}
