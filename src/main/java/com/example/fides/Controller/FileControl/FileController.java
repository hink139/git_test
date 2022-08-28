package com.example.fides.Controller.FileControl;
import com.example.fides.DTO.ApiResponse;
import com.example.fides.Entity.File.FileEntity;
import com.example.fides.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;





@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/calculateSum/{number1}/{number2}")
    public List<FileEntity> getFile(@PathVariable int number1, @PathVariable int number2) throws IOException {
        return fileService.getSum(number1,number2);
    }

    @GetMapping("/getTotal")
    public List<FileEntity> getNumbersTotal() throws IOException {
        return fileService.getTotal();
    }

}
