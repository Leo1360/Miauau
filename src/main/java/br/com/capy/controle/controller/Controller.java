package br.com.capy.controle.controller;

import br.com.capy.controle.command.*;
import br.com.capy.controle.vh.IViewHelper;
import br.com.capy.controle.vh.PacienteViewHelper;
import br.com.capy.domain.EntidadeDominio;
import br.com.capy.util.Resultado;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class Controller extends HttpServlet {
    private HashMap<String, ICommand> commandMap = new HashMap<>();
    private HashMap<String, IViewHelper> vhMap = new HashMap<>();

    public Controller() {
        commandMap.put("SAVE",new SalvarCMD());
        commandMap.put("ALTERAR",new AlterarCMD());
        commandMap.put("EXCLUIR",new ExcluirCMD());
        commandMap.put("VISUALIZAR",new VisualizarCMD());

        vhMap.put("/miauau/paciente", new PacienteViewHelper());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Novo Request: \n  metodo: GET\n  uri: " + req.getRequestURI());
        processar(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Novo Request: \n  metodo: POST\n  uri: " + req.getRequestURI());
        processar(req,resp);
    }

    private void processar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IViewHelper vh = vhMap.get(req.getRequestURI());
        EntidadeDominio entidadeDominio = vh.get(req,resp);
        String operacao = req.getParameter("operacao");
        ICommand command = commandMap.get(operacao);
        Resultado resultado = command.executar(entidadeDominio);
        vh.set(req,resp,resultado);

    }

}
