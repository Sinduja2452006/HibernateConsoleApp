package com.hostel.dao;

import com.hostel.bean.Allocation;
import com.hostel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AllocationDAO {

    public Allocation findAllocation(int allocationID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Allocation.class, allocationID);
        }
    }

    public int insertAllocation(Allocation allocation) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(allocation);
            tx.commit();
            return allocation.getAllocationID();   // return generated ID
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return -1;
        }
    }

    public boolean updateAllocation(Allocation allocation) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(allocation);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
