package com.softwears.Softwear.Users;

import org.springframework.web.bind.annotation.GetMapping;

public class ProfileController {
/* this will link to the actaul profile page of the user. If the user is an employee,
 they will have the same features as a customer e.g updating credentials viewing purchase history(maybe) but they will have additional features.
 Like a simple product manager where an employee can add, remove, or update a product  */
 @GetMapping("/profile")
    public String showLoginPage() {
        return "testingProfile"; /*this is for testing validation */
    }
}
