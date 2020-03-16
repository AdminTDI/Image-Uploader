/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageuploader;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author fhfai
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class profile extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/imageuploader";
    private String dbUser = "root";
    private String dbPass = "admin";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet profile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath() + "</h1>");
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
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");

        InputStream is = null;
        InputStream is2 = null;
        byte[] b = null;

        Part filePart = request.getPart("pi");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            is = filePart.getInputStream();
            is2 = filePart.getInputStream();
        }

        b = IOUtils.toByteArray(is2);
        byte[] encodeBase64 = Base64.encodeBase64(b);
        String base64DataString = new String(encodeBase64, "UTF-8");
        request.setAttribute("img", base64DataString);

        Connection conn = null;
        String msg = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "insert into image (first_name, last_name, profileimage) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fn);
            ps.setString(2, ln);

            if (is != null) {
                ps.setBlob(3, is);
            }
            int row = ps.executeUpdate();
            if (row > 0) {
                msg = "Registration Succes";
            }
        } catch (SQLException ex) {
            msg = "Error: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                request.setAttribute("message", msg);
                getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
            }
        }
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
