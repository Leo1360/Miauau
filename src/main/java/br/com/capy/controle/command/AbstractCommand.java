package br.com.capy.controle.command;

import br.com.capy.controle.fachada.Fachada;
import br.com.capy.controle.fachada.IFachada;

public abstract class AbstractCommand implements ICommand{
    protected IFachada fachada = new Fachada();
}
