package br.edu.ifsul.cc.lpoo.cv.gui.cliente;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;

public class JPanelEdicao extends JPanel {
    private JPanel panel1;
    private JPanel painelInferior;
    private JButton buttonSalvar;
    private JButton buttonCancelar;
    private JPanel painelCentro;

    private JPanelCliente painelCliente; //criando uma instancia do painel
    private Controle controle;



    public JPanelEdicao(JPanelCliente painelCliente, Controle controle){
        this.painelCliente = painelCliente;
        this.controle = controle;

    }
}
