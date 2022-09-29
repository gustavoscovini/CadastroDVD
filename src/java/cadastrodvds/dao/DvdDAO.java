
package cadastrodvds.dao;

import cadastrodvds.entidades.Dvd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class DvdDAO extends DAO<Dvd> {
    
        public DvdDAO() throws SQLException {
    }

    @Override
    public void salvar(Dvd obj) throws SQLException {
                PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " +
                "dvd(titulo, "
                        + "dataLancamento, "
                        + "anoLancamento, "
                        + "duracao, "
                        + "atorp_id, "
                        + "atorc_id, "
                        + "genero_id, "
                        + "classificacao_id ) " +
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ? );" );
                
                
        stmt.setString(1, obj.getTitulo());
        stmt.setDate(2, obj.getDataLancamento());
        stmt.setString(3, obj.getAnoLancamento());
        stmt.setString(4, obj.getDuracao());
        stmt.setInt(5, obj.getAtorp().getId());
        stmt.setInt(6, obj.getAtorc().getId());
        stmt.setInt(7, obj.getGenero().getId());
        stmt.setInt(8, obj.getClassificacao().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Dvd obj) throws SQLException {
                    
        PreparedStatement stmt = getConnection().prepareStatement(

            "UPDATE dvd " +
            "SET" +
            " titulo = ?," +
            " dataLancamento = ?," +
            " anoLancamento = ?," +
            " duracao = ?," +
            " atorp_id = ?," +
            " atorc_id = ?," +
            " genero_id = ?," +
            " classificacao_id = ? " +
            "WHERE" +
            " id = ?;"
        );
        
        stmt.setString(1, obj.getTitulo());
        stmt.setDate(2, obj.getDataLancamento());
        stmt.setString(3, obj.getAnoLancamento());
        stmt.setString(4, obj.getDuracao());
        stmt.setInt(5, obj.getAtorp().getId());
        stmt.setInt(6, obj.getAtorc().getId());
        stmt.setInt(7, obj.getGenero().getId());
        stmt.setInt(8, obj.getClassificacao().getId());
        stmt.setInt(9, obj.getId());
    }

    @Override
    public void excluir(Dvd obj) throws SQLException {
               
        PreparedStatement stmt = getConnection().prepareStatement(
                    "DELETE FROM dvd " +
                    "WHERE" +
                    " id = ?;"
        );

        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Dvd> listarTodos() throws SQLException {
        
        List<Dvd> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT" +
            " d.id idDvd" +
            " d.titulo tituloDvd" +
            " d.dataLancamento dataLancamentoDvd" +
            " d.anoLancamento anoLancamentoDvd" +
            " d.duracao duracaoDvd" +
            " a.id atorP" +
            " a.nome nomeAtorP" +
            " a.id atorC" +
            " a.nome nomeAtorC" +
            " g.id idGenero" +
            " g.descricao descricaoGenero" +
            " c.id classificacao" +
            " c.descricao descricaoClassificacao" +
            " FROM" +
            " dvd d, " +
            " genero g, " +
            " classificacao c, " +
            " ator a" +
            " WHERE" +
            " d.genero_id = g.id AND " +
            " d.classificacao_id = c.id AND " +
            " d.atorp_id = a.id AND" +
            " d.atorc_id = a.id"
        );

        ResultSet rs = stmt.executeQuery();

       /* while ( rs.next() ) {

            Dvd d = new Dvd();
            Classificacao c = new Classificacao();
            Genero g = new Genero();
            Ator a = new Ator();

            d.setId( rs.getInt( "id" ) );
            d.setTitulo(rs.getString("titulo"));
            d.setDataLancamento(rs.getDate("dataLancamento"));
            d.setAnoLancamento(rs.getString("anoLancamento"));
            d.setDuracao(rs.getString("duracao"));
            //duvida aqui
            d.setAtorp(a);
            //falta atorcoadjuvante
            d.setGenero(g);
            d.setClassificacao(c);
            
            
            c.setId(rs.getInt("id"));
                    
            lista.add( d );

        }

        */

        rs.close();
        stmt.close();

        return lista; 
    }

    @Override
    public Dvd obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
