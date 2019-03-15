package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.Dm_Users;
import com.dm_daddy.first_edition.Repositories.dmUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RepositoryRestController
@CrossOrigin
public class DmUsersController {
    @Autowired
    private dmUsersRepository repo;

    @GetMapping("/user")
//    @CrossOrigin(origins = "http://localhost:4200")
    public List<Dm_Users> users(){
        List<Dm_Users> userList = (List<Dm_Users>) repo.findAll();
        return userList;
    }
}
