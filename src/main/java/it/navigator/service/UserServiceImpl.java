package it.navigator.service;

import it.navigator.dao.RoleDAO;
import it.navigator.dao.UserDAO;
import it.navigator.entity.Role;
import it.navigator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;
    @Autowired
    RoleDAO roleDAO;


    @Override
    public User findUserByLogin(String login){
        return dao.findByLogin(login);
    }

    @Override
    public User findUserById(Long id){
        return dao.findById(id);
    }

    @Override
    public void registerUser(User newUser){
        User user = null;
        try{
         user = dao.findByLogin(newUser.getLogin());
         if(user != null)
             throw new RuntimeException("Login alredy exist");
        } catch (NoResultException e){
            List<Role> roles = new ArrayList<>();
            roles.add(roleDAO.findByName("ROLE_USER"));
            newUser.setRoles(roles);
            dao.save(newUser);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        try {
             user = dao.findByLogin(login);
        } catch (NoResultException e){
            throw new UsernameNotFoundException("Authentification Error: user not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role: user.getRoles())
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(), true, true, true, true, grantedAuthorities);
        return userDetails;
    }
}
