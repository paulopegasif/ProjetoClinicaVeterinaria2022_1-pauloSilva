package br.edu.ifsul.cc.lpoo.cv.gui.autenticacao;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelAutenticacao extends JPanel implements ActionListener {

    private Controle controle;
    private GridBagLayout gridLayout; //gerenciador de layout em grid
    private GridBagConstraints posicionador;

    private JLabel lblLogin;
    private JTextField txfLogin;
    private JLabel lblSenha;
    private JPasswordField psfSenha;
    private JButton btnLogar;




    public JPanelAutenticacao(Controle controle){

        this.controle = controle;
        initComponents();
    }

    private void initComponents(){
        gridLayout = new GridBagLayout(); //inicializando
        this.setLayout(gridLayout); //define o gerenciador no painel

        // -------- Campo de Login
        lblLogin = new JLabel("Login: ");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0; //posicionando linha vertical
        posicionador.gridx = 0; //posicionando linha horizontal
        this.add(lblLogin, posicionador);

        txfLogin = new JTextField(20);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0; //posicionando linha vertical
        posicionador.gridx = 1; //posicionando linha horizontal
        this.add(txfLogin, posicionador);

        // ---------- Campo da senha
        lblSenha = new JLabel("Senha: ");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1; //posicionando linha vertical
        posicionador.gridx = 0; //posicionando linha horizontal
        this.add(lblSenha, posicionador);

        psfSenha = new JPasswordField(20);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1; //posicionando linha vertical
        posicionador.gridx = 1; //posicionando linha horizontal
        this.add(psfSenha, posicionador);

        // ------------ Botão de Logar
        btnLogar = new JButton("Entrar");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2; //posicionando linha vertical
        posicionador.gridx = 1; //posicionando linha horizontal
        btnLogar.addActionListener(this); //adicionando um listener ao botao
        btnLogar.setActionCommand("logando");
        this.add(btnLogar, posicionador);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals(btnLogar.getActionCommand())){ //se o clique foi no botao entrar

            //validação dos campos

            if(txfLogin.getText().trim().length() == 11 && new String(psfSenha.getPassword()).trim().length() >= 5){

                String login = txfLogin.getText().trim();
                String senha = new String(psfSenha.getPassword()).trim();

                System.out.println(senha);
                System.out.println(login);



                controle.autenticar(login,senha);





            }else{
                JOptionPane.showMessageDialog(this,"Informe os dados de Login Corretos!", "Autenticacao",JOptionPane.ERROR_MESSAGE);
            }


        }

    }
}
