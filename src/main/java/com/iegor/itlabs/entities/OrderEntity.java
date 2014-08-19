package com.iegor.itlabs.entities;

import javax.persistence.*;
import java.util.LinkedList;

/**
 * Created by Iegor on 19.08.2014.
 */
@Entity
@Table(name = "order", schema = "", catalog = "taxiapp")
public class OrderEntity {
    private long orderId;
    private Long driverId;
    private String source;
    private String target;
    private String state;

    private DriverEntity driver;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "DRIVER_ID")
    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
        if(driver.getOrderList() == null) {
            driver.setOrderList(new LinkedList<OrderEntity>());
        }
        if (!driver.getOrderList().contains(this)) {
            driver.getOrderList().add(this);
        }
    }

    @Id
    @Column(name = "ORDER_ID")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "DRIVER_ID")
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "TARGET")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
