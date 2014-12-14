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
public class DriverDao {

    @PersistenceContext(unitName = "taxiappunit")
    private EntityManager em;

    public DriverEntity add(DriverEntity driver) {
        return em.merge(driver);
    }

    public DriverEntity get(long id) {
        return em.find(DriverEntity.class, id);
    }

    public void update(DriverEntity driver) {
        add(driver);
    }

    public void delete(long id) {
        em.remove(get(id));
    }

    public List<DriverEntity> getAll() {
        TypedQuery<DriverEntity> namedQuery = em.createNamedQuery("DriverEntity.getAll", DriverEntity.class);
        return namedQuery.getResultList();
    }
}
