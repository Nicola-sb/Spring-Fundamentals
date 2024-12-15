package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class WordsService {

    private LanguageRepository languageRepository;
    private UserRepository userRepository;
    private UserSession userSession;

    public WordsService(LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void add(AddWordDto data){

    }
}
