/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import vulkan.declaracion.decMesas;

/**
 * @author fer3dev
 */

public class controlMesas implements Serializable{
    
    public controlMesas() {
        this.emf = Persistence.createEntityManagerFactory("base_datos_mysql");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void guardar(decMesas mesas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mesas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMesas(mesas.getId_mesa()) != null) {
                throw new PreexistingEntityException("Mesas " + mesas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(decMesas mesas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mesas = em.merge(mesas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesas.getId_mesa();
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
            decMesas mesas;
            try {
                mesas = em.getReference(decMesas.class, id);
                mesas.getId_mesa();
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
    public List<decMesas> findMesasEntities() {
        return findMesasEntities(true, -1, -1);
    }

    public List<decMesas> findMesasEntities(int maxResults, int firstResult) {
        return findMesasEntities(false, maxResults, firstResult);
    }

    private List<decMesas> findMesasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(decMesas.class));
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

    public decMesas findMesas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decMesas.class, id);
        } finally {
            em.close();
        }
    }
    
    public decMesas findMesas(String nombre_usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decMesas.class, nombre_usuario);
        } finally {
            em.close();
        }
    }

    public int getMesasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<decMesas> rt = cq.from(decMesas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
