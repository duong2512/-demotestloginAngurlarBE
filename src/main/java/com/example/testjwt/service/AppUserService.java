package com.example.testjwt.service;

import com.example.testjwt.model.AppUser;
import com.example.testjwt.repo.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        return iAppUserRepo.findAppUsersByUserName(username);
    }

    public AppUser findByEmail(String mail){
        return iAppUserRepo.findAppUsersByEmail(mail);
    }

    public AppUser save(AppUser appUser){
        if(checkDuplicateUsername(appUser.getUserName())&&checkDuplicateEmail(appUser.getEmail())){
            System.out.println(false);
            return null;
        } else {
            System.out.println(true);
            return iAppUserRepo.save(appUser);
        }

    }


    public boolean checkDuplicateUsername(String username){
        AppUser user = findByUserName(username);
        if (user == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkDuplicateEmail(String email){
        AppUser user = findByEmail(email);
        if (user == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findAppUsersByUserName(username);

        return new User(appUser.getUserName(),appUser.getPassWord(),appUser.getRoles());
    }
}
