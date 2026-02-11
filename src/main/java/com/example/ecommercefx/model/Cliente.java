package com.example.ecommercefx.model;
/// ==========================================================
/// Produto
/// ==========================================================
public class Cliente {
    // Atributos privados
    private int id; // Chave primária "id"
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String cep;
    private String endereco;
    private String estado;
    private String cidade;
    private int numero_residencia;
    private String complemento;

    /**
     * Construtor para INSERÇÃO (CREATE), onde o ID ainda não existe.
     * */
    public Cliente (String nome, String email, String cpf, String telefone, String cep, String endereco, String estado, String cidade, int numero_residencia, String complemento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.numero_residencia = numero_residencia;
        this.complemento = complemento;
    }

    /**
     * Construtor para LEITURA (READ) ou ATUALIZAÇÃO (UPDATE), onde o ID já é conhecido.
     */
    public Cliente (int id, String nome, String email, String cpf, String telefone, String cep, String endereco, String estado, String cidade, int numero_residencia, String complemento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.numero_residencia = numero_residencia;
        this.complemento = complemento;
    }

    /// Métodos getters (Acessores)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public int getNumero_residencia() {
        return numero_residencia;
    }

    public String getComplemento() {
        return complemento;
    }

    /// Métodos setters (Modificadores)
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero_residencia(int numero_residencia) {
        this.numero_residencia = numero_residencia;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }




}
