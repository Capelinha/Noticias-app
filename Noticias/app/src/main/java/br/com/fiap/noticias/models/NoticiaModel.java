package br.com.fiap.noticias.models;

import java.io.Serializable;
import java.util.Date;

public class NoticiaModel implements Serializable {

    private String autor;
    private String titulo;
    private String descricao;
    private String url;
    private String urlImg;
    private Date dataPublicacao;
    private String fonte;

    public NoticiaModel(String autor, String titulo, String descricao, String url, String urlImg, Date dataPublicacao, String fonte) {
        this.autor = autor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.urlImg = urlImg;
        this.dataPublicacao = dataPublicacao;
        this.fonte = fonte;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }


    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
}
