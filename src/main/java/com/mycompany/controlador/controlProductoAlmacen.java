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
import vulkan.declaracion.decProductoAlmacen;

/**
 * @author fer3dev
 */

public class controlProductoAlmacen implements Serializable{
    
    public controlProductoAlmacen() {
        this.emf = Persistence.createEntityManagerFactory("base_datos_mysql");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void guardar(decProductoAlmacen productoAlmacen) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoAlmacen);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoAlmacen(productoAlmacen.getId_almacen()) != null) {
                throw new PreexistingEntityException("Producto almacen " + productoAlmacen + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(decProductoAlmacen productoAlmacen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoAlmacen = em.merge(productoAlmacen);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = productoAlmacen.getId_almacen();
                if (findProductoAlmacen(id) == null) {
                    throw new NonexistentEntityException("The producto almacen with id " + id + " no longer exists.");
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
            decProductoAlmacen productoAlmacen;
            try {
                productoAlmacen = em.getReference(decProductoAlmacen.class, id);
                productoAlmacen.getId_almacen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reservacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoAlmacen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public List<decProductoAlmacen> findProductoAlmacenEntities() {
        return findProductoAlmacenEntities(true, -1, -1);
    }

    public List<decProductoAlmacen> finduProductoAlmacenEntities(int maxResults, int firstResult) {
        return findProductoAlmacenEntities(false, maxResults, firstResult);
    }

    private List<decProductoAlmacen> findProductoAlmacenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(decProductoAlmacen.class));
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

    public decProductoAlmacen findProductoAlmacen(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decProductoAlmacen.class, id);
        } finally {
            em.close();
        }
    }
    
    public decProductoAlmacen findProductoAlmacen(String nombre_usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(decProductoAlmacen.class, nombre_usuario);
        } finally {
            em.close();
        }
    }

    public int getProductoAlmacenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<decProductoAlmacen> rt = cq.from(decProductoAlmacen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
