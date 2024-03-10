package lk.ijse.entity;

import lk.ijse.dto.UserDto;
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
    private String phoneNo;

    @Column
    private String userName;

    @Column
    private String password;



    public User(NameIdentifier name, int age, String city, String eMail,String phoneNo,String username, String password) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.eMail = eMail;
        this.phoneNo=phoneNo;
        this.userName = username;
        this.password = password;
    }

    public UserDto toDto() {
        UserDto userDto=new UserDto();
        userDto.setId(this.u_Id);
        userDto.setName(this.name);
        userDto.setAge(this.age);
        userDto.setAge(this.age);
        userDto.setEMail(this.eMail);
        userDto.setPhoneNo(this.phoneNo);
        userDto.setCity(this.city);
        userDto.setUsername(this.userName);
        userDto.setPassword(this.password);

        return userDto;
    }
}
