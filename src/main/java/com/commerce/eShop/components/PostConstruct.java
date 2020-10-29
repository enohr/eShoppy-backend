package com.commerce.eShop.components;

import com.commerce.eShop.model.Role;
import com.commerce.eShop.repository.RoleRepository;
import com.commerce.eShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class PostConstruct  {

    @Autowired
    private UserRepository user;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    @Transactional
    public ApplicationRunner dataInitializer() {
        return args -> {
            createRole("USER_ROLE");
            createRole("SELLER_ROLE");
            createRole("ADMIN_ROLE");
            System.out.println("Entrou");
        };
    }

    @Transactional
    public void createRole(String roleName) {
        Role r = roleRepository.findByName(roleName).orElse(null);
        System.out.println(r);
        if (r == null) {
            r = new Role(roleName);
            roleRepository.save(r);
        }
    }
}
