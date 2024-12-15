package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.UserLoginDto;
import com.dictionaryapp.model.dto.UserRegisterDto;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDto data){

        if(!data.getPassword().equals(data.getConfirmPassword())){
            return false;
        }

        boolean isIsernameOrEmailTaken = userRepository.existsByUsernameAndEmail(data.getUsername(),data.getEmail());

        if (isIsernameOrEmailTaken){
            return false;
        }

        User mapped = modelMapper.map(data,User.class);
        mapped.setPassword(passwordEncoder.encode(mapped.getPassword()));

        userRepository.save(mapped);

        return true;
    }

    public boolean login(UserLoginDto data) {

        Optional<User> byUsername = userRepository.findByUsername(data.getUsername());

        if(byUsername.isEmpty()){
            return false;
        }

        User user = byUsername.get();

        if(!passwordEncoder.matches(data.getPassword(), user.getPassword())){
            return false;
        }

        userSession.login(user);

        return true;
    }

    public void logout() {
        userSession.logout();
    }
}
