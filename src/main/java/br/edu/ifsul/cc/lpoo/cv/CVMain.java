
package br.edu.ifsul.cc.lpoo.cv;

import javax.swing.*;

/**
 *
 * @author Prof. Telmo Júnior
 * 
 * Avaliação da Segunda Etapa. 
 */
public class CVMain {


    private Controle controle;


    public CVMain() { //construtor


        try{
            controle = new Controle();

            if(controle.conectarBD()){

                controle.initComponents();


            }else{
                JOptionPane.showMessageDialog(null,"Não foi possível conectar com o Banco de Dados!");
            }
        } catch (Exception e){

            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar no Banco de Dados: "+ e.getLocalizedMessage(), "Banco de Dados", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }

        
    }

    public static void main(String[] args) {
        new CVMain();
    }
    
}
