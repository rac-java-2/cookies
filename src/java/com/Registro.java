/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rene
 */
public class Registro extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contador = 0;
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals("visitas")) {
                    contador = Integer.parseInt(c.getValue());
                    break;
                }
            }            
        }
        
        contador++;
        
        Cookie c = new Cookie("visitas", Integer.toString(contador));
        c.setMaxAge(3600);
        
        response.addCookie(c);
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter();
        pw.print("<h1>Total de visitas: " + contador + "</h1>");
        pw.close();
    }
}
