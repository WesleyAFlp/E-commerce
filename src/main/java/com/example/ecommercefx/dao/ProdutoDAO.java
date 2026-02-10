package com.example.ecommercefx.dao;
/// ==========================================================
/// ProdutoDAO
/// ==========================================================

import com.example.ecommercefx.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Acesso a Dados (DAO) para a entidade Produto.
 * Implementa todas as operações CRUD (Create, Read, Update, Delete).
 */

public class ProdutoDAO {
    private Connection connection;
    public ProdutoDAO() {

    }
    /// Método CREATE (Insere um novo produto na tabela)
    public void inserir(Produto produto) throws SQLException {
        // Query SQL usa '?' (placeholders) para segurança (PreparedStatement).
        String sql = "INSERT INTO produtos (sku, nome, preco, quantidade) VALUES (?, ?, ?, ?)";

        // try-with-resources: Garante o fechamento automático da Conexão e do PreparedStatement.
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Mapeamento do objeto Produto para Query SQL .
            stmt.setString(1, produto.getSku());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            // Executa a instrução SQL de modificação (INSERT).
            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        }catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    /**
     * READ ALL: Lista todos os produtos do BD.
     * @return Lista de objetos Produto.
     */

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            // executeQuery() retorna o ResultSet (conjunto de resultados).
            ResultSet rs = stmt.executeQuery()) {

            // Itera sobre cada linha retornada pelo banco de dados.
            while (rs.next()) {
                // Mapeamento reverso: Converte a linha do BD em um objeto Produto.
                Produto p = new Produto (
                        rs.getInt("id"), // Pega o valor da coluna 'id'
                        rs.getString("sku"), // Pega o valor da coluna 'sku'
                        rs.getString("nome"), // Pega o valor da coluna 'nome'
                        rs.getDouble("preco"), // Pega o valor da coluna 'preco'
                        rs.getInt("quantidade") // Pega o valor da coluna 'quantidade'
                );
                lista.add(p);
            }

        }catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    /**
     * UPDATE: Atualiza os dados de um produto existente pelo ID.
     */

    public void atualizar(Produto produto){
        // A cláusula WHERE id = ? é essencial para garantir a atualização do registro correto.
        String sql = "UPDATE produto SET sku = ?, nome = ?, preco = ?, quantidade = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 1. Novos valores para Sku, Nome, Preco e Quantidade.
            stmt.setString(1, produto.getSku());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getId());

            // 2. ID do resgitro a ser atualizado (Condição WHERE).
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();

            System.out.println("Produto atualizado!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /**
     * DELETE: Remove um registro do BD com base no ID.
     */
    public void deletar(int id) {
        String sql = "DELETE produto WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o id do produto a ser deletado
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Produto deletado com sucesso!");
        }catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

}
