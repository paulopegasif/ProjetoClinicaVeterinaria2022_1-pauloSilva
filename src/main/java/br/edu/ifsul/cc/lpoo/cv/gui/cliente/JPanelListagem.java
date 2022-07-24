package br.edu.ifsul.cc.lpoo.cv.gui.cliente;

import br.edu.ifsul.cc.lpoo.cv.Controle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JPanelListagem extends JPanel {
    private JPanel panel1;
    private JPanel painelSuperior;
    private JPanel painelCentro;
    private JPanel painelInferior;
    private JLabel lblFiltro;
    private JTextField textFiltrar;
    private JButton buttonFiltrar;
    private JButton buttonNovo;
    private JButton buttonRemover;
    private JButton buttonEditar;
    private JButton buttonCancelar;
    private JScrollPane scrollRolagem;
    private JTable tableListClientes;

    private JPanelCliente painelCliente; //criando uma instancia do painel
    private Controle controle;


    public JPanelListagem(JPanelCliente painelCliente, Controle controle){ //metodo construtor
        this.painelCliente = painelCliente;
        this.controle = controle;



        createTable();
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void createTable(){
        tableListClientes.setModel(new DefaultTableModel(
                null,
                new String[]{"CPF", "Nome", "Data Último Acesso", "Cidade", "Telefone", "E-mail"}
        ));
    }
}
