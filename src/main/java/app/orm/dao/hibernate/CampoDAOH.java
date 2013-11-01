package app.orm.dao.hibernate;

import app.orm.dao.BaseHibernateDAO;
import app.orm.dao.CampoDAO;
import app.orm.model.Campo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("campoDAO")
public class CampoDAOH extends BaseHibernateDAO implements CampoDAO {

    public List<Campo> list() {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        return criteria.list();

    }

    public Campo get(Campo t) {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Campo) criteria.uniqueResult();
    }

    @Transactional
    public void save(Campo t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Campo t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(Campo t) {
        this.getSession().delete(t);
    }

}
