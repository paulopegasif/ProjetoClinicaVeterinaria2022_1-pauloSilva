/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.cliente;

import br.edu.ifsul.cc.lpoo.cv.Controle;

/**
 *
 * @author phmad
 */
public class JPanelEdicao extends javax.swing.JPanel {

    private JPanelCliente painelCliente;
    private Controle controle;
    
    
    public JPanelEdicao(JPanelCliente painelCliente, Controle controle) {
        
        this.painelCliente = painelCliente;
        this.controle = controle;
        
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSul = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelCentro = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jButtonSalvar.setBackground(new java.awt.Color(102, 255, 102));
        jButtonSalvar.setText("Salvar");
        jPanelSul.add(jButtonSalvar);

        jButtonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar.setText("Cancelar");
        jPanelSul.add(jButtonCancelar);

        add(jPanelSul, java.awt.BorderLayout.PAGE_END);

        jPanelCentro.setLayout(new java.awt.GridBagLayout());
        add(jPanelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JPanel jPanelCentro;
    private javax.swing.JPanel jPanelSul;
    // End of variables declaration//GEN-END:variables
}
