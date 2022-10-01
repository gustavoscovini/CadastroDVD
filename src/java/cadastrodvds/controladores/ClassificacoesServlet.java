/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastrodvds.controladores;

import cadastrodvds.dao.ClassificacaoDAO;
import cadastrodvds.entidades.Classificacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ClassificacoesServlet", urlPatterns = {"/processaClassificacoes"})
public class ClassificacoesServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        String acao = request.getParameter("acao");
        ClassificacaoDAO dao = null;
        RequestDispatcher disp = null;
        try{
            
            dao = new ClassificacaoDAO();
            
            if ( acao.equals( "inserir" ) ) {
                String descricao = request.getParameter( "descricao" );
                Classificacao c = new Classificacao();
                c.setDescricao(descricao);
                dao.salvar(c);
                disp = request.getRequestDispatcher("/formularios/classificacoes/listagem.jsp");
            }else if(acao.equals("alterar")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                String descricao = request.getParameter( "descricao" );
                Classificacao c = new Classificacao();
                c.setId(id);
                c.setDescricao(descricao);
                dao.atualizar(c);
                disp = request.getRequestDispatcher("/formularios/classificacoes/listagem.jsp");
            }else if(acao.equals("excluir")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Classificacao c = new Classificacao();
                c.setId(id);
                dao.excluir( c );
                disp = request.getRequestDispatcher("/formularios/classificacoes/listagem.jsp");
            }else{
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Classificacao c = dao.obterPorId(id);
                request.setAttribute( "classificacao", c );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/classificacoes/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/classificacoes/excluir.jsp" );
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
        } catch (SQLException ex) {
            Logger.getLogger(ClassificacoesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ClassificacoesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
