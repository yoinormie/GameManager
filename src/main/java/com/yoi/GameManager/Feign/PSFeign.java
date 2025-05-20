package com.yoi.GameManager.Feign;

import com.yoi.GameManager.Model.Entity.JPA.PlayStation.UserPlaystationNetwork;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PSFeign", url = "http://localhost:3050/playstation")
public interface PSFeign {
    @PostMapping("/searchuserwithan")
    UserPlaystationNetwork getUser(String username);

    @PostMapping("/searchgameswithaid")
    boolean getUserGames(String accountID);

}
