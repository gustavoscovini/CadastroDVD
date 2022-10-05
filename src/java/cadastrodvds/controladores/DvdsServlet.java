/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastrodvds.controladores;

import cadastrodvds.dao.DvdDAO;
import cadastrodvds.entidades.Ator;
import cadastrodvds.entidades.Classificacao;
import cadastrodvds.entidades.Dvd;
import cadastrodvds.entidades.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "DvdsServlet", urlPatterns = {"/processaDVDS"})
public class DvdsServlet extends HttpServlet {

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
        
        
        String acao = request.getParameter("acao");
        DvdDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try{
            
            dao = new DvdDAO();
            
            if ( acao.equals( "inserir" ) ) {
                
                String titulo = request.getParameter( "titulo" );
                String dataLancamento = request.getParameter("dataLancamento");
                String anoLancamento = request.getParameter("anoLancamento");
                String duracao = request.getParameter("duracao");
                int genero = Integer.parseInt(request.getParameter( "genero" ) );
                int classificacao = Integer.parseInt(request.getParameter( "classificacao" ) );
                int atorp = Integer.parseInt(request.getParameter( "atorp" ) );
                int atorc = Integer.parseInt(request.getParameter( "atorc" ) );
                
                Genero g = new Genero();
                g.setId(genero);
                
                Classificacao c = new Classificacao();
                c.setId(classificacao);
                
                Ator ap = new Ator();
                ap.setId(atorp);
                
                Ator ac = new Ator();
                ac.setId(atorc);
                
                Dvd dvd = new Dvd();
                
                dvd.setTitulo(titulo);
                dvd.setDataLancamento(Date.valueOf(LocalDate.parse( dataLancamento, dtf ) ));
                dvd.setAnoLancamento(anoLancamento);
                dvd.setDuracao(duracao);
                dvd.setGenero(g);
                dvd.setClassificacao(c);
                dvd.setAtorp(ap);
                dvd.setAtorc(ac);
                
                dao.salvar(dvd);
                disp = request.getRequestDispatcher("/formularios/dvds/listagem.jsp");
            }else if(acao.equals("alterar")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                
                String titulo = request.getParameter( "titulo" );
                String dataLancamento = request.getParameter("dataLancamento");
                String anoLancamento = request.getParameter("anoLancamento");
                String duracao = request.getParameter("duracao");
                int genero = Integer.parseInt(request.getParameter( "genero" ) );
                int classificacao = Integer.parseInt(request.getParameter( "classificacao" ) );
                int atorp = Integer.parseInt(request.getParameter( "atorp" ) );
                int atorc = Integer.parseInt(request.getParameter( "atorc" ) );
                
                Genero g = new Genero();
                g.setId(genero);
                
                Classificacao c = new Classificacao();
                c.setId(classificacao);
                
                Ator ap = new Ator();
                ap.setId(atorp);
                
                Ator ac = new Ator();
                ac.setId(atorc);
                
                Dvd dvd = new Dvd();
                dvd.setTitulo(titulo);
                dvd.setDataLancamento(Date.valueOf(LocalDate.parse( dataLancamento, dtf ) ));
                dvd.setAnoLancamento(anoLancamento);
                dvd.setDuracao(duracao);
                dvd.setGenero(g);
                dvd.setClassificacao(c);
                dvd.setAtorp(ap);
                dvd.setAtorc(ac);
                
                dao.atualizar(dvd);
                disp = request.getRequestDispatcher("/formularios/generos/listagem.jsp");
            }else if(acao.equals("excluir")){
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Genero g = new Genero();
                g.setId(id);
                //dao.excluir( g );
                disp = request.getRequestDispatcher("/formularios/generos/listagem.jsp");
            }else{
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                //Genero g = dao.obterPorId(id);
//                request.setAttribute( "genero", g );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/generos/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher(
                    "/formularios/generos/excluir.jsp" );
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
