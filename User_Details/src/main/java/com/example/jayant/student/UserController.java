package com.example.jayant.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

  @RestController
    @RequestMapping("/userdetails")
    public class UserController {

        private final UserService userservice;

        @Autowired
        public UserController(UserService userservice) {
            this.userservice = userservice;
        }

        @GetMapping
        public List<User> getUser()
        {
            System.out.println(userservice.getUser());
            return userservice.getUser();

        }

            @PostMapping("/save")
        public User registerNewUser(@RequestBody User user)
        {

            userservice.addNewUser(user);
            return user;
        }

        @DeleteMapping(path="{userid}")
        public int deleteUser(@PathVariable ("userid") int userid)
        {
            userservice.deleteUser(userid);
            return userid;


        }
        //    @PutMapping(path="{studentid}")
//    public void updateStudent(@PathVariable ("studentid") Long studentid , @RequestParam(required = false) String name ,
//                              @RequestParam(required = false) String email)
//    {
//        studentservice.updateStudent(studentid,name,email);
//    }
        @PostMapping("/post")
        public User updateUser(@RequestBody User user)
        {
            userservice.updateUser(user);
            return user;
        }

    }


