package com.example.service;

import org.springframework.stereotype.Service;
import com.example.dto.RegisterForm;
import com.example.dto.SignInForm;
import com.example.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    public UserService() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users.add(new User(1L, "james", "123456", "Lebron Hames", sf.parse("1999-9-19"), true));
            users.add(new User(2L, "kobe", "123456", "Kobe Bryant", sf.parse("1999-9-19"), false));
            users.add(new User(3L, "michael", "123456", "Michael Jordan", sf.parse("1999-9-19"), true));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(SignInForm signInForm) {
        User userLogin = null;
        for (User u : users) {
            if (u.getUsername().equals(signInForm.getUsername()) && u.getPassword().equals(signInForm.getPassword())) {
                userLogin = new User(u.getId(), u.getUsername(), u.getFullName(), null, u.getAvatar(), u.getBirthday(), u.isStatus());
            }
        }
        return userLogin;
    }

    public boolean register(RegisterForm r) {
        final User[] user = {null};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        users.forEach(u -> {
            if (!u.getUsername().equals(r.getUsername())) {
                user[0] = new User(r.getId(), r.getUsername(), r.getPassword(), r.getFullName(), r.getBirthday(), true);
            }
        });
        if (user[0] == null) {
            return false;
        }
        users.add(user[0]);
        return true;
    }
}
