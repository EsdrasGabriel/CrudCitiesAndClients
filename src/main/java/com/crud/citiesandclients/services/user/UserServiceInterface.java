package com.crud.citiesandclients.services.user;

import com.crud.citiesandclients.domain.user.AuthDTO;
import com.crud.citiesandclients.domain.user.RegisterDTO;

public interface UserServiceInterface {
    String login(AuthDTO data);
    void register(RegisterDTO data);
}
