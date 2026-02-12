package com.example.ecommercefx.controller;


import com.example.ecommercefx.dao.ProdutoDAO;
import com.example.ecommercefx.model.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdutosController {

    @FXML
    private TextField prNome;
    @FXML
    private TextField prSku;
    @FXML
    private TextField prPreco;
    @FXML
    private TextField prQuantidade;
    @FXML
    private TableView<Produto> prTabela;
    @FXML
    private TableColumn<Produto, String> prTabelaSku;
    @FXML
    private TableColumn<Produto, String> prTabelaNome;
    @FXML
    private TableColumn<Produto, Double> prTabelaPreco;
    @FXML
    private TableColumn<Produto, Integer> prTabelaQuantidade;

    private ProdutoDAO dao = new ProdutoDAO();
    private Produto produtoSelecionado;

    public void initialize() {
        prTabelaSku.setCellValueFactory(new PropertyValueFactory<>("sku"));
        prTabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        prTabelaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        prTabelaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        atualizarTabela();
    }

    private void atualizarTabela(){
        try{
            prTabela.setItems(FXCollections.observableArrayList(dao.listar()));
        }catch (Exception e) {
            e.printStackTrace(); }
    }

    public void salvarProduto() {
        try {
            if (produtoSelecionado == null) {
                dao.inserir(new Produto(prSku.getText(), prNome.getText(), Double.parseDouble(prPreco.getText()), Integer.parseInt(prQuantidade.getText())));
            } else {
                produtoSelecionado.setSku(prSku.getText());
                produtoSelecionado.setNome(prNome.getText());
                produtoSelecionado.setPreco(Double.parseDouble(prPreco.getText()));
                produtoSelecionado.setQuantidade(Integer.parseInt(prQuantidade.getText()));
                dao.atualizar(produtoSelecionado);
            }
            atualizarTabela();
            limparCampos();
        } catch (Exception e) {
            exibirAlerta("Erro: ", e.getMessage());
        }
    }

    public void selecionarItem() {
        produtoSelecionado = prTabela.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            prSku.setText(produtoSelecionado.getSku());
            prNome.setText(produtoSelecionado.getNome());
            prPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
            prQuantidade.setText(String.valueOf(produtoSelecionado.getQuantidade()));
        }
    }

    public void limparCampos() {
        prSku.clear();
        prNome.clear();
        prPreco.clear();
        prQuantidade.clear();
        produtoSelecionado = null;
        prTabela.getSelectionModel().clearSelection();
    }


    public void excluirProduto() {
        if (produtoSelecionado != null) {
            try {
                dao.deletar(produtoSelecionado.getId());
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
