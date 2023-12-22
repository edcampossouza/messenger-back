package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.model.ApplicationUser;
import br.com.ecstech.messenger.service.ApplicationUserService;
import br.com.ecstech.messenger.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.USER_BASE_PATH)
public class ApplicationUserController {
    @Autowired
    private ApplicationUserService userService;

    @GetMapping(Constants.INFO_PATH)
    public ApplicationUser getInfo() {
        return userService.getLoggedInOrThrow();
    }
}
