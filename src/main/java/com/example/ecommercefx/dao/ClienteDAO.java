package com.example.ecommercefx.dao;
/// ==========================================================
/// ClienteDAO
/// ==========================================================

import com.example.ecommercefx.model.Cliente;
import com.example.ecommercefx.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe de Acesso a Dados (DAO) para a entidade Cliente.
 * Implementa todas as operações CRUD (Create, Read, Update, Delete).
 */

public class ClienteDAO {
    private Connection connection;
    public ClienteDAO() {}

    /// Método CREATE (Insere um novo produto na tabela)
    public void inserir(Cliente cliente){
        // Query SQL usa '?' (placeholders) para segurança (PreparedStatement).
        String sql = "INSERT INTO clientes (nome, email, cpf, telefone, cep, endereco, estado, cidade, numero_residencia, complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources: Garante o fechamento automático da Conexão e do PreparedStatement.
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Mapeamento do objeto Produto para Query SQL .
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCidade());
            stmt.setInt(9, cliente.getNumero_residencia());
            stmt.setString(10, cliente.getComplemento());

            // Executa a instrução SQL de modificação (INSERT).
            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");

        }catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }

    }

    /**
     * READ ALL: Lista todos os produtos do BD.
     * @return Lista de objetos Produto.
     */

    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // executeQuery() retorna o ResultSet (conjunto de resultados).
            ResultSet rs = stmt.executeQuery();

            // Itera sobre cada linha retornada pelo banco de dados.
            while(rs.next()) {
                // Mapeamento reverso: Converte a linha do BD em um objeto Produto.
                Cliente c = new Cliente (
                    rs.getInt("idCliente"), // pega o valor da coluna id
                    rs.getString("nome"), // pega o valor da coluna nome
                    rs.getString("email"), // pega o valor da coluna email
                    rs.getString("cpf"), // pega o valor da coluna cpf
                    rs.getString("telefone"), // pega o valor da coluna telefone
                    rs.getString("cep"), // pega o valor da coluna cep
                    rs.getString("endereco"), // pega o valor da coluna endereco
                    rs.getString("estado"), // pega o valor da coluna estado
                    rs.getString("cidade"), // pega o valor da coluna cidade
                    rs.getInt("numero_residencia"), // pega o valor da coluna numero_residencia
                    rs.getString("complemento") // pega o valor da coluna complemento
                );
                lista.add(c);
            }

        }catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    /**
     * UPDATE: Atualiza os dados de um produto existente pelo ID.
     */

    public void atualizar(Cliente cliente) {
        // A cláusula WHERE id = ? é essencial para garantir a atualização do registro correto.
        String sql = "UPDATE clientes SET nome = ?, email = ?, cpf = ?, telefone = ?, cep = ?, endereco = ?, estado = ?, cidade = ?, numero_residencia = ?, complemento = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 1. Novos valores para Nome, Email, Cpf, Telefone, Cep, Endereco, Estado, Cidade, Numero_residencia e Complemento.
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCidade());
            stmt.setInt(9, cliente.getNumero_residencia());
            stmt.setString(10, cliente.getComplemento());

            // 2. ID do resgitro a ser atualizado (Condição WHERE).
            stmt.setInt(11, cliente.getId());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");



        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /**
     * DELETE: Remove um registro do BD com base no ID.
     */
    public void deletar(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o id do produto a ser deletado
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");

        }catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

}
