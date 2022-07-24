
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import br.edu.ifsul.cc.lpoo.cv.model.Pessoa;
import br.edu.ifsul.cc.lpoo.cv.model.Produto;
import java.util.List;

/**
 *
 * @author Prof. Telmo (Avaliação da primeira etapa - 30/05/2022)
 */

public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    public void fecharConexao();
    public Object find(Class c, Object id) throws Exception;
    public void persist(Object o) throws Exception;
    public void remover(Object o) throws Exception;
    
    public List<Produto> listProdutos() throws Exception;

    Pessoa doLogin(String cpf, String senha) throws Exception;
}
