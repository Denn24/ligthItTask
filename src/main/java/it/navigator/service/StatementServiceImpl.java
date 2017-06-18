package it.navigator.service;

import it.navigator.dao.StatementDAO;
import it.navigator.entity.Mark;
import it.navigator.entity.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dimas on 11.05.2017.
 */
@Service
@Transactional
public class StatementServiceImpl implements StatementService {
    @Autowired
    private StatementDAO statementDAO;
    @Override
    public List<Statement> getStatementList(){
        return statementDAO.getStatementList();
    }
}
