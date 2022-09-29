/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrodvds.testes;

import cadastrodvds.dao.AtorDAO;
import cadastrodvds.dao.ClassificacaoDAO;
import cadastrodvds.dao.DvdDAO;
import cadastrodvds.dao.GeneroDAO;
import cadastrodvds.entidades.Ator;
import cadastrodvds.entidades.Classificacao;
import cadastrodvds.entidades.Dvd;
import cadastrodvds.entidades.Genero;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class TesteDAO {
    
    public static void main(String[] args) throws SQLException {
        
        Genero g = new Genero();
        g.setDescricao("testando");
        
        GeneroDAO gd = new GeneroDAO();
        
        gd.salvar(g);
        
        Ator a = new Ator();
        a.setNome("Gustavo");
        a.setSobrenome("Scovini");
        String data = "2002-08-02";
        a.setDataEstreia(Date.valueOf(data));
        AtorDAO ad = new AtorDAO();
        ad.salvar(a);

        Ator ac = new Ator();
        ac.setNome("Jonas");
        ac.setSobrenome("Zandoná");
        String datac = "2001-09-01";
        ac.setDataEstreia(Date.valueOf(datac));
        ad.salvar(ac);
        
        Classificacao c = new Classificacao();
        c.setDescricao("testando classif");
        ClassificacaoDAO cd = new ClassificacaoDAO();
        cd.salvar(c);
        

            
        Dvd d = new Dvd();
        
        d.setTitulo("titulo foda");
        String dataL = "1998-02-08";
        d.setDataLancamento(Date.valueOf(dataL));
        d.setAnoLancamento("1998");
        d.setAtorp(a);
        d.setAtorc(ac);
        d.setDuracao("92 minutos");
        d.setGenero(g);
        d.setClassificacao(c);
        
        DvdDAO dd = new DvdDAO();
        
        dd.salvar(d);
    }
    
}
