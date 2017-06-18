package it.navigator.dao;

import it.navigator.entity.Statement;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dimas on 11.05.2017.
 */
@Repository
public class StatementDAOImpl extends GenericDAOImpl<Statement> implements StatementDAO {

    @Override
    public List<Statement> getStatementList(){
        Session session = sessionFactory.getCurrentSession();
        return (List<Statement>) session.createQuery("select s from Statement s left join s.marks mark where ((select (sum(m.value)/count(m)) from Mark m where m.statement.id = s.id) > (select (avg(m.value)) from Mark m)) group by s order by avg (mark.value)").list();
    }
}
