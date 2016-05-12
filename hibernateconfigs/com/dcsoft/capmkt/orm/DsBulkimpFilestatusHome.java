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
 * Home object for domain model class DsBulkimpFilestatus.
 * @see com.dcsoft.capmkt.orm.DsBulkimpFilestatus
 * @author Hibernate Tools
 */
public class DsBulkimpFilestatusHome {

	private static final Log log = LogFactory.getLog(DsBulkimpFilestatusHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DsBulkimpFilestatus transientInstance) {
		log.debug("persisting DsBulkimpFilestatus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DsBulkimpFilestatus instance) {
		log.debug("attaching dirty DsBulkimpFilestatus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DsBulkimpFilestatus instance) {
		log.debug("attaching clean DsBulkimpFilestatus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DsBulkimpFilestatus persistentInstance) {
		log.debug("deleting DsBulkimpFilestatus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DsBulkimpFilestatus merge(DsBulkimpFilestatus detachedInstance) {
		log.debug("merging DsBulkimpFilestatus instance");
		try {
			DsBulkimpFilestatus result = (DsBulkimpFilestatus) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DsBulkimpFilestatus findById(com.dcsoft.capmkt.orm.DsBulkimpFilestatusId id) {
		log.debug("getting DsBulkimpFilestatus instance with id: " + id);
		try {
			DsBulkimpFilestatus instance = (DsBulkimpFilestatus) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.DsBulkimpFilestatus", id);
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

	public List<DsBulkimpFilestatus> findByExample(DsBulkimpFilestatus instance) {
		log.debug("finding DsBulkimpFilestatus instance by example");
		try {
			List<DsBulkimpFilestatus> results = (List<DsBulkimpFilestatus>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.DsBulkimpFilestatus").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
