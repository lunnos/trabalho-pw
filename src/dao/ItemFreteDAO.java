package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fretes.ItemFrete;
import util.JPAUtil;

public class ItemFreteDAO {
	private EntityManager em;

	public ItemFreteDAO() {
	}

	public boolean salvar(ItemFrete entity) {
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

	public boolean atualizar(ItemFrete entity) {
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
			ItemFrete entity = em.find(ItemFrete.class, id);
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

	public List<ItemFrete> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<ItemFrete> query = em.createQuery(
					"SELECT obj FROM ItemFrete obj", ItemFrete.class);
			List<ItemFrete> itens = query.getResultList();
			return itens;
		} catch (RuntimeException e) {
			return null;
		}
	}

}
