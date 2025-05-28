package com.yoi.GameManager.Feign;

import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.EnvolvedLists;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.PlayStationGameDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.PlayStationRequest.PSGamesRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.PlayStationRequest.PSUserRequestDTO;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.UserPlaystationNetwork;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PSFeign", url = "http://localhost:3050/playstation")
public interface PSFeign {
    @PostMapping("/searchuserwithan")
    UserPlaystationNetwork getUser(@RequestBody PSUserRequestDTO requestDTO);

    @PostMapping("/searchgameswithaid")
    EnvolvedLists getUserGames(PSGamesRequestDTO requestDTO);

}
