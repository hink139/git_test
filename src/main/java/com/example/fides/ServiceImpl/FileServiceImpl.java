package com.example.fides.ServiceImpl;

import com.example.fides.DTO.ApiResponse;
import com.example.fides.Entity.File.FileEntity;
import com.example.fides.Repository.FileRepository;
import com.example.fides.Service.FileService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileRepository fileRepository;

    @Override

    public List<FileEntity> getSum(int number1, int number2) throws IOException {
        String pythonFile = "C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\addition.py";
        String pythonProgramm  = "C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\python-3.10.5-embed-amd64\\python.exe";



        ProcessBuilder pb = new ProcessBuilder(pythonFile,pythonProgramm, "" + number1, "" + number2);
        Process p = pb.start();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

        System.out.println(".........start   process.........");
        String line = "";
        while ((line = bfr.readLine()) != null) {
//            System.out.println("Python Output: " + line);
            System.out.println(line);
            //python code finished

            //create file under
            String filePath = "C:\\Users\\Windows 10\\IdeaProjects\\Files";

            File directory = new File(filePath);
            directory.mkdir();

            String fileName = generateFileName();
            File file = new File(directory, fileName + ".csv");
            file.createNewFile();
            byte[] bytes = line.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFilePath(filePath);
            fileEntity.setFileName(fileName);
            fileRepository.save(fileEntity);
        }
        return fileRepository.findAll();
    }

    @Override
    public List<FileEntity> getTotal() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\python-3.10.5-embed-amd64\\python.exe",
                "C:\\Users\\Windows 10\\PycharmProjects\\pythonProject\\numbers.py");
        Process p = pb.start();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

        System.out.println(".........start   process.........");
        String line = "";
        while ((line = bfr.readLine()) != null) {
//            System.out.println("Python Output: " + line);
            System.out.println(line);
            //python code finished


            //create file under
            String filePath = "C:\\Users\\Windows 10\\IdeaProjects\\Files";

            File directory = new File(filePath);
            directory.mkdirs();

            String fileName = generateFileName();
            File file = new File(directory, fileName + ".csv");
            file.createNewFile();
            byte[] bytes = line.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFilePath(filePath);
            fileEntity.setFileName(fileName);
            fileRepository.save(fileEntity);
        }
        return fileRepository.findAll();
    }

    @Override
    public ApiResponse uploadFile(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheet("nameFile");
        return null;
    }
    @Override
    public ApiResponse updateFile() {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return null;
    }

    @Override
    public ApiResponse getFileById() {
        return null;
    }


    public static String generateFileName() {
        return UUID.randomUUID().toString();
    }


}