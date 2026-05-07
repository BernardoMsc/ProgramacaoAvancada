/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.m
 */
public class ProdutoDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Produto pr) throws SQLException {
        String sql = ""
                + "INSERT INTO produtos (descricao, preco, quantidade) VALUES ("
                + "'" + pr.getDesc() + "',"
                + "" + pr.getPreco() + ","
                + "" + pr.getQuantidade() + " "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Produto> recuperarTodos() throws SQLException {
        ArrayList<Produto> Produto = new ArrayList();

        String sql = ""
                + "SELECT * FROM produtos ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Produto pr = new Produto();

            pr.setId(resultadoQ.getInt("id"));
            pr.setDesc(resultadoQ.getString("descricao"));
            pr.setPreco(resultadoQ.getDouble("preco"));
            pr.setQuantidade(resultadoQ.getInt("quantidade"));

            Produto.add(pr);
        }

        return Produto;
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM produtos WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

}
