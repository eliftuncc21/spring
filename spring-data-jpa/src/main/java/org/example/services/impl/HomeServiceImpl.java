package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.home.HomeResponseDto;
import org.example.dto.room.RoomResponseDto;
import org.example.entities.Home;
import org.example.entities.Room;
import org.example.repository.HomeRepository;
import org.example.services.IHomeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements IHomeServices {

    private final HomeRepository homeRepository;

    @Override
    public HomeResponseDto getHomeById(Integer id) {
        Optional<Home> optional = homeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Home home = optional.get();
        HomeResponseDto homeResponseDto = new HomeResponseDto();
        BeanUtils.copyProperties(home, homeResponseDto);

        List<Room> dbRooms = optional.get().getRoom();

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for(Room room : dbRooms){
                RoomResponseDto roomResponseDto = new RoomResponseDto();
                BeanUtils.copyProperties(room, roomResponseDto);
                homeResponseDto.getRooms().add(roomResponseDto);
            }
        }
        return homeResponseDto;
    }
}
