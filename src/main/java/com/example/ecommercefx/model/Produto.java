package com.example.ecommercefx.model;
/// ==========================================================
/// Produto
/// ==========================================================

public class Produto {
    // Atributos privados
    private int id; // Chave primária
    private String sku;
    private String nome;
    private double preco;
    private int quantidade;

    /**
     * Construtor para INSERÇÃO (CREATE), onde o ID ainda não existe.
     */
    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.sku = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Construtor para LEITURA (READ) ou ATUALIZAÇÃO (UPDATE), onde o ID já é conhecido.
     */
    public Produto(int id, String codigo, String nome, double preco, int quantidade) {
        this.id = id;
        this.sku = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /// Métodos getters (Acessores)
    public int getId(){
        return id;
    }

    public String getSku(){
        return sku;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    /// Métodos setters (Modificadores)
    public void setId(int id){
        this.id = id;
    }

    public void setSku(String sku){
        this.sku = sku;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}