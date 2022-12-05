package br.com.capy.controle.vh;

import br.com.capy.domain.*;
import br.com.capy.util.Resultado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PacienteViewHelper implements IViewHelper {
    @Override
    public EntidadeDominio get(HttpServletRequest req, HttpServletResponse resp) {
        //TODO

        String nomeResonsavel = req.getParameter("nomeResonsavel");
        String cpfResponsavel = req.getParameter("cpfResponsavel");
        String logradouroEndereco = req.getParameter("logradouroEndereco");
        String bairroEndereco = req.getParameter("bairroEndereco");
        String cepEndereco = req.getParameter("CEPEndereco");
        String comlementoEndereco = req.getParameter("comlementoEndereco");
        String numeroEndereco = req.getParameter("numeroEndereco");
        String cidadeStr = req.getParameter("cidade");
        String estadoStr = req.getParameter("estado");
        String numeroTelefone = req.getParameter("numeroTelefone");
        String dddTelefone = req.getParameter("dddTelefone");
        String temWhatsappStr = req.getParameter("temWhatsapp");
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePacienteStr = req.getParameter("idadePaciente");
        String pedigriePaciente = req.getParameter("pedigriePaciente");
        String tipoPacienteStr = req.getParameter("tipoPaciente");
        String racaPaciente = req.getParameter("racaPaciente");
        String portePacienteStr = req.getParameter("portePaciente");
        String pesoPacienteStr = req.getParameter("pesoPaciente");


        boolean temWhatsapp = Boolean.parseBoolean(temWhatsappStr);
        Animal tipoPaciente = Animal.valueOf(tipoPacienteStr);
        Porte portePaciente = Porte.valueOf(portePacienteStr);
        int idadePaciente = Integer.parseInt(idadePacienteStr);
        float pesoPaciente = Float.parseFloat(pesoPacienteStr);


        Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
        Estado estado = new Estado(estadoStr);
        Cidade cidade = new Cidade(cidadeStr,estado);
        Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
        Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
        Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
        Paciente paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);

        return paciente;
    }

    @Override
    public void set(HttpServletRequest req, HttpServletResponse resp, Resultado resultado) {
        //TODO
        RequestDispatcher rd = null;
        String operacao = req.getParameter("operacao");
        if(resultado.getMsg() == null){
            rd = req.getRequestDispatcher("index.jsp");
        }
        if(resultado.getMsg() == null && operacao.equals("SALVAR")){
            resultado.setMsg("Paciente salvo com sucesso!");
            req.setAttribute("menssagem","sucesso");
            rd = req.getRequestDispatcher("index.jsp");
        }


        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
