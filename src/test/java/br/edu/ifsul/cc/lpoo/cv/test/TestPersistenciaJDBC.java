
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import br.edu.ifsul.cc.lpoo.cv.model.Produto;
import br.edu.ifsul.cc.lpoo.cv.model.TipoProduto;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author Prof. Telmo (Avaliação da segunda etapa.)
 */


public class TestPersistenciaJDBC {
    
    @Test
    public void testConexao() throws Exception {
        
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        if(persistencia.conexaoAberta()){
            System.out.println("abriu a conexao com o BD via JDBC");
            
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Nao abriu a conexao com o BD via JDBC");
        }
        
    }
    
    
    //questao 6 da primeira etapa.
    //@Test
    public void testPersistenciaProduto() throws Exception {
        
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        if(persistencia.conexaoAberta()){
            System.out.println("abriu a conexao com o BD via JDBC - listando produtos");
            
            List<Produto> lista =  persistencia.listProdutos();
            
            if(lista != null && !lista.isEmpty()){
                
                for(Produto p : lista){
                    System.out.println("Produto :"+p.getId()+ " nome: "+p.getNome());
                    
                    persistencia.remover(p);
                }
                
                
            }else{
                
                System.out.println("cadastrando novo produto ...");
                Produto p = new Produto();
                p.setNome("produto de teste");
                Fornecedor f = new Fornecedor();
                f.setCpf("00001347188");
                p.setFornecedor(f);
                p.setQuantidade(100f);
                p.setTipo(TipoProduto.CONSULTA);
                p.setValor(120f);
                
                persistencia.persist(p);
                
                System.out.println("Cadastrou o produto: "+p.getId());
            }
            
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Nao abriu a conexao com o BD via JDBC");
        }
        
    }
    
}
