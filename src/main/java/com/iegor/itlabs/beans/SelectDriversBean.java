package com.iegor.itlabs.beans;

import com.iegor.itlabs.entities.DriverDao;
import com.iegor.itlabs.entities.DriverEntity;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Iegor on 30.11.2014.
 */
@ManagedBean(name="selectDriversBean")
@RequestScoped
public class SelectDriversBean {

    @EJB
    private DriverDao driverDao;

    private DriverEntity driverEntity;
    private List<DriverEntity> driverEntities;
    private long id;

    public DriverEntity getDriverEntity() {
        return driverEntity;    }

    public void setDriverEntity(DriverEntity driverEntity) {
        this.driverEntity = driverEntity;
    }

    public List<DriverEntity> getDriverEntities() {
        return driverEntities;
    }

    public void setDriverEntities(List<DriverEntity> driverEntities) {
        this.driverEntities = driverEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriverInfo() {
        this.driverEntity = driverDao.get(id);
        return "success";
    }
}
