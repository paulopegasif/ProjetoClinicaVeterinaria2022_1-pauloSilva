package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuBarHome extends JMenuBar implements ActionListener {


    private Controle controle;
    private JMenu menuArquivo;
    private JMenuItem menuItemSair;


    private JMenu menuCadastro;
    private JMenuItem menuItemCliente;




    public JMenuBarHome(Controle controle){

        this.controle = controle;

        initComponents();
    }

    public void initComponents(){
        menuArquivo = new JMenu("Arquivo");
            menuItemSair = new JMenuItem("Sair");
            menuItemSair.addActionListener(this);
            menuItemSair.setActionCommand("menu_sair");
        menuArquivo.add(menuItemSair);

        menuCadastro = new JMenu("Cadastro");
            menuItemCliente = new JMenuItem("Cliente");
            menuItemCliente.addActionListener(this);
            menuItemCliente.setActionCommand("menu_cliente");
        menuCadastro.add(menuItemCliente);

        this.add(menuArquivo);
        this.add(menuCadastro);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(menuItemSair.getActionCommand())){

            //se clicar no menu item Sair
            int sair = JOptionPane.showConfirmDialog(this, "Deseja sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION);

            if(sair == 0){
                try {
                    controle.fecharBD();
                    System.exit(0); //finalizar o processo do programa

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }else if(e.getActionCommand().equals(menuItemCliente.getActionCommand())){
            //se clicar no menu item Cliente

            controle.showTela("tela_cliente"); //fazendo exibicao da tela cliente



        }


    }
}
