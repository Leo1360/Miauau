package br.com.capy.controle.strategy;

import br.com.capy.controle.strategy.IStrategy;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;
import br.com.capy.persistencia.PacienteDAO;

import java.util.List;

public class ValidarPedigrie implements IStrategy {
    @Override
    public String processar(EntidadeDominio entidade) {
        Paciente paciente = (Paciente) entidade;
        PacienteDAO dao = new PacienteDAO();
        List<Paciente> pacientesPedigrie =  dao.findByPedigrie(paciente.getPedigrie());
        if(pacientesPedigrie.size()>0){
            return "Pedigrie ja cadastrado!";
        }else{
            return "";
        }
    }
}
