package org.example.services;

import org.example.dto.home.HomeResponseDto;

public interface IHomeServices {
    HomeResponseDto getHomeById(Integer id);
}
