package br.com.ecstech.messenger.controller;


import br.com.ecstech.messenger.util.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping(Constants.HEALTHCHECK_ROUTE)
    public String healthCheck() {
        return "Hello from messenger!";
    }
}
