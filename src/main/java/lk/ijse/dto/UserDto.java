package lk.ijse.dto;

import lk.ijse.embeded.NameIdentifier;
import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto implements Serializable {
    private long id;
    private NameIdentifier name;
    private int age;
    private String city;
    private String eMail;
    private String phoneNo;
    private String username;
    private String password;

    public UserDto(NameIdentifier name, int age, String city, String eMail,String phoneNo, String username, String password) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.eMail = eMail;
        this.phoneNo=phoneNo;
        this.username = username;
        this.password = password;

    }

    public User toEntity(){
        User user = new User();
        user.setU_Id(this.id);
        user.setName(this.name);
        user.setAge(this.age);
        user.setCity(this.city);
        user.setEMail(this.eMail);
        user.setPhoneNo(this.phoneNo);
        user.setUserName(this.username);
        user.setPassword(this.password);
        return user;
    }
}
