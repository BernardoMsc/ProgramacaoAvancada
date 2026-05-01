/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Cliente;
import entidades.DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.morschheise
 */
public class TestandoCliente {

    private ClienteDAO cDAO = new ClienteDAO();
    int codigo = 1;

    public boolean salvar(Cliente c) {
        try {
            c.setId(codigo);
            cDAO.salvar(c);
            codigo++;
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Cliente> recuperarTodos() {
        try {
            return cDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            cDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
            return false;
        }
    }
}
