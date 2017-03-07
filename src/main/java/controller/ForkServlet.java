package controller;

import validator.ForkValidator;
import database.ForklDaoImplementation;
import model.Fork;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForksServlet", urlPatterns = {"/service"})
public class ForkServlet extends HttpServlet {

    ForklDaoImplementation dao = new ForklDaoImplementation();
    ArrayList<Fork> forkList = new ArrayList<>();
    ArrayList<String> errorList = new ArrayList<>();
    Date date = new Date();
    Fork fork;

    public ForkServlet() {
        String error = date.toString() + " - Servleti start";
        errorList.add(error);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        date = new Date();
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("action") != null) {
            if (request.getParameterMap().isEmpty()) {
                return;
            } else if(request.getParameter("action").equals("save")) {
                ForkValidator validator = new ForkValidator(request.getParameter("id"), request.getParameter("length"), request.getParameter("tines"), request.getParameter("material"), request.getParameter("description"));
                if (validator.isValid()) {
                    dao.update(validator.getFork());
                    response.sendRedirect("/Vaheulesanne1/service");
                } else {
                    request.setAttribute("forks", forkList);
                    request.setAttribute("error", "true");
                    RequestDispatcher rd = request.getRequestDispatcher("/editfork.jsp");
                    rd.forward(request, response);
                }
            } else {
                ForkValidator validator = new ForkValidator(request.getParameter("length"), request.getParameter("tines"), request.getParameter("material"), request.getParameter("description"));
                if (validator.isValid()) {
                    dao.save(validator.getFork());
                    response.sendRedirect("/Vaheulesanne1/service");
                } else {
                    request.setAttribute("forks", forkList);
                    request.setAttribute("error", "true");
                    RequestDispatcher rd = request.getRequestDispatcher("/addfork.jsp");
                    rd.forward(request, response);
                }                
            }
        } else if (request.getParameter("error") != null) {
            request.setAttribute("errors", errorList);
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        } else if (request.getParameter("id") != null) {
            forkList.clear();
            Fork k = dao.findById(request.getParameter("id"));
            if (k == null) {
                String error;
                if (request.getParameter("id").equals("")) {
                    error = date.toString() + " - ID null";
                } else {
                    error = date.toString() + " - ID'ga " + request.getParameter("id") + " kirje puudub";
                }
                errorList.add(error);
                request.setAttribute("errors", errorList);
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            } else {
                forkList.add(k);
                request.setAttribute("forks", forkList);
                RequestDispatcher rd = request.getRequestDispatcher("/editfork.jsp");
                rd.forward(request, response);
            }
        } else if(request.getParameter("remove") != null) {
            dao.delete(request.getParameter("remove"));
            request.setAttribute("forks", dao.findAll());
            RequestDispatcher rd = request.getRequestDispatcher("/fork.jsp");
            rd.forward(request, response);
        } else if(request.getParameter("add") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/addfork.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("forks", dao.findAll());
            RequestDispatcher rd = request.getRequestDispatcher("/fork.jsp");
            rd.forward(request, response);
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
