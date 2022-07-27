package com.aysevarlik.userregistration.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UserEntity.findAll",
            query = "select u from UserEntity u "),
        @NamedQuery(name = "UserEntity.findById",
            query = "select u from UserEntity u where u.userId=:userId"),
        @NamedQuery(name = "UserEntity.findByName",
            query = "select u from UserEntity u where u.userName=:userName"),
        @NamedQuery(name = "UserEntity.findBySurname",
            query = "select u from UserEntity u where u.userSurname=:userSurname"),
        @NamedQuery(name = "UserEntity.findByEmail",
                query = "select u from UserEntity u where u.userEmail=:userEmail")
})
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "usersurname")
    private String userSurname;

    @Column(name = "useremail")
    private String userEmail;

    @Column(name = "userpassword")
    private String userPassword;

    public UserEntity(String userName, String userSurname, String userEmail, String userPassword){
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
