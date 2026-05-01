/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.m
 */
public class PedidoDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Pedido p) throws SQLException {
        String sql = ""
                + "INSERT INTO pedidos (data_pedido, status, forma_pagamento, observacoes) VALUES ("
                + "'" + p.getDataPedido() + "',"
                + "'" + p.getStatus() + "',"
                + "'" + p.getFormaPag() + "',"
                + "'" + p.getObs() + "'"
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Pedido> recuperarTodos() throws SQLException {
        ArrayList<Pedido> Pedido = new ArrayList();

        String sql = ""
                + "SELECT * FROM pedidos ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Pedido p = new Pedido();

            p.setId(resultadoQ.getInt("id"));
            //p.setClienteId(resultadoQ.getInt("cliente_id"));
            //p.setFuncionarioId(resultadoQ.getInt("funcionario_id"));
            p.setDataPedido(resultadoQ.getString("data_pedido"));
            p.setStatus(resultadoQ.getString("status"));
            p.setFormaPag(resultadoQ.getString("forma_pagamento"));
            p.setObs(resultadoQ.getString("observacoes"));

            Pedido.add(p);
        }

        return Pedido;
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM pedidos WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
