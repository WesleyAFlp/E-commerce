package com.example.ecommercefx.controller;

import com.example.ecommercefx.dao.ClienteDAO;
import com.example.ecommercefx.dao.ProdutoDAO;
import com.example.ecommercefx.model.Cliente;
import com.example.ecommercefx.model.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteController {

    @FXML
    private TextField clNome;
    @FXML
    private TextField clEmail;
    @FXML
    private TextField clCpf;
    @FXML
    private TextField clTelefone;
    @FXML
    private TextField clEstado;
    @FXML
    private TextField clCidade;
    @FXML
    private TextField clCep;
    @FXML
    private TextField clEndereco;
    @FXML
    private TextField clNumeroResidencia;
    @FXML
    private TextField clComplemento;
    @FXML
    private TableView<Cliente> clTabela;
    @FXML
    private TableColumn<Cliente, int> clTabelaId;
    @FXML
    private TableColumn<Cliente, String> clTabelaNome;
    @FXML
    private TableColumn<Cliente, String> clTabelaEmail;
    @FXML
    private TableColumn<Cliente, String> clTabelaCpf;
    @FXML
    private TableColumn<Cliente, String> clTabelaTelefone;
    @FXML
    private TableColumn<Cliente, String> clTabelaEstado;
    @FXML
    private TableColumn<Cliente, String> clTabelaCidade;
    @FXML
    private TableColumn<Cliente, String> clTabelaCep;
    @FXML
    private TableColumn<Cliente, String> clTabelaEndereco;
    @FXML
    private TableColumn<Cliente, String> clTabelaNumero;



    private ClienteDAO dao = new ClienteDAO();
    private Cliente clienteSelecionado;

    public void initialize() {
        clTabelaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clTabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clTabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clTabelaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clTabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        clTabelaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        clTabelaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        clTabelaCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        clTabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        clTabelaNumero.setCellValueFactory(new PropertyValueFactory<>("numero_residencia"));
        atualizarTabela();
    }

    private void atualizarTabela() {
        try {
            clTabela.setItems(FXCollections.observableArrayList(dao.listar()));
        } catch (Exception e) {
            e.printStackTrace(); }
    }

    public void salvarCliente() {
        try {
            if (clienteSelecionado == null) {
                dao.inserir(new Cliente(clNome.getText(), clEmail.getText(), clCpf.getText(), clTelefone.getText(), ));
            }
        }



}








}
