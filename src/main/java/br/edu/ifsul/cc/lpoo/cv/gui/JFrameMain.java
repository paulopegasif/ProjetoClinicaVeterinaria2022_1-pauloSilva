package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JFrameMain extends JFrame implements WindowListener {


    public Controle controle;
    public CardLayout cardLayout;
    public JPanel painelFundo;

    public JFrameMain(Controle controle){

        this.controle = controle;

        initComponents();
    }

    private void initComponents(){
        this.setTitle("Clínica Veterinária");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //abre maximizado por padrão
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //finaliza o processo quando a janela é fechada
        this.addWindowListener(this); //adiciona o listener no frame

        cardLayout = new CardLayout(); //inicializando o gerenciador de layout
        painelFundo = new JPanel();

        painelFundo.setLayout(cardLayout); //defininco o car para o painel de fundo

        this.add(painelFundo);

    }

    public void addTela(JPanel painel, String nome){

        painelFundo.add(painel,nome);
    }

    public void showTela(String nome){

        cardLayout.show(painelFundo,nome);
    }




    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        try {
            controle.fecharBD();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
