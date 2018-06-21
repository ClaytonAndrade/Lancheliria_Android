package com.example.claytonandrade.lanchonetemodelo.model;

/**
 * Created by claytonandrade on 25/05/17.
 */

public class Lanche {

    private String nome_lanche;
    private String valor_lanche;
    private String descricao_lanche;
    private int foto_lanche;

    public String getNome_lanche() {
        return nome_lanche;
    }

    public void setNome_lanche(String nome_lanche) {
        this.nome_lanche = nome_lanche;
    }

    public String getValor_lanche() {
        return valor_lanche;
    }

    public void setValor_lanche(String valor_lanche) {
        this.valor_lanche = valor_lanche;
    }

    public String getDescricao_lanche() {
        return descricao_lanche;
    }

    public void setDescricao_lanche(String descricao_lanche) {
        this.descricao_lanche = descricao_lanche;
    }

    public int getFoto_lanche() {
        return foto_lanche;
    }

    public void setFoto_lanche(int foto_lanche) {
        this.foto_lanche = foto_lanche;
    }

    private int foto_pessoa;

    public Lanche(final String nome_lanche, final String valor_lanche, final String descricao_lanche, final int foto_lanche){
        this.nome_lanche = nome_lanche;
        this.valor_lanche = valor_lanche;
        this.descricao_lanche = descricao_lanche;
        this.foto_lanche = foto_lanche;
    }
}

