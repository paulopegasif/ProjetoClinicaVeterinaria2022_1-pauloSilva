package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JPanelWelcome extends JPanel {


    private Controle controle;

    private JLabel lblMensagem;
    private JLabel lblData;
    private JLabel lblImagem;
    private BorderLayout layout;




    public JPanelWelcome(Controle controle){

        this.controle = controle;
        initComponents();
    }

    private void initComponents(){

        layout = new BorderLayout(); //inicializando o gerenciador
        this.setLayout(layout);
        lblMensagem = new JLabel("Home");
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblMensagem, BorderLayout.NORTH); //posicionando a mensagem no top

        lblImagem = new JLabel(new ImageIcon(JPanelWelcome.class.getResource("/images/logo.png")));
        this.add(lblImagem, BorderLayout.CENTER); //posicionando a imagem no centro

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        lblData = new JLabel(sdf.format(c.getTime()));
        lblData.setHorizontalAlignment(SwingConstants.CENTER);
        lblData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(lblData, BorderLayout.SOUTH); //posicionando a data no footer

    }
}
