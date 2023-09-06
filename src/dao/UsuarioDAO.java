package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pessoas.Usuario;
import util.JPAUtil;

public class UsuarioDAO {

	private EntityManager em;

	public UsuarioDAO() {
	}

	public boolean salvar(Usuario entity) {
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

	public boolean atualizar(Usuario entity) {
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
			Usuario entity = em.find(Usuario.class, id);
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

	public List<Usuario> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Usuario> query = em.createQuery(
					"SELECT obj FROM Pessoa obj", Usuario.class);
			List<Usuario> usuarios = query.getResultList();
			return usuarios;
		} catch (RuntimeException e) {
			return null;
		}
	}
}
