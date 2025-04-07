package org.example.dto.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.room.RoomResponseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HomeResponseDto {
    private Integer id;
    private BigDecimal price;
    private List<RoomResponseDto> rooms = new ArrayList<>();
}
