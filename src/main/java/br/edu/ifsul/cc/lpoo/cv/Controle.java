package br.edu.ifsul.cc.lpoo.cv;

import br.edu.ifsul.cc.lpoo.cv.gui.JFrameMain;
import br.edu.ifsul.cc.lpoo.cv.gui.JMenuBarHome;
import br.edu.ifsul.cc.lpoo.cv.gui.JPanelWelcome;
import br.edu.ifsul.cc.lpoo.cv.gui.autenticacao.JPanelAutenticacao;
import br.edu.ifsul.cc.lpoo.cv.gui.cliente.JPanelCliente;
import br.edu.ifsul.cc.lpoo.cv.model.Pessoa;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;

import javax.swing.*;

public class Controle {

    private PersistenciaJDBC conxaoJDBC;
    private JFrameMain frame;
    private JPanelAutenticacao pnlAutenticacao;
    private JMenuBarHome menuBar;
    private JPanelWelcome pnlHome;
    //private JPanelCliente painelCliente;


    public Controle(){



    }

    public void initComponents(){

        frame = new JFrameMain(this);

        pnlAutenticacao = new JPanelAutenticacao(this);

        menuBar = new JMenuBarHome(this);

        pnlHome = new JPanelWelcome(this);

        //painelCliente = new JPanelCliente(this);

        frame.addTela(pnlAutenticacao, "tela_autenticacao");
        frame.addTela(pnlHome,"tela_home");
        //frame.addTela(painelCliente,"tela_cliente");

        frame.showTela("tela_autenticacao");

        frame.setVisible(true); //torna o frame visível


    }

    public boolean conectarBD() throws Exception{
        PersistenciaJDBC conexaoJDBC;
        conexaoJDBC = new PersistenciaJDBC();


        if(conexaoJDBC != null){
            return conexaoJDBC.conexaoAberta();
        }

        return false;
    }

    public void fecharBD() throws Exception {
        PersistenciaJDBC conexaoJDBC;
        conexaoJDBC = new PersistenciaJDBC();
        System.out.println("Fechando conexão com o BD");
        conexaoJDBC.fecharConexao();
    }


    public void autenticar(String login, String senha) {
        try {
            PersistenciaJDBC conexaoJDBC;
            conexaoJDBC = new PersistenciaJDBC();
            Pessoa p = conexaoJDBC.doLogin(login,senha);

            if(p != null){

                JOptionPane.showMessageDialog(pnlAutenticacao, "Olá, " + p.getNome() +  "! Seja bem-vindo(a) ao sistema.", "Autenticacao", JOptionPane.INFORMATION_MESSAGE);

                frame.setJMenuBar(menuBar); //adicionando o menu no frame

                frame.showTela("tela_home"); //mudando de tela





            }else{
                JOptionPane.showMessageDialog(pnlAutenticacao, "Dados Inválidos ou incorretos!", "Autenticacao", JOptionPane.INFORMATION_MESSAGE);
            }




        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(pnlAutenticacao, "Erro ao executar a autenticação no Banco de Dados!", "Autenticacao", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showTela(String nomeTela){
        frame.showTela(nomeTela);
    }
}
