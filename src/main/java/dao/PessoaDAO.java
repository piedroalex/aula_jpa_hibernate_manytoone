package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Pessoa;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class PessoaDAO {

	public void salvar(Pessoa pessoa) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(pessoa);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Pessoa salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a pessoa!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
	public Pessoa buscarPorNome(String nome) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
    		TypedQuery<Pessoa> query = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nome = :nome", Pessoa.class);
    		query.setParameter("nome", nome);
    		return query.getSingleResult();
        } catch (Exception e) {
			System.out.println("Nenhuma pessoa encontrada!");
			e.printStackTrace();
			return null;
		}
    }
	
}
