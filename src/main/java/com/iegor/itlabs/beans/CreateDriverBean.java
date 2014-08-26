package com.iegor.itlabs.beans;

import com.iegor.itlabs.entities.DriverEntity;
import com.iegor.itlabs.model.Driver;
import com.iegor.itlabs.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iegor on 04.08.2014.
 */
@ManagedBean(name="createDriverBean")
@RequestScoped
public class CreateDriverBean {

    private Driver driver = new Driver();

    private Map<String, String> brands = new HashMap<String, String>();

    public CreateDriverBean() {
        brands.put("Audi", "Audi");
        brands.put("BMW", "BMW");
        brands.put("Shkoda", "Shkoda");
        brands.put("Opel", "Opel");
    }

    public Map<String, String> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String> brands) {
        this.brands = brands;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String create(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            DriverEntity driverEntity = new DriverEntity();
            driverEntity.setAutoPlate(driver.getAutoPlate());
            driverEntity.setBrand(driver.getBrand());
            driverEntity.setFirstName(driver.getFirstName());
            driverEntity.setLastName(driver.getLastName());
            driverEntity.setModel(driver.getModel());
            long driverId = (Long) session.save(driverEntity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "viewDriver";

    }
}
