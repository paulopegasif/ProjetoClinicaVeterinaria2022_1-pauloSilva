
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import br.edu.ifsul.cc.lpoo.cv.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Prof. Telmo
 */
public class PersistenciaJDBC implements InterfacePersistencia {
    
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5433/avaliacaoLPOO_dbcv";
    private Connection con = null;



    public PersistenciaJDBC() throws Exception{
        
        Class.forName(DRIVER); //carregamento do driver postgresql em tempo de execução
        System.out.println("Tentando estabelecer conexao JDBC com : "+URL+" ...");
            
        this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA); 

        
    }

    public Boolean conexaoAberta() {
        
        try {
            if(con != null)
                return !con.isClosed();//verifica se a conexao está aberta
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return false;
        
    }

    @Override
    public void fecharConexao() {        
        
        try{                               
            this.con.close();//fecha a conexao.
            System.out.println("Fechou conexao JDBC");
        }catch(SQLException e){            
            e.printStackTrace();//gera uma pilha de erro na saida.
        } 
        
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persist(Object o) throws Exception {
        
        //questao 2 da primeira etapa.
        if(o instanceof Produto){
            
            Produto p = (Produto) o;
            if(p.getId() == null){
                
                PreparedStatement ps = this.con.prepareStatement("insert into tb_produto (id, nome, quantidade, tipo, valor, fornecedor_cpf) "
                                                               + "values (nextval('seq_produto_id'), ?, ?, ?, ?, ?) returning id;");
                ps.setString(1, p.getNome());
                ps.setFloat(2, p.getQuantidade());
                ps.setString(3, p.getTipo().name());
                ps.setFloat(4, p.getValor());
                ps.setString(5, p.getFornecedor().getCpf());
                
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p.setId(rs.getInt("id"));
                }
                
            }else{
                
                PreparedStatement ps = this.con.prepareStatement("update tb_produto set nome = ?, quantidade = ?, tipo = ?, valor = ?, fornecedor_cpf = ? "
                                                               + "where id = ?; ");
                
                ps.setString(1, p.getNome());
                ps.setFloat(2, p.getQuantidade());
                ps.setString(3, p.getTipo().name());
                ps.setFloat(4, p.getValor());
                ps.setString(5, p.getFornecedor().getCpf());
                ps.setInt(6, p.getId());
                
                ps.execute();
            
            }
            
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        
        //questao 3 da primeira etapa.
       if(o instanceof Produto){
           Produto p = (Produto) o;
           
           PreparedStatement ps = this.con.prepareStatement("delete from tb_produto where id = ?");
           ps.setInt(1, p.getId());
           
           ps.execute();
           
       }
    }

    @Override
    public List<Produto> listProdutos() throws Exception {
        
        //questao 4 da primeira etapa.
        List<Produto> lista;
        
         PreparedStatement ps = this.con.prepareStatement(" select p.id, p.nome, p.quantidade, p.tipo, p.valor, p.fornecedor_cpf, f.ie "
                                                        + " from tb_produto p, tb_fornecedor f where p.fornecedor_cpf=f.cpf order by id asc");
         
         ResultSet rs = ps.executeQuery();
         
         lista = new ArrayList();
         
         while(rs.next()){
             
             Produto p = new Produto();
             p.setId(rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setQuantidade(rs.getFloat("quantidade"));
             if(rs.getString("tipo") == TipoProduto.CONSULTA.name()){
                p.setTipo(TipoProduto.CONSULTA);
             }else if(rs.getString("tipo") == TipoProduto.ATENDIMENTO_AMBULATORIAL.name()){
                p.setTipo(TipoProduto.ATENDIMENTO_AMBULATORIAL);
             }
             p.setValor(rs.getFloat("valor"));
                Fornecedor fc = new Fornecedor();
                fc.setCpf(rs.getString("fornecedor_cpf"));
                fc.setIe(rs.getString("ie"));
             p.setFornecedor(fc);
             
             
             lista.add(p);
             
         }
         
         return lista;
        
    }

    @Override
    public Pessoa doLogin(String cpf, String senha) throws Exception {
        Pessoa pessoa = null;
        //cpf = "12345678900" -- testando;
        //senha = "12345" -- testando;

        PreparedStatement ps =
                this.con.prepareStatement("select p.nome, p.cpf, p.senha from tb_funcionario f, tb_pessoa p where p.cpf = ? and p.senha = ? ");

        ps.setString(1, cpf);
        ps.setString(2, senha);

        ResultSet rs = ps.executeQuery();//o ponteiro do REsultSet inicialmente está na linha -1

        if(rs.next()){//se a matriz (ResultSet) tem uma linha

            pessoa = new Pessoa();
            pessoa.setNome(rs.getString("nome"));
            pessoa.setCpf(rs.getString("cpf"));
        }

        ps.close();
        return pessoa;
    }
    
}
