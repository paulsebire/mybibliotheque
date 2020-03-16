package com.bibliotheque.microservicemyclient.proxies;

import com.bibliotheque.microservicemyclient.bean.UtilisateurBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@FeignClient(name = "microservice-myusers")
@RibbonClient(name = "microservice-myusers")
public interface IMicroserviceMyUsersProxy {

    @GetMapping("/{pseudo}/connexion")
    UtilisateurBean connexionUtilisateur(@PathVariable String pseudo);

    @GetMapping("/connexion/{id}")
    Optional<UtilisateurBean> findById(Long id);
}
