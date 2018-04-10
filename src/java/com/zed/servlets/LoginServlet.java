/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arrud
 */
@WebServlet(name="Login", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        final String login = req.getParameter("userName");
        final String senha = req.getParameter("userPass");
        
        if(login.equals("Maria") && senha.equals("Maria123")){
            resp.sendRedirect("https://www.unicarioca.edu.br/");
        }else{
            try(PrintWriter print = resp.getWriter()){
                
                resp.setLocale(Locale.ROOT);
                req.setCharacterEncoding("UTF-8");
                
                print.append("<!DOCTYPE html>");
                print.append("<html>");
                print.append("<head>");
                print.append("<title>Login Invalido</title>");
                print.append("<meta charset=\"UTF-8\">");
                print.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                print.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/index.css\"/>");
                print.append("</head>");
                print.append("<body class=container>");
                print.append("<div id=resposta>");
                print.append("<hgroup>");
                print.append("<h3>Nome de usuario: "+login+"</h3>");
                print.append("<h5>Nome de usuario ou senha incorretos. <a href=index.html>Clique aqui.</a></h5>");
                print.append("</hgroup>");
                print.append("</div>");
                print.append("</body>");
                print.append("</html>");
            }
        }
    }
}
