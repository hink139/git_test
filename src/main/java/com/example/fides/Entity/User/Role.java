package com.example.fides.Entity.User;
import com.example.fides.Entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    @Column(unique = true)
    private String name;

}
