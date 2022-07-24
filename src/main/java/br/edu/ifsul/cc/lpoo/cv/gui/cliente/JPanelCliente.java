package br.edu.ifsul.cc.lpoo.cv.gui.cliente;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import java.awt.*;

public class JPanelCliente extends JPanel {

    private Controle controle;
    private CardLayout cardLayout;


    private JPanelListagem telaListagem;
    private JPanelEdicao telaEdicao;


    public JPanelCliente (Controle controle){
        this.controle = controle;

        initComponents();
    }



    private void initComponents(){

        cardLayout = new CardLayout(); //inicializando um novo gerenciador de layout
        this.setLayout(cardLayout); //definindo o gerenciador de layout no painel

        telaListagem = new JPanelListagem(this, controle);
        telaEdicao = new JPanelEdicao(this, controle);


        this.add(telaListagem, "tela_listagem"); //adicionando tela
        this.add(telaEdicao, "tela_edicao"); //adicionando tela


        cardLayout.show(this,"tela_listagem"); //tela apresentada por padrao







    }

}
