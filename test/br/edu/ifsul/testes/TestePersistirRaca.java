package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
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
public class TestePersistirRaca {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirRaca() {
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
            Raca r = new Raca();
            r.setNome("Dog Alemão");
            r.setPorte("Gigante");
            r.setPesoMedio(85.00);
            r.setEspectativaVida("12 a 15 anos");
            r.setTemperamento("Calmo e estavel");
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }
    
}
