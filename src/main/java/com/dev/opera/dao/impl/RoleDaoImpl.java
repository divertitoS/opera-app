package com.dev.opera.dao.impl;

import com.dev.opera.dao.AbstractDao;
import com.dev.opera.dao.RoleDao;
import com.dev.opera.exception.DataProcessingException;
import com.dev.opera.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role add(Role role) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save role into DB: " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> findByNameQuery = session.createQuery("FROM Role r "
                    + "WHERE r.name = :roleName", Role.class);
            findByNameQuery.setParameter("roleName", roleName);
            return findByNameQuery.getSingleResult();
        }
    }
}
