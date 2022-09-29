/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrodvds.entidades;

import java.sql.Date;

/**
 *
 * @author Jonas
 */
public class Dvd {

    private int id;
    private String titulo;
    private Date dataLancamento;
    private String anoLancamento;
    private String duracao;
    private Ator atorp;
    private Ator atorc;
    private Genero genero;
    private Classificacao classificacao;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Ator getAtorp() {
        return atorp;
    }

    public void setAtorp(Ator atorp) {
        this.atorp = atorp;
    }

    public Ator getAtorc() {
        return atorc;
    }

    public void setAtorc(Ator atorc) {
        this.atorc = atorc;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }  
    
}
