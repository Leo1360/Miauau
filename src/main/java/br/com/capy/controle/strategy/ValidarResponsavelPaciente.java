package br.com.capy.controle.strategy;

import br.com.capy.domain.EntidadeDominio;
import br.com.capy.domain.Paciente;
import br.com.capy.domain.Responsavel;

public class ValidarResponsavelPaciente implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Paciente paciente = (Paciente) entidade;
        Responsavel responsavel = paciente.getResponsavel();
        String erroStr = "";

        if(responsavel != null &&
                responsavel.getCpf().length() > 0 &&
                responsavel.getNome().length() > 0 ){
            erroStr =  "";
        }else{
            erroStr = "Erro na validação de responsavel;";
        }
        erroStr = erroStr + new ValidarTelefone().processar(responsavel.getTelefone());
        erroStr = erroStr + new ValidarEndereco().processar(responsavel.getEndereco());
        return  erroStr;
    }
}
