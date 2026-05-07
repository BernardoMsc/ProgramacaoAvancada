/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.FuncionarioDAO;
import entidades.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.morschheise
 */
public class ControlaFuncionario {

    private FuncionarioDAO fDAO = new FuncionarioDAO();

    public boolean salvar(Funcionario f) {
        try {
            fDAO.salvar(f);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar funcionario: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Funcionario> recuperarTodos() {
        try {
            return fDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar funcionario: " + ex.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            fDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
            return false;
        }
    }

}
