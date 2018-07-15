package by.dima.security;

import by.dima.dao.SpitterDAO;
import by.dima.model.entity.Spitter;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class LoginService implements UserDetailsService {

    @Autowired
    private SpitterDAO spitterDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter;

        try{
            spitter = spitterDAO.getSpitterByUsername(username);
            if (spitter == null){
                throw new UsernameNotFoundException("User not found");
            }
        } catch (HibernateException ex){
            throw new UsernameNotFoundException("User not found");
        }

        return buildUserDetailsFromSpitter(spitter);
    }

    private UserDetails buildUserDetailsFromSpitter(Spitter spitter){
        List<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
        User user = new User(spitter.getUsername(),spitter.getPassword(),authorities);

        return user;

    }
}
