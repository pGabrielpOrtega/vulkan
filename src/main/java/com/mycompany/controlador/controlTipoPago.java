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
import vulkan.declaracion.decTipoPago;

/**
 * @author fer3dev
 */

public class controlTipoPago implements Serializable{
    
    public controlTipoPago() {
        this.emf = Persistence.createEntityManagerFactory("base_datos_mysql");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void guardar(decTipoPago tipoPago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoPago(tipoPago.getId_tipo_pago()) != null) {
                throw new PreexistingEntityException("Tipo pago " + tipoPago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(decTipoPago tipoPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoPago = em.merge(tipoPago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoPago.getId_tipo_pago();
                if (findTipoPago(id) == null) {
                    throw new NonexistentEntityException("The tipo pago with id " + id + " no longer exists.");
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
            decTipoPago tipoPago;
            try {
                tipoPago = em.getReference(decTipoPago.class, id);
                tipoPago.getId_tipo_pago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo pago with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public List<decTipoPago> findTipoPagoEntities() {
        return findTipoPagoEntities(true, -1, -1);
    }

    public List<decTipoPago> findTipoPagoEntities(int maxResults, int firstResult) {
        return findTipoPagoEntities(false, maxResults, firstResult);
    }

    private List<decTipoPago> findTipoPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(decTipoPago.class));
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

    public decTipoPago findTipoPago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decTipoPago.class, id);
        } finally {
            em.close();
        }
    }
    
    public decTipoPago findTipoPago(String nombre_usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decTipoPago.class, nombre_usuario);
        } finally {
            em.close();
        }
    }

    public int getTipoPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<decTipoPago> rt = cq.from(decTipoPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
