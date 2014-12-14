package com.iegor.itlabs.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Iegor on 21.11.2014.
 */

@Stateless
public class OrderDao {

    @PersistenceContext(unitName = "taxiappunit")
    private EntityManager em;

    public OrderEntity add(OrderEntity order) {
        return em.merge(order);
    }

    public OrderEntity get(long id) {
        return em.find(OrderEntity.class, id);
    }

    public void update(OrderEntity order) {
        add(order);
    }

    public void delete(long id) {
        em.remove(get(id));
    }

    public List<OrderEntity> getAll() {
        TypedQuery<OrderEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", OrderEntity.class);
        return namedQuery.getResultList();
    }
}
