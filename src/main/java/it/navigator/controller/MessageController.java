package it.navigator.controller;

import it.navigator.dao.CommentDAO;
import it.navigator.entity.Comment;
import it.navigator.entity.Message;
import it.navigator.service.MessageService;
import it.navigator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    CommentDAO commentDAO;

    @RequestMapping("")
    public String getMessages(Model model) {
        model.addAttribute("messages", messageService.findMessagesOrderByDateAsc());
        return "message";
    }

    @RequestMapping( value = "/create", method = RequestMethod.POST)
    public String saveMessage(String messageText, Authentication authentication){
        messageService.save(new Message(messageText, userService.findUserByLogin(authentication.getName())));
        return "redirect:/message";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String saveComment(String commentMessage,Long messageId, @AuthenticationPrincipal User user){
        commentDAO.save(new Comment(commentMessage, userService.findUserByLogin(user.getUsername()), messageService.findById(messageId)));
        return "redirect:/message";
    }
}
