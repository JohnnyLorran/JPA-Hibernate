package br.com.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    //Para salvar precisamos de uma factory e uma entityManager
    //Dentro da factory passamos o nome do persistence-unit declarado no persistence.xml
    //para dizer que os dados serão salvos naquele banco
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
      return  FACTORY.createEntityManager();
    }
}
