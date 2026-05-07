/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoDelivery;

import Telas.TelaPrincipal;
import apoio.ConexaoBD;
import javax.swing.JOptionPane;

/**
 *
 * @author bernardo.morschheise
 */
public class ProjetoDelivery {

    public static void main(String[] args) {
        try {
            ConexaoBD.getInstance().getConnection();
            TelaPrincipal tp = new TelaPrincipal();
            tp.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!\nPor favor entre em contato com o suporte.");
        } finally {
            ConexaoBD.getInstance().shutdown();
        }
    }

}
