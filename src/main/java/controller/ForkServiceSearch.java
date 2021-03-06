/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ForklDaoImplementation;
import model.Fork;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForkServiceSearch", urlPatterns = {"/search"})
public class ForkServiceSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ForklDaoImplementation dao = new ForklDaoImplementation();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForkServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("materjal") != null) {
                ArrayList<Fork> forks = dao.findByParam("materjal", request.getParameter("materjal"));
                for(Fork fork:forks )
                    out.println(fork.toString()+"<br>");
            } else if (request.getParameter("pikkus") != null) {
                ArrayList<Fork> forks = dao.findByParam("pikkus", request.getParameter("pikkus"));
                for(Fork fork:forks )
                    out.println(fork.toString()+"<br>");
            } else if (request.getParameter("harusid") != null) {
                ArrayList<Fork> forks = dao.findByParam("harusid", request.getParameter("harusid"));
                for(Fork fork:forks )
                    out.println(fork.toString()+"<br>");
            } else if (request.getParameter("kirjeldus") != null) {
                System.out.println(request.getParameter("kirjeldus"));
                ArrayList<Fork> forks = dao.findByParam("kirjeldus", request.getParameter("kirjeldus"));
                for(Fork fork:forks )
                    out.println(fork.toString()+"<br>");
            } 
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
