package org.example.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.IHomeController;
import org.example.dto.home.HomeResponseDto;
import org.example.services.IHomeServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/home")
@RequiredArgsConstructor
public class HomeController implements IHomeController {

    private final IHomeServices homeService;

    @GetMapping(path = "/list/{id}")
    @Override
    public HomeResponseDto getHomeById(@PathVariable(name = "id", required = true) Integer id) {
        return homeService.getHomeById(id);
    }
}
