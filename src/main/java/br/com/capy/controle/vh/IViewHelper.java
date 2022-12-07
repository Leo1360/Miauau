package br.com.capy.controle.vh;

import br.com.capy.domain.EntidadeDominio;
import br.com.capy.util.Resultado;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface IViewHelper {
    public EntidadeDominio get(HttpServletRequest req, HttpServletResponse resp);
    public void set(HttpServletRequest req, HttpServletResponse resp, Resultado resultado) throws ServletException, IOException;
}
