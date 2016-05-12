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
 * Home object for domain model class BccCountry.
 * @see com.dcsoft.capmkt.orm.BccCountry
 * @author Hibernate Tools
 */
public class BccCountryHome {

	private static final Log log = LogFactory.getLog(BccCountryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BccCountry transientInstance) {
		log.debug("persisting BccCountry instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BccCountry instance) {
		log.debug("attaching dirty BccCountry instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BccCountry instance) {
		log.debug("attaching clean BccCountry instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BccCountry persistentInstance) {
		log.debug("deleting BccCountry instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BccCountry merge(BccCountry detachedInstance) {
		log.debug("merging BccCountry instance");
		try {
			BccCountry result = (BccCountry) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BccCountry findById(java.lang.String id) {
		log.debug("getting BccCountry instance with id: " + id);
		try {
			BccCountry instance = (BccCountry) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.BccCountry", id);
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

	public List<BccCountry> findByExample(BccCountry instance) {
		log.debug("finding BccCountry instance by example");
		try {
			List<BccCountry> results = (List<BccCountry>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.BccCountry").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
