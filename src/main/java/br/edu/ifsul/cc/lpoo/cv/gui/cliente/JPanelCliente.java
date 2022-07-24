/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.cliente;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class JPanelCliente extends JPanel {
    
    private Controle controle;
    private CardLayout cardLayout;
    
    private JPanelListagem telaListagem;
    private JPanelEdicao telaEdicao;
    
    
    
    
    
    public JPanelCliente(Controle controle){
        this.controle = controle;
        
        
        initComponents();
    }
    
    
    private void initComponents(){
        cardLayout = new CardLayout(); //inicializando o gerenciador
        this.setLayout(cardLayout); //setando o gerenciador de layout
        
        
        telaListagem = new JPanelListagem(this, controle); //inicializando a tela
        telaEdicao = new JPanelEdicao(this, controle); //inicializando a tela
        
        this.add(telaListagem, "tela_listagem"); //adicionando tela
        this.add(telaEdicao, "tela_edicao"); //adicionando tela
        
        
        cardLayout.show(this,"tela_listagem"); //mostra a tela listagem por padrao
        
    }
    
    
    
}
