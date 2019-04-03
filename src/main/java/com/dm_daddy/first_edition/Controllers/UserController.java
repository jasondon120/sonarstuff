package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.User;
import com.dm_daddy.first_edition.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RepositoryRestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository repo;

    //---- Search Users ------
    //-----------------------
    @GetMapping("/users")
    public List<User> searchUser(@RequestParam String searchCriteria) {
        List<User> users = repo.findUserByUsername(searchCriteria);
        return users;

    }
}
