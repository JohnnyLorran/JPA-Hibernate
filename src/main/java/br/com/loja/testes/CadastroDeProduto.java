package br.com.loja.testes;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1L;

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        Produto p = produtoDAO.buscarProdutoId(1L);
        System.out.println(p.getPreco());

        List<Produto> produtos = produtoDAO.buscarProdutoPorCategoria("CELULARES");

        produtos.forEach( pr -> System.out.println(pr.getNome()));

        BigDecimal precoDoProduto = produtoDAO.buscarProdutoPreco("Xiaomi Redmi");
        System.out.println(precoDoProduto);

    }

    private static void cadastrarProduto(){
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi","8Gb de memória RAM, 128Gb de armazenamento",new BigDecimal("1500"), celulares);


        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);


        //Começa a fazer a ponte com o banco
        entityManager.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        //adiciona o celular
        produtoDAO.cadastrar(celular);
        //Commita para salvar a alteração no banco
        entityManager.getTransaction().commit();
        //Fechando a ponte
        entityManager.close();
    }

}
