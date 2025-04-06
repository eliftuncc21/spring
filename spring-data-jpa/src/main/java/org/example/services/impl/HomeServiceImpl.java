package org.example.services.impl;

import org.example.dto.home.DtoHome;
import org.example.dto.room.DtoRoom;
import org.example.entities.Home;
import org.example.entities.Room;
import org.example.repository.HomeRepository;
import org.example.services.IHomeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeServices {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome getHomeById(Integer id) {
        Optional<Home> optional = homeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Home home = optional.get();
        DtoHome dtoHome = new DtoHome();
        BeanUtils.copyProperties(home,dtoHome);

        List<Room> dbRooms = optional.get().getRoom();

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for(Room room : dbRooms){
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room,dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;
    }
}
