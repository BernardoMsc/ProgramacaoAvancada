/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.ProdutoDAO;
import entidades.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.morschheise
 */
public class ControlaProduto {

    private ProdutoDAO prDAO = new ProdutoDAO();

    public boolean salvar(Produto pr) {
        try {
            prDAO.salvar(pr);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produto: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Produto> recuperarTodos() {
        try {
            return prDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produto: " + ex.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            prDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
            return false;
        }
    }
}
