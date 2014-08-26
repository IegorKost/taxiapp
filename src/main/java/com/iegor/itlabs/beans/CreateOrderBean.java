package com.iegor.itlabs.beans;

import com.iegor.itlabs.entities.OrderEntity;
import com.iegor.itlabs.model.Order;
import com.iegor.itlabs.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Iegor on 10.08.2014.
 */
@ManagedBean(name = "createOrderBean")
@RequestScoped
public class CreateOrderBean {

    private Order order = new Order();

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String create(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setSource(order.getSource());
            orderEntity.setTarget(order.getTarget());
            orderEntity.setState(order.getState());
            orderEntity.setDriverId(order.getDriverId());
            long orderId = (Long)session.save(orderEntity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "viewOrder";
    }
}
