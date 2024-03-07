package lk.ijse.entity;

import lk.ijse.embeded.NameIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_Id")
    private long u_Id;

    @Column
    private NameIdentifier name;

    @Column
    private int age;

    @Column
    private String city;

    @Column
    private String eMail;

    @Column
    private String userName;

    @Column
    private String password;

    public User(NameIdentifier name, int age, String city, String eMail, String username, String password) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.eMail = eMail;
        this.userName = username;
        this.password = password;
    }

}
