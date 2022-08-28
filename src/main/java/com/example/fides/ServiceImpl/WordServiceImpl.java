package com.example.fides.ServiceImpl;

import com.example.fides.Entity.Word;
import com.example.fides.Repository.WordRepository;
import com.example.fides.Service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordRepository wordRepository;
    @Override
    public String getWord() {
        String pythonFile = "C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\main.py";
        String pythonProgramm = "C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\python-3.10.5-embed-amd64\\python.exe";

        ProcessBuilder processBuilder = new ProcessBuilder(pythonProgramm, pythonFile);
        Process process = null;

        String s = null;
        StringBuilder sb = new StringBuilder();
        try {
            process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((s = reader.readLine()) != null) {
                sb.append(s);

            }

            Word word = new Word();
            word.setWord(sb.toString());
            wordRepository.save(word);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
