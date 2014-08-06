package com.iegor.itlabs.beans;

import com.iegor.itlabs.model.Driver;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iegor on 04.08.2014.
 */
@ManagedBean(name = "createDriverBean")
@SessionScoped
public class CreateDriverBean {

    public Map<String, String> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String> brands) {
        this.brands = brands;
    }

    private Map<String, String> brands = new HashMap<String, String>();

    private Driver driver = new Driver();

    public CreateDriverBean() {
        brands.put("Audi", "Audi");
        brands.put("BMW", "BMW");
        brands.put("Shkoda", "Shkoda");
        brands.put("Opel", "Opel");
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String create(){return "view";}
}
