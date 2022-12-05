package br.com.capy.controle.fachada;

import br.com.capy.util.Resultado;
import br.com.capy.domain.EntidadeDominio;

public interface IFachada {
    public Resultado salvar(EntidadeDominio entidade);
    public Resultado alterar(EntidadeDominio entidade);
    public Resultado excluir(EntidadeDominio entidade);
    public Resultado visualizar(EntidadeDominio entidade);
}
