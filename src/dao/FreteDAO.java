package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fretes.Frete;
import util.JPAUtil;

public class FreteDAO {
	private EntityManager em;

	public FreteDAO() {
	}

	public boolean salvar(Frete entity) {
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

	public boolean atualizar(Frete entity) {
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
			Frete entity = em.find(Frete.class, id);
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

	public List<Frete> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Frete> query = em.createQuery(
					"SELECT obj FROM Frete obj", Frete.class);
			List<Frete> fretes = query.getResultList();
			return fretes;
		} catch (RuntimeException e) {
			return null;
		}
	}

}
