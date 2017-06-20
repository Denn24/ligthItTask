package it.navigator.service;

import it.navigator.dao.CommentDAO;
import it.navigator.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dimas on 20.06.2017.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDAO commentDAO;

    @Override
    public void save(Comment comment){
        commentDAO.save(comment);
    }
}
