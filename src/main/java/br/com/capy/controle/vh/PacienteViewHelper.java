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

        Paciente paciente = new Paciente();
        String idStr = req.getParameter("id");
        int id = 0;
        if(idStr != null){
            id = Integer.parseInt(idStr);
        }
        paciente.setId(id);


        if(req.getParameter("operacao") == null){
            return paciente;
        }
        if(req.getParameter("operacao").equals("CONSULTAR")){
            return paciente;
        }
        if(req.getParameter("operacao").equals("EXCLUIR")){
            return paciente;
        }


        String nomeResonsavel = req.getParameter("nomeResponsavel");
        String cpfResponsavel = req.getParameter("cpfResponsavel");
        String logradouroEndereco = req.getParameter("logradouroEndereco");
        String bairroEndereco = req.getParameter("bairroEndereco");
        String cepEndereco = req.getParameter("cepEndereco");
        String comlementoEndereco = req.getParameter("complementoEndereco");
        String numeroEndereco = req.getParameter("numeroEndereco");
        String cidadeStr = req.getParameter("cidadeEndereco");
        String estadoStr = req.getParameter("estadoEndereco");
        String numeroTelefone = req.getParameter("numeroTelefone");
        String dddTelefone = req.getParameter("dddTelefone");
        String temWhatsappStr = req.getParameter("temWhatsappTelefone");
        String nomePaciente = req.getParameter("nomePaciente");
        String idadePacienteStr = req.getParameter("idadePaciente");
        String pedigriePaciente = req.getParameter("pedigriePaciente");
        String tipoPacienteStr = req.getParameter("tipoPaciente");
        String racaPaciente = req.getParameter("racaPaciente");
        String portePacienteStr = req.getParameter("portePaciente");
        String pesoPacienteStr = req.getParameter("pesoPaciente");

        boolean temWhatsapp = false;
        Animal tipoPaciente = null;
        Porte portePaciente = null;
        int idadePaciente = 0;
        float pesoPaciente = 0;
        
        try{
            temWhatsapp = Boolean.parseBoolean(temWhatsappStr);
            tipoPaciente = Animal.valueOf(tipoPacienteStr);
            portePaciente = Porte.valueOf(portePacienteStr);
            idadePaciente = Integer.parseInt(idadePacienteStr);
            pesoPaciente = Float.parseFloat(pesoPacienteStr);
        }catch(Exception e){}

        Telefone telefone = new Telefone(numeroTelefone,dddTelefone,temWhatsapp);
        Estado estado = new Estado(estadoStr);
        Cidade cidade = new Cidade(cidadeStr,estado);
        Endereco endereco = new Endereco(logradouroEndereco,bairroEndereco,cepEndereco,comlementoEndereco,numeroEndereco,cidade);
        Responsavel responsavel = new Responsavel(nomeResonsavel,cpfResponsavel,endereco,telefone);
        Raca raca = new Raca(racaPaciente,portePaciente,tipoPaciente);
        paciente = new Paciente(nomePaciente,idadePaciente,pedigriePaciente,pesoPaciente,true,responsavel,raca);
        paciente.setId(id);

        System.out.println(paciente);

        return paciente;
    }

    @Override
    public void set(HttpServletRequest req, HttpServletResponse resp, Resultado resultado) throws ServletException, IOException {

        RequestDispatcher rd = null;
        String operacao = req.getParameter("operacao");
        if(resultado.getMsg().length() == 0){
            rd = req.getRequestDispatcher("index.jsp");

            if(operacao == null){
                operacao = "CONSULTAR";
            }

            if(operacao.equals("SALVAR")){
                resultado.setMsg("Paciente salvo com sucesso!");
                req.setAttribute("menssagem","sucesso");
                resp.sendRedirect("/miauau/paciente?operacao=CONSULTAR");

            }else if(operacao.equals("CONSULTAR")){
                req.setAttribute("pacienteList",resultado.getResultado());
                if(req.getParameter("id") != null){
                    rd = req.getRequestDispatcher("visualizar.jsp");
                }else{
                    rd = req.getRequestDispatcher("index.jsp");
                }
                
            }else if(operacao.equals("ALTERAR")){
                req.setAttribute("pacienteList",resultado.getResultado());
                req.setAttribute("msg", "Alteração executada com sucesso");
                rd = req.getRequestDispatcher("visualizar.jsp");

            }else if(operacao.equals("EXCLUIR")){
                resp.sendRedirect("/miauau/paciente?operacao=CONSULTAR");
            }

            if((!operacao.equals("EXCLUIR")) && (!operacao.equals("SALVAR"))){
                rd.forward(req, resp);
            }
        }else{
            req.setAttribute("msg", resultado.getMsg());
            rd = req.getRequestDispatcher("erro.jsp");
            rd.forward(req, resp);
        }

        
    }
}
