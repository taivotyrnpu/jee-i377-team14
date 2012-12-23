package ee.team14.dao;

import ee.team14.entity.*;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;

public class BorderDAO extends HibernateDaoSupport {

    public List<Piirivalvur> getAllPiirivalvur() {
        Query q = getSession().createQuery("from Piirivalvur");

        return (List<Piirivalvur>) q.list();
    }

    public List<AuasteTyyp> getAllAuasteTyyp() {
        Query q = getSession().createQuery("from AuasteTyyp");

        return (List<AuasteTyyp>) q.list();
    }

    public List<Auaste> getAllAuaste() {
        Query q = getSession().createQuery("from Auaste");

        return (List<Auaste>) q.list();
    }

    public List<PiirivalvurAuaste> getAllPiirivalvurAuaste() {
        Query q = getSession().createQuery("from PiirivalvurAuaste");

        return q.list();
    }

    public void saveOrUpdateEntity(Object p) {
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (p instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) p;
            if (baseEntity.getAvaja() == null) {
                baseEntity.setAvaja(user != null ? user.getUsername() : null);
                baseEntity.setAvatud(new Date());
            } else {
                baseEntity.setMuutja(user != null ? user.getUsername() : null);
                baseEntity.setMuudetud(new Date());
            }
        }
        getHibernateTemplate().saveOrUpdate(p);
    }
}
