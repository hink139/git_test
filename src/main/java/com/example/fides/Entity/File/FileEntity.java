package com.example.fides.Entity.File;

import com.example.fides.Entity.BaseEntity;
import com.example.fides.Entity.User.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class FileEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private Long Id;

    private String fileName;

    private String filePath;

    @ManyToOne
    private  User user;
}
