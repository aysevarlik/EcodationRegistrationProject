package com.aysevarlik.userregistration.rest.restImpl;


import com.aysevarlik.userregistration.data.entity.UserEntity;
import com.aysevarlik.userregistration.data.repository.IUserRepository;
import com.aysevarlik.userregistration.rest.IRestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")

public class UserRestController implements IRestImpl {

    @Autowired
    IUserRepository repo;

    //http://localhost:8080/api/v1/users
    @Override
    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        repo.save(userEntity);
        return userEntity;
    }

    //http://localhost:8080/api/v1/users
    @Override
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> list = repo.findAll();
        return list;
    }

    //http://localhost:8080/api/v1/users/{id}
    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Long id) {
        UserEntity entity = repo.findById(id).orElseThrow(()->new ResourceNotFoundException(id+" id bulunamadı"));
        return ResponseEntity.ok(entity);
    }

    //http://localhost:8080/api/v1/users/{id}
    @Override
    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable(name = "id") Long id,@RequestBody UserEntity userEntity) {
        UserEntity find = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("id bulunamadı"));
        find.setUserName(userEntity.getUserName());
        find.setUserSurname(userEntity.getUserSurname());
        find.setUserEmail(userEntity.getUserEmail());
        find.setUserPassword(userEntity.getUserPassword());
        repo.save(find);
        return ResponseEntity.ok(find);
    }

    //http://localhost:8080/api/v1/users/{id}
    @Override
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable(name = "id") Long id) {
        UserEntity entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("id bulunamadı."));
        repo.delete(entity);
        Map<String,Boolean> response=new HashMap<>();
        response.put("silindi?",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
