package org.example.dto.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.room.DtoRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoHome {
    private Integer id;
    private BigDecimal price;
    private List<DtoRoom> rooms = new ArrayList<>();
}
