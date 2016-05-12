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
 * Home object for domain model class ChUserGroupMapping.
 * @see com.dcsoft.capmkt.orm.ChUserGroupMapping
 * @author Hibernate Tools
 */
public class ChUserGroupMappingHome {

	private static final Log log = LogFactory.getLog(ChUserGroupMappingHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ChUserGroupMapping transientInstance) {
		log.debug("persisting ChUserGroupMapping instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChUserGroupMapping instance) {
		log.debug("attaching dirty ChUserGroupMapping instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChUserGroupMapping instance) {
		log.debug("attaching clean ChUserGroupMapping instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChUserGroupMapping persistentInstance) {
		log.debug("deleting ChUserGroupMapping instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChUserGroupMapping merge(ChUserGroupMapping detachedInstance) {
		log.debug("merging ChUserGroupMapping instance");
		try {
			ChUserGroupMapping result = (ChUserGroupMapping) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChUserGroupMapping findById(com.dcsoft.capmkt.orm.ChUserGroupMappingId id) {
		log.debug("getting ChUserGroupMapping instance with id: " + id);
		try {
			ChUserGroupMapping instance = (ChUserGroupMapping) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.ChUserGroupMapping", id);
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

	public List<ChUserGroupMapping> findByExample(ChUserGroupMapping instance) {
		log.debug("finding ChUserGroupMapping instance by example");
		try {
			List<ChUserGroupMapping> results = (List<ChUserGroupMapping>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.ChUserGroupMapping").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
