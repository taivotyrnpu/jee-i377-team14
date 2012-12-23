package ee.team14.dao;

import ee.team14.entity.*;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 12/16/12
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class BorderDAO extends HibernateDaoSupport {

    public List<Piirivalvur> getAllPiirivalvur(){
        Query q = getSession().createQuery("from Piirivalvur");

        return (List<Piirivalvur>) q.list();
    }

    public List<AuasteTyyp> getAllAuasteTyyp(){
        Query q = getSession().createQuery("from AuasteTyyp");

        return (List<AuasteTyyp>) q.list();
    }

    public List<Auaste> getAllAuaste(){
        Query q = getSession().createQuery("from Auaste");

        return (List<Auaste>) q.list();
    }

    public List<PiirivalvurAuaste> getAllPiirivalvurAuaste(){
        Query q = getSession().createQuery("from PiirivalvurAuaste");

        return  q.list();
    }

    public void saveNewPiirivalvur(Piirivalvur p){
        getHibernateTemplate().saveOrUpdate(p);
    }

    public void saveNewAuasteTyyp(AuasteTyyp a){
        getHibernateTemplate().save(a);
    }

    public void saveNewAuaste(Auaste a){
        getHibernateTemplate().save(a);
    }

    public void saveNewPiirivalvurAuaste(PiirivalvurAuaste a){
        getHibernateTemplate().save(a);
    }

    public void updatePiirivalvur(Piirivalvur p){
        getHibernateTemplate().update(p);
    }

    public void updateAuasteTyyp(AuasteTyyp p){
        getHibernateTemplate().update(p);
    }

    public void updateAuaste(Auaste p){
        getHibernateTemplate().update(p);
    }

    public void updatePiirivalvurAuaste(PiirivalvurAuaste p){
        getHibernateTemplate().update(p);
    }

    public void updateEntity(Class<? extends BaseEntity> p){
        getHibernateTemplate().update(p);
    }

    public void saveEntity(Class<? extends BaseEntity> p){
        getHibernateTemplate().save(p);
    }
}
