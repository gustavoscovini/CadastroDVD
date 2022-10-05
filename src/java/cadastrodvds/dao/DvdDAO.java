
package cadastrodvds.dao;

import cadastrodvds.entidades.Ator;
import cadastrodvds.entidades.Classificacao;
import cadastrodvds.entidades.Dvd;
import cadastrodvds.entidades.Genero;
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
            "   d.id idDvd, " +
            "   d.titulo tituloDvd, " +
            "   d.dataLancamento dataLancamentoDvd, " +
            "   d.anoLancamento anoLancamentoDvd, " +
            "   d.duracao duracaoDvd, " +
            "   a.id atorP, " +
            "   a.nome nomeAtorP, " +
            "   a.sobrenome sobrenomeAtorP, " +
            "   a.dataEstreia dataEstreiaAtorP, " +
            "   ac.id atorC, " +
            "   ac.nome nomeAtorC, " +
            "   ac.sobrenome sobrenomeAtorC, " +
            "   ac.dataEstreia dataEstreiaAtorC, " +
            "   g.id idGenero," +
            "   g.descricao descricaoGenero, " +
            "   c.id idClassificacao, " +
            "   c.descricao descricaoClassificacao " +
            "   FROM" +
            "   dvd d, " +
            "   genero g, " +
            "   classificacao c, " +
            "   ator a, " +
            "   ator ac " +
            "   WHERE" +
            "   d.genero_id = g.id AND " +
            "   d.classificacao_id = c.id AND " +
            "   d.atorp_id = a.id AND " +
            "   d.atorc_id = ac.id " +
            "ORDER BY d.titulo, d.dataLancamento;"
        );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Dvd d = new Dvd();
            Classificacao c = new Classificacao();
            Genero g = new Genero();
            Ator ap = new Ator();
            Ator ac = new Ator();
            
            c.setId(rs.getInt("idClassificacao"));
            c.setDescricao("descricaoClassificacao");
            
            ap.setId(rs.getInt("atorP"));
            ap.setNome(rs.getString("nomeAtorP"));
            ap.setSobrenome(rs.getString("sobrenomeAtorP"));
            ap.setDataEstreia(rs.getDate("dataEstreiaAtorP"));
            
            ac.setId(rs.getInt("atorC"));
            ac.setNome(rs.getString("nomeAtorC"));
            ac.setSobrenome(rs.getString("sobrenomeAtorC"));
            ac.setDataEstreia(rs.getDate("dataEstreiaAtorC"));
            
            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));

            d.setId( rs.getInt( "idDvd" ) );
            d.setTitulo(rs.getString("tituloDvd"));
            d.setDataLancamento(rs.getDate("dataLancamentoDvd"));
            d.setAnoLancamento(rs.getString("anoLancamentoDvd"));
            d.setDuracao(rs.getString("duracaoDvd"));
            d.setAtorp(ap);
            d.setAtorc(ac);
            d.setGenero(g);
            d.setClassificacao(c);  
                    
            lista.add( d );

        }

        rs.close();
        stmt.close();

        return lista; 
    }

    @Override
    public Dvd obterPorId(int id) throws SQLException {
        
        Dvd d = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT" +
            "   d.id idDvd, " +
            "   d.titulo tituloDvd, " +
            "   d.dataLancamento dataLancamentoDvd, " +
            "   d.anoLancamento anoLancamentoDvd, " +
            "   d.duracao duracaoDvd, " +
            "   a.id atorP, " +
            "   a.nome nomeAtorP, " +
            "   a.sobrenome sobrenomeAtorP, " +
            "   a.dataEstreia dataEstreiaAtorP, " +
            "   ac.id atorC, " +
            "   ac.nome nomeAtorC, " +
            "   ac.sobrenome sobrenomeAtorC, " +
            "   ac.dataEstreia dataEstreiaAtorC, " +
            "   g.id idGenero," +
            "   g.descricao descricaoGenero, " +
            "   c.id idClassificacao, " +
            "   c.descricao descricaoClassificacao " +
            "   FROM" +
            "   dvd d, " +
            "   genero g, " +
            "   classificacao c, " +
            "   ator a, " +
            "   ator ac " +
            "   WHERE" +
            "   d.genero_id = g.id AND " +
            "   d.classificacao_id = c.id AND " +
            "   d.atorp_id = a.id AND " +
            "   d.atorc_id = ac.id " +
            "ORDER BY d.titulo, d.dataLancamento;"
        );
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {
            
            d = new Dvd();
            Classificacao c = new Classificacao();
            Genero g = new Genero();
            Ator ap = new Ator();
            Ator ac = new Ator();
            
            c.setId(rs.getInt("idClassificacao"));
            c.setDescricao("descricaoClassificacao");
            
            ap.setId(rs.getInt("atorP"));
            ap.setNome(rs.getString("nomeAtorP"));
            ap.setSobrenome(rs.getString("sobrenomeAtorP"));
            ap.setDataEstreia(rs.getDate("dataEstreiaAtorP"));
            
            ac.setId(rs.getInt("atorC"));
            ac.setNome(rs.getString("nomeAtorC"));
            ac.setSobrenome(rs.getString("sobrenomeAtorC"));
            ac.setDataEstreia(rs.getDate("dataEstreiaAtorC"));
            
            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));

            d.setId( rs.getInt( "idDvd" ) );
            d.setTitulo(rs.getString("tituloDvd"));
            d.setDataLancamento(rs.getDate("dataLancamentoDvd"));
            d.setAnoLancamento(rs.getString("anoLancamentoDvd"));
            d.setDuracao(rs.getString("duracaoDvd"));
            d.setAtorp(ap);
            d.setAtorc(ac);
            d.setGenero(g);
            d.setClassificacao(c);
            
            
            
        }
        
        rs.close();
        stmt.close();

        return d;
        
    
    }
    
}
