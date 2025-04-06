package org.example.controller.impl;

import org.example.controller.IHomeController;
import org.example.dto.home.DtoHome;
import org.example.services.IHomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/home")
public class HomeController implements IHomeController {

    @Autowired
    private IHomeServices homeService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoHome getHomeById(@PathVariable(name = "id", required = true) Integer id) {
        return homeService.getHomeById(id);
    }
}
