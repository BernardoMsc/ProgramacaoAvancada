/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.PedidoDAO;
import entidades.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bernardo.morschheise
 */
public class TestandoPedido {

    private PedidoDAO pDAO = new PedidoDAO();
    int codigo = 1;

    public boolean salvar(Pedido p) {
        try {
            p.setId(codigo);
            pDAO.salvar(p);
            codigo++;
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar pedido: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Pedido> recuperarTodos() {
        try {
            return pDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar pedido: " + ex.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            pDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
            return false;
        }
    }
}
