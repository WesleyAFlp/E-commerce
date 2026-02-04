package com.example.ecommercefx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/// Alert Library
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    /// Métodos JavaFx
    @FXML
    private BorderPane root;

    /// Initialize
    public void initialize() {
        carregarTela("Home.fxml");
    }

    /// Abrir tela Home
    @FXML
    public void abrirHome(){
        carregarTela ("Home.fxml");
    }

    /// Abrir tela Clientes
    public void abrirClientes(){
        carregarTela ("Clientes.fxml");
    }

    /// Abrir tela Produtos
    public void abrirProdutos(){
        carregarTela ("Produtos.fxml");
    }

    /// Abrir tela Login
    public void abrirLogin() { carregarTela("Login.fxml"); }

    /// Abrir tela NovaVenda
    public void abrirNovaVenda() { carregarTela("NovaVenda.fxml"); }

    /// Abrir tela Relatorios
    public void abrirRelatorios() { carregarTela("Relatorios.fxml"); }

    /// Abrir tela Ajuda
    public void abrirAjuda(ActionEvent event){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sobre o Sistema");
        alert.setHeaderText("Informações do Sistema");
        alert.setContentText(
                "Nome: E-commerce Completude\n" +
                        "Versão: 1.0.0\n" +
                        "Desenvolvedor: Wesley Carvalho\n" +
                        "Ano: 2026"
        );
        alert.showAndWait();
    }

    /// Método carregarTela para reaproveitamento de código
    private void carregarTela(String fxml){
        try{
            root.setCenter(
                    FXMLLoader.load(getClass().getResource("/fxml/" + fxml))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
