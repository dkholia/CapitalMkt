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
 * Home object for domain model class AdtAdtDtlTbl.
 * @see com.dcsoft.capmkt.orm.AdtAdtDtlTbl
 * @author Hibernate Tools
 */
public class AdtAdtDtlTblHome {

	private static final Log log = LogFactory.getLog(AdtAdtDtlTblHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(AdtAdtDtlTbl transientInstance) {
		log.debug("persisting AdtAdtDtlTbl instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AdtAdtDtlTbl instance) {
		log.debug("attaching dirty AdtAdtDtlTbl instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdtAdtDtlTbl instance) {
		log.debug("attaching clean AdtAdtDtlTbl instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AdtAdtDtlTbl persistentInstance) {
		log.debug("deleting AdtAdtDtlTbl instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdtAdtDtlTbl merge(AdtAdtDtlTbl detachedInstance) {
		log.debug("merging AdtAdtDtlTbl instance");
		try {
			AdtAdtDtlTbl result = (AdtAdtDtlTbl) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AdtAdtDtlTbl findById(com.dcsoft.capmkt.orm.AdtAdtDtlTblId id) {
		log.debug("getting AdtAdtDtlTbl instance with id: " + id);
		try {
			AdtAdtDtlTbl instance = (AdtAdtDtlTbl) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.AdtAdtDtlTbl", id);
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

	public List<AdtAdtDtlTbl> findByExample(AdtAdtDtlTbl instance) {
		log.debug("finding AdtAdtDtlTbl instance by example");
		try {
			List<AdtAdtDtlTbl> results = (List<AdtAdtDtlTbl>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.AdtAdtDtlTbl").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
