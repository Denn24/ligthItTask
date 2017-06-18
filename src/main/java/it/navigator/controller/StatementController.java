package it.navigator.controller;

import it.navigator.entity.Statement;
import it.navigator.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Dimas on 11.05.2017.
 */
@Controller
@RequestMapping("/statement")
public class StatementController {
    @Autowired
    private StatementService statementService;

    @RequestMapping("/get")
    @ResponseBody
    public List<Statement> getStatements(){
        return statementService.getStatementList();
    }
}
