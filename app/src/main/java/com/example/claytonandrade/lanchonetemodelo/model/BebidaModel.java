package com.example.claytonandrade.lanchonetemodelo.model;

/**
 * Created by claytonandrade on 06/06/17.
 */

public class BebidaModel {

    private String nome_bebida;
    private String valor_lata;
    private String descricao_tipo;
    private int foto_bebida;

    public String getNome_bebida() {
        return nome_bebida;
    }

    public void setNome_bebida(String nome_bebida) {
        this.nome_bebida = nome_bebida;
    }

    public String getValor_lata() {
        return valor_lata;
    }

    public void setValor_lata(String valor_lata) {
        this.valor_lata = valor_lata;
    }

    public String getDescricao_tipo() {
        return descricao_tipo;
    }

    public void setDescricao_tipo(String descricao_tipo) {
        this.descricao_tipo = descricao_tipo;
    }

    public int getFoto_bebida() {
        return foto_bebida;
    }

    public void setFoto_bebida(int foto_bebida) {
        this.foto_bebida = foto_bebida;
    }



    public BebidaModel(final String nome_bebida, final String valor_lata, final String descricao_tipo, final int foto_bebida){
        this.nome_bebida = nome_bebida;
        this.valor_lata = valor_lata;
        this.descricao_tipo = descricao_tipo;
        this.foto_bebida = foto_bebida;
    }
}
