package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import java.util.List;

public class EnvolvedLists {

    private List<PlayStationGameDTO> userGames;
    private List<PlayStationPropertyDTO> userPropertyGames;

    public EnvolvedLists(List<PlayStationGameDTO> userGames, List<PlayStationPropertyDTO> userPropertyGames) {
        this.userGames = userGames;
        this.userPropertyGames = userPropertyGames;
    }

    public List<PlayStationGameDTO> getUserGames() {
        return userGames;
    }

    public List<PlayStationPropertyDTO> getUserPropertyGames() {
        return userPropertyGames;
    }
}
