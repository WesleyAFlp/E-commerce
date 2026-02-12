package com.example.ecommercefx.controller;

import com.example.ecommercefx.dao.ClienteDAO;
import com.example.ecommercefx.dao.ProdutoDAO;
import com.example.ecommercefx.model.Cliente;
import com.example.ecommercefx.model.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;

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
    private TableColumn<Cliente, Integer> clTabelaId;
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
    private TableColumn<Cliente, Integer> clTabelaNumero;
    @FXML
    private TableColumn<Cliente, String> clTabelaComp;



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
        clTabelaComp.setCellValueFactory(new PropertyValueFactory<>("complemento"));
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
                dao.inserir(new Cliente(clNome.getText(), clEmail.getText(), clCpf.getText(), clTelefone.getText(), clEstado.getText(), clCidade.getText(), clCep.getText(), clEndereco.getText(), Integer.parseInt(clNumeroResidencia.getText()), clComplemento.getText()));
            } else {
                clienteSelecionado.setNome(clNome.getText());
                clienteSelecionado.setEmail(clEmail.getText());
                clienteSelecionado.setCpf(clCpf.getText());
                clienteSelecionado.setTelefone(clTelefone.getText());
                clienteSelecionado.setEstado(clEstado.getText());
                clienteSelecionado.setCidade(clCidade.getText());
                clienteSelecionado.setCep(clCep.getText());
                clienteSelecionado.setEndereco(clEndereco.getText());
                clienteSelecionado.setNumero_residencia(Integer.parseInt(clNumeroResidencia.getText()));
                clienteSelecionado.setComplemento(clComplemento.getText());
                dao.atualizar(clienteSelecionado);
            }
            atualizarTabela();
            limparCampos();
        } catch (Exception e) {
            exibirAlerta("Erro: ", e.getMessage());
        }
    }

    public void selecionarItem() {
        clienteSelecionado = clTabela.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            clNome.setText(clienteSelecionado.getNome());
            clEmail.setText(clienteSelecionado.getEmail());
            clCpf.setText(clienteSelecionado.getCpf());
            clTelefone.setText(clienteSelecionado.getTelefone());
            clEstado.setText(clienteSelecionado.getEstado());
            clCidade.setText(clienteSelecionado.getCidade());
            clCep.setText(clienteSelecionado.getCep());
            clEndereco.setText(clienteSelecionado.getEndereco());
            clNumeroResidencia.setText(String.valueOf(clienteSelecionado.getNumero_residencia()));
            clComplemento.setText(clienteSelecionado.getComplemento());
        }
    }

    public void limparCampos() {
        clNome.clear();
        clEmail.clear();
        clCpf.clear();
        clTelefone.clear();
        clEstado.clear();
        clCidade.clear();
        clCep.clear();
        clEndereco.clear();
        clNumeroResidencia.clear();
        clComplemento.clear();
        clienteSelecionado = null;
        clTabela.getSelectionModel().clearSelection();
    }

    public void excluirCliente() {
        if (clienteSelecionado != null) {
            try {
                dao.deletar(clienteSelecionado.getId());
                atualizarTabela();
                limparCampos();
            } catch (Exception e) { exibirAlerta("Erro", e.getMessage()); }
        }
    }

    private void exibirAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(msg);
        alert.show();
    }
}