package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pessoas.Cliente;
import util.JPAUtil;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO() {
   // O construtor vazio é util para inicializar objetos sem passar parâmetros
 }

	public boolean salvar(Cliente entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean atualizar(Cliente entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean remover(long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Cliente entity = em.find(Cliente.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public List<Cliente> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Cliente> query = em.createQuery(
					"SELECT obj FROM Cliente obj", Cliente.class);
			List<Cliente> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			return null;
		}
	}

}
