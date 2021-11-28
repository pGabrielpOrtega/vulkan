/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlador;
import clases.exceptions.NonexistentEntityException;
import clases.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import vulkan.declaracion.decPedidos;
/**
 *
 * @author gabri
 */
public class controlPedidos {
    public controlPedidos() {
        this.emf = Persistence.createEntityManagerFactory("base_datos_mysql");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void guardar(decPedidos mesas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mesas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMesas(mesas.getId_pedido()) != null) {
                throw new PreexistingEntityException("Mesas " + mesas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(decPedidos mesas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mesas = em.merge(mesas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesas.getId_pedido();
                if (findMesas(id) == null) {
                    throw new NonexistentEntityException("The mesas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            decPedidos mesas;
            try {
                mesas = em.getReference(decPedidos.class, id);
                mesas.getId_pedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesas with id " + id + " no longer exists.", enfe);
            }
            em.remove(mesas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public List<decPedidos> findMesasEntities() {
        return findMesasEntities(true, -1, -1);
    }

    public List<decPedidos> findMesasEntities(int maxResults, int firstResult) {
        return findMesasEntities(false, maxResults, firstResult);
    }

    private List<decPedidos> findMesasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(decPedidos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public decPedidos findMesas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decPedidos.class, id);
        } finally {
            em.close();
        }
    }
    
    public decPedidos findMesas(String nombre_usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decPedidos.class, nombre_usuario);
        } finally {
            em.close();
        }
    }

    public int getMesasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<decPedidos> rt = cq.from(decPedidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
