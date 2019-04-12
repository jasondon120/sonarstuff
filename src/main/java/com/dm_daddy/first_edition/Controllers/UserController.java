package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.User;
import com.dm_daddy.first_edition.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/user/{name}")
    public Long findUserId(@PathVariable String name) {
        Optional<User> userId = repo.findByUsername(name);
        Long uid = userId.get().getId();
        return uid;
    }
}
