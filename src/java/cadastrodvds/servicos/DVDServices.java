package cadastrodvds.servicos;


import cadastrodvds.dao.DvdDAO;
import cadastrodvds.entidades.Dvd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DVDServices {

    public List<Dvd> getTodos() {

    List<Dvd> lista = new ArrayList<>();
    DvdDAO dao = null;
    
    try {
        dao = new DvdDAO();
        lista = dao.listarTodos();
    } catch ( SQLException exc ) {
        exc.printStackTrace();
    } finally {
        if ( dao != null ) {
            try {
                dao.fecharConexao();
            } catch ( SQLException exc ) {
                exc.printStackTrace();
            }
        }
    }

    return lista;

    }

}


