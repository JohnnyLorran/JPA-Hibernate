package br.com.loja.dao;

import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){this.entityManager.persist(produto);}

    public void atualizar(Produto produto){ this.entityManager.merge(produto);}

    public Produto buscarProdutoId(Long id){
       return entityManager.find(Produto.class,id);
    }

    public List<Produto> buscarTodos(){
        //Damos um select na entidade não no nome da tabela, diferentemente do mysql
        // o p é para trazer o objeto inteiro
        String jpql = "Select p from Produto p";
        //Passamos a String e o tipo do retorno
        return entityManager.createQuery(jpql,Produto.class).getResultList();
    }

    public List<Produto> buscarProdutoNome(String nome){
        //Damos um select na entidade não no nome da tabela, diferentemente do mysql
        // o p é para trazer o objeto inteiro
        String jpql = "Select p from Produto p where p.nome = :nome ";
        //Passamos a String e o tipo do retorno
        return entityManager.createQuery(jpql,Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public List<Produto> buscarProdutoPorCategoria(String nome){
        //Damos um select na entidade não no nome da tabela, diferentemente do mysql
        // o p é para trazer o objeto inteiro
        String jpql = "Select p from Produto p where p.categoria.nome = :nome ";
        //Passamos a String e o tipo do retorno
        return entityManager.createQuery(jpql,Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public BigDecimal buscarProdutoPreco(String nome){
        //Damos um select na entidade não no nome da tabela, diferentemente do mysql
        // o p é para trazer o objeto inteiro
        String jpql = "Select p.preco from Produto p where p.nome = :nome ";
        //Passamos a String e o tipo do retorno
        return entityManager.createQuery(jpql,BigDecimal.class)
                .setParameter("nome",nome)
                .getSingleResult();
    }

}
