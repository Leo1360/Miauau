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
        if(paciente.getPedigrie().equals("")){
            return "";
        }
        PacienteDAO dao = new PacienteDAO();
        List<Paciente> pacientesPedigrie =  dao.findByPedigrie(paciente.getPedigrie());
        
        boolean duplicidade = false;
        for(Paciente paci:pacientesPedigrie){
            if(paci.getId() != paciente.getId()){
                duplicidade = true;
                break;
            }
        }
        
        if(duplicidade){
            return "Pedigrie ja cadastrado!";
        }else{
            return "";
        }

    }
}
