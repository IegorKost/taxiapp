package com.iegor.itlabs.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Iegor on 19.08.2014.
 */
@Entity
@Table(name = "driver", schema = "", catalog = "taxiapp")
@NamedQuery(name = "DriverEntity.getAll", query = "SELECT d FROM DriverEntity d")
public class DriverEntity {
    private long driverId;
    private String firstName;
    private String lastName;
    private String autoPlate;
    private String brand;
    private String model;

    private List<OrderEntity> orderList;

    @OneToMany (mappedBy = "driver")
    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        this.orderList = orderList;
    }

    @Id
    @Column(name = "DRIVER_ID")
    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "AUTO_PLATE")
    public String getAutoPlate() {
        return autoPlate;
    }

    public void setAutoPlate(String autoPlate) {
        this.autoPlate = autoPlate;
    }

    @Basic
    @Column(name = "BRAND")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (driverId != that.driverId) return false;
        if (autoPlate != null ? !autoPlate.equals(that.autoPlate) : that.autoPlate != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (autoPlate != null ? autoPlate.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
