/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrodvds.dao;

import cadastrodvds.entidades.Classificacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ClassificacaoDAO extends DAO<Classificacao> {

        public ClassificacaoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Classificacao obj) throws SQLException {
                PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " +
                "classificacao(descricao) " +
                "VALUES( ? );" );
                
                stmt.setString(1, obj.getDescricao());
                stmt.executeUpdate();
                stmt.close();
    }

    @Override
    public void atualizar(Classificacao obj) throws SQLException {
                
        PreparedStatement stmt = getConnection().prepareStatement(

            "UPDATE classificacao " +
            "SET" +
            " descricao = ? " +
            "WHERE" +
            " id = ?;"
        );
            stmt.setString(1, obj.getDescricao());
            stmt.setInt(2, obj.getId());

            stmt.executeUpdate();
            stmt.close();
    }

    @Override
    public void excluir(Classificacao obj) throws SQLException {
                PreparedStatement stmt = getConnection().prepareStatement(
                    "DELETE FROM classificacao " +
                    "WHERE" +
                    " id = ?;"
        );

        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Classificacao> listarTodos() throws SQLException {
                List<Classificacao> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM classificacao " );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Classificacao c = new Classificacao();

            c.setId( rs.getInt( "id" ) );
            c.setDescricao( rs.getString( "descricao" ) );

            lista.add( c );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Classificacao obterPorId(int id) throws SQLException {
        Classificacao c = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
        
                "SELECT * FROM classificao " +
                " WHERE id = ?;"   
        );
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            c = new Classificacao();
            
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            
        }
        
        rs.close();
        stmt.close();
        
        return c;
    }
    
}
