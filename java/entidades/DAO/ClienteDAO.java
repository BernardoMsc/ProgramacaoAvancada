/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Cliente c) throws SQLException {
        String sql = ""
                + "INSERT INTO clientes ( nome, telefone, cpf, endereco) VALUES ("
                + "'" + c.getNome() + "',"
                + "'" + c.getTelefone() + "',"
                + "'" + c.getCpf() + "',"
                + "'" + c.getEndereco() + "'"
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Cliente> recuperarTodos() throws SQLException {
        ArrayList<Cliente> Cliente = new ArrayList();

        String sql = ""
                + "SELECT * FROM clientes ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cliente c = new Cliente();

            c.setId(resultadoQ.getInt("id"));
            c.setNome(resultadoQ.getString("nome"));
            c.setTelefone(resultadoQ.getString("telefone"));
            c.setCpf(resultadoQ.getString("cpf"));
            c.setEndereco(resultadoQ.getString("endereco"));

            Cliente.add(c);
        }

        return Cliente;
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM clientes WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
