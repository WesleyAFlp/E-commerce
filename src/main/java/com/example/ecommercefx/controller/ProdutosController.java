package com.example.ecommercefx.controller;


import com.example.ecommercefx.dao.ProdutoDAO;
import com.example.ecommercefx.model.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdutosController {

    private TextField prNome;
    private TextField prSku;
    private TextField prPreco;
    private Spinner prQuantidade;
    private TableView<Produto> prTabela;
    private TableColumn<Produto, String> prTabelaCodigo;
    private TableColumn<Produto, String> prTabelaNome;
    private TableColumn<Produto, Double> prTabelaPreco;
    private TableColumn<Produto, Integer> prTabelaQuantidade;

    private ProdutoDAO dao = new ProdutoDAO();
    private Produto produtoSelecionado;

    public void initialize() {
        prTabelaCodigo.setCellValueFactory(new PropertyValueFactory<>("sku"));
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
                dao.inserir(new Produto(prSku.getText(), prNome.getText(), Double.parseDouble(prPreco.getText()), Integer.parseInt(prQuantidade.getPromptText())));
            } else {
                produtoSelecionado.setSku(prSku.getText());
                produtoSelecionado.setNome(prNome.getText());
                produtoSelecionado.setPreco(Double.parseDouble(prPreco.getText()));
                produtoSelecionado.setQuantidade(Integer.parseInt(prQuantidade.getPromptText()));
                dao.atualizar(produtoSelecionado);
            }
            atualizarTabela();
            limparCampos();
        } catch (Exception e) {
            exibirAlerta("Erro: ", e.getMessage());
        }

        public void selecionarItem() {
            produtoSelecionado = prTabela.getSelectionModel().getSelectedItem();
            if (produtoSelecionado != null) {
                prSku.setText(produtoSelecionado.getSku());
                prNome.setText(produtoSelecionado.getNome());
                prPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
                prQuantidade.setText(produtoSelecionado.getQuantidade()); // Erro!

            }
        }

}
