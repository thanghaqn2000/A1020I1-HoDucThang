package vn.codegym.sercutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.bean.Role;
//import vn.codegym.model.bean.User;
import vn.codegym.repository.UserRepo;
import vn.codegym.repository.UserRoleRepo;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        vn.codegym.model.bean.User user = this.userRepo.findByUserName(userName);


        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found user:! " + userName);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        Set<Role> roles = user.getRoles();
//        for (Role role : roles) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//            grantedAuthorities.add(authority);
//            }
//
//        return new User(user.getUserName(), user.getPassword(), grantedAuthorities);

        return new MyUserDetails(user);
    }

}
