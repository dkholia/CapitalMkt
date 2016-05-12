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
 * Home object for domain model class ChAddressInfo.
 * @see com.dcsoft.capmkt.orm.ChAddressInfo
 * @author Hibernate Tools
 */
public class ChAddressInfoHome {

	private static final Log log = LogFactory.getLog(ChAddressInfoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ChAddressInfo transientInstance) {
		log.debug("persisting ChAddressInfo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChAddressInfo instance) {
		log.debug("attaching dirty ChAddressInfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChAddressInfo instance) {
		log.debug("attaching clean ChAddressInfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChAddressInfo persistentInstance) {
		log.debug("deleting ChAddressInfo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChAddressInfo merge(ChAddressInfo detachedInstance) {
		log.debug("merging ChAddressInfo instance");
		try {
			ChAddressInfo result = (ChAddressInfo) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChAddressInfo findById(java.math.BigDecimal id) {
		log.debug("getting ChAddressInfo instance with id: " + id);
		try {
			ChAddressInfo instance = (ChAddressInfo) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.ChAddressInfo", id);
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

	public List<ChAddressInfo> findByExample(ChAddressInfo instance) {
		log.debug("finding ChAddressInfo instance by example");
		try {
			List<ChAddressInfo> results = (List<ChAddressInfo>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.ChAddressInfo").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
