package org.example.controller;

import org.example.dto.home.HomeResponseDto;

public interface IHomeController {
    HomeResponseDto getHomeById(Integer id);
}
