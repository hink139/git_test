package com.example.fides.Service;

import com.example.fides.DTO.ApiResponse;
import com.example.fides.Entity.File.FileEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface FileService {

    List<FileEntity> getSum(int number1, int number2) throws IOException;
    List<FileEntity> getTotal() throws IOException;
    public ApiResponse uploadFile(MultipartFile file) throws IOException;
    public ApiResponse updateFile ();
    public ApiResponse getAll ();
    public ApiResponse getFileById ();

}
