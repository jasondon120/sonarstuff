package com.dm_daddy.first_edition.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('PLAYER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> Player Contents!";
    }

    @GetMapping("/api/test/dm")
    @PreAuthorize("hasRole('DM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Dungeon Master Board";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }
}
