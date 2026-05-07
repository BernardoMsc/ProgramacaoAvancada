/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.m
 */
public class FuncionarioDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Funcionario f) throws SQLException {
        String sql = ""
                + "INSERT INTO funcionarios (nome, cpf, telefone, funcao, salario) VALUES ("
                + "'" + f.getNome() + "',"
                + "'" + f.getCpf() + "',"
                + "'" + f.getTelefone() + "',"
                + "'" + f.getFuncao() + "',"
                + "" + f.getSalario() + " "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Funcionario> recuperarTodos() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList();

        String sql = ""
                + "SELECT * FROM funcionarios ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Funcionario f = new Funcionario();

            f.setId(resultadoQ.getInt("id"));
            f.setNome(resultadoQ.getString("nome"));
            f.setCpf(resultadoQ.getString("cpf"));
            f.setTelefone(resultadoQ.getString("telefone"));
            f.setFuncao(resultadoQ.getString("funcao"));
            f.setSalario((resultadoQ.getDouble("salario")));

            funcionarios.add(f);
        }

        return funcionarios;
    }

    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM funcionarios WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
