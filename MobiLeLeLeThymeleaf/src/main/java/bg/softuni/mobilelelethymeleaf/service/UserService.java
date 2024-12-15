package bg.softuni.mobilelelethymeleaf.service;

import bg.softuni.mobilelelethymeleaf.model.UserLoginDTO;
import bg.softuni.mobilelelethymeleaf.model.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistration);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
