package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.service.ApplicationUserService;
import br.com.ecstech.messenger.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.ADMIN_BASE_PATH)
public class AdminUserController {

    @Autowired
    private ApplicationUserService userService;
    @GetMapping(Constants.ADMINS_PATH)
    public List<ApplicationUser> getAdmins(){
        return  userService.getAdminUsers();
    }

}
