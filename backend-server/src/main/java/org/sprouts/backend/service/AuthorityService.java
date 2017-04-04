package org.sprouts.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sprouts.backend.security.UserDetailsService;
import org.sprouts.model.Authority;

import java.util.ArrayList;
import java.util.List;


@Service("authorityService")
public class AuthorityService {

    // Managed Data Access Objects --------------------------------------------

    // Simple CRUD Methods ----------------------------------------------------

    // Auxiliary methods -----------------------------------------------------

    public Authority findByPrincipal() {
        UserDetails userDetails = UserDetailsService.getPrincipal();
        Assert.notNull(userDetails);
        List<Authority> authorities = new ArrayList(userDetails.getAuthorities());
        Authority res = null;
        if (authorities.size() > 0) {
            res = authorities.get(0);
        }
        return res;
    }

}