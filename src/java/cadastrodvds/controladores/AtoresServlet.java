/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastrodvds.controladores;

import cadastrodvds.dao.AtorDAO;
import cadastrodvds.dao.ClassificacaoDAO;
import cadastrodvds.entidades.Ator;
import cadastrodvds.entidades.Classificacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonas
 */
@WebServlet(name = "AtoresServlet", urlPatterns = {"/processaAtores"})
public class AtoresServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        String acao = request.getParameter("acao");
        AtorDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        
        try{
            
            dao = new AtorDAO();
            
            if ( acao.equals( "inserir" ) ) {
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataEstreia = request.getParameter("dataEstreia");
                Ator a = new Ator();
                a.setNome(nome);
                a.setSobrenome(sobrenome);
                a.setDataEstreia(java.sql.Date.valueOf(LocalDate.parse( dataEstreia, dtf ) ));
                dao.salvar(a);
                disp = request.getRequestDispatcher("/formularios/atores/listagem.jsp");
                
            }else if(acao.equals("alterar")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataEstreia = request.getParameter("dataEstreia");
              
                Ator a = new Ator();
                a.setId(id);
                a.setNome(nome);
                a.setSobrenome(sobrenome);
                a.setDataEstreia(java.sql.Date.valueOf(LocalDate.parse( dataEstreia, dtf ) ));
                dao.atualizar(a);
                disp = request.getRequestDispatcher("/formularios/atores/listagem.jsp");
            }else if(acao.equals("excluir")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Ator a = new Ator();;
                a.setId(id);
                dao.excluir( a );
                disp = request.getRequestDispatcher("/formularios/atores/listagem.jsp");
            }else{
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Ator a = dao.obterPorId(id);
                request.setAttribute( "ator", a );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/atores/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/atores/excluir.jsp" );
                }
                
            }
            
        }catch(SQLException exc){
            exc.printStackTrace();
        }finally{
            if ( dao != null ) {
                try{
                    dao.fecharConexao();
                }catch(SQLException exc){
                    exc.printStackTrace();
                }
            }
        }
        
        if ( disp != null ) {
            disp.forward( request, response );
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AtoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AtoresServlet.class.getName()).log(Level.SEVERE, null, ex);
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
