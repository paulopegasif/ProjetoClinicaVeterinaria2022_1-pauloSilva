
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJPA;
import java.util.Calendar;
import org.junit.Test;

/**
 *
 * @author Prof. Telmo
 */

public class TestPersistenciaJPA {
        
    //questao 1 da primeira avaliação
    //@Test
    public void testConexaoGeracaoTabelas(){
        
        PersistenciaJPA persistencia = new PersistenciaJPA();
        if(persistencia.conexaoAberta()){
            System.out.println("abriu a conexao com o BD via JPA");
            
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Nao abriu a conexao com o BD via JPA");
        }
        
    }
    
    
    //questao 5 da primeira avaliacao.
    //@Test
    public void testConexaoGeracaoFornecedor() throws Exception {
        
        PersistenciaJPA persistencia = new PersistenciaJPA();
        if(persistencia.conexaoAberta()){
            System.out.println("abriu a conexao com o BD via JPA");
            
            Fornecedor fc = (Fornecedor) persistencia.find(Fornecedor.class, "00001347188");
            if(fc == null){
                
                fc = new Fornecedor();
                fc.setCpf("00001347188");
                fc.setIe("123456");
                fc.setCnpj("456");
                fc.setData_cadastro(Calendar.getInstance());
                fc.setNome("teste");
                fc.setRg("789");
                fc.setSenha("123456");
                
                persistencia.persist(fc);
                
                
            }
            
            
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Nao abriu a conexao com o BD via JPA");
        }
        
    }
}
