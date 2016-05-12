package com.dcsoft.capmkt.orm;
// Generated Apr 18, 2016 3:24:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ChChannelCustomer.
 * @see com.dcsoft.capmkt.orm.ChChannelCustomer
 * @author Hibernate Tools
 */
public class ChChannelCustomerHome {

	private static final Log log = LogFactory.getLog(ChChannelCustomerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ChChannelCustomer transientInstance) {
		log.debug("persisting ChChannelCustomer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChChannelCustomer instance) {
		log.debug("attaching dirty ChChannelCustomer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChChannelCustomer instance) {
		log.debug("attaching clean ChChannelCustomer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChChannelCustomer persistentInstance) {
		log.debug("deleting ChChannelCustomer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChChannelCustomer merge(ChChannelCustomer detachedInstance) {
		log.debug("merging ChChannelCustomer instance");
		try {
			ChChannelCustomer result = (ChChannelCustomer) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChChannelCustomer findById(java.math.BigDecimal id) {
		log.debug("getting ChChannelCustomer instance with id: " + id);
		try {
			ChChannelCustomer instance = (ChChannelCustomer) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.ChChannelCustomer", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ChChannelCustomer> findByExample(ChChannelCustomer instance) {
		log.debug("finding ChChannelCustomer instance by example");
		try {
			List<ChChannelCustomer> results = (List<ChChannelCustomer>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.ChChannelCustomer").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
