package br.com.loja.testes;

import br.com.loja.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("8Gb de memória RAM, 128Gb de armazenamento");
        celular.setPreco(new BigDecimal("1500"));

        //Para salvar precisamos de uma factory e uma entityManager
        //Dentro da factory passamos o nome do persistence-unit declarado no persistence.xml
        //para dizer que os dados serão salvos naquele banco
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager =  factory.createEntityManager();

        //Começa a fazer a ponte com o banco
        entityManager.getTransaction().begin();
        //adiciona o celular
        entityManager.persist(celular);
        //Commita para salvar a alteração no banco
        entityManager.getTransaction().commit();
        //Fechando a ponte
        entityManager.close();

    }
}
