package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Animal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isabela
 */
public class TestePersistirAnimal {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAnimal() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2017-1-6N1-Trab-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Animal a = new Animal();
            a.setNome("Juquinha");
            a.setIdade("8 meses");
            a.setCor("Caramelo");
            a.setPelagem("Curto");
            a.setCastrado(false);
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }

}
