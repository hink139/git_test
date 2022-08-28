package com.example.fides.Controller;


import com.example.fides.Repository.WordRepository;
import com.example.fides.ServiceImpl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    @Autowired
    WordRepository wordRepository;
    @Autowired
    WordServiceImpl wordService;

    @GetMapping("/getWord")
    public String getAll(){
        return wordService.getWord();
    }
}
