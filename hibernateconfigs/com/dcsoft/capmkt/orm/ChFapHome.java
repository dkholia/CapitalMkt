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
 * Home object for domain model class ChFap.
 * @see com.dcsoft.capmkt.orm.ChFap
 * @author Hibernate Tools
 */
public class ChFapHome {

	private static final Log log = LogFactory.getLog(ChFapHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ChFap transientInstance) {
		log.debug("persisting ChFap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChFap instance) {
		log.debug("attaching dirty ChFap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChFap instance) {
		log.debug("attaching clean ChFap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChFap persistentInstance) {
		log.debug("deleting ChFap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChFap merge(ChFap detachedInstance) {
		log.debug("merging ChFap instance");
		try {
			ChFap result = (ChFap) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChFap findById(java.math.BigDecimal id) {
		log.debug("getting ChFap instance with id: " + id);
		try {
			ChFap instance = (ChFap) sessionFactory.getCurrentSession().get("com.dcsoft.capmkt.orm.ChFap", id);
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

	public List<ChFap> findByExample(ChFap instance) {
		log.debug("finding ChFap instance by example");
		try {
			List<ChFap> results = (List<ChFap>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.ChFap").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
