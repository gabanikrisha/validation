package com.example.validation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService
{
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Krisha Gabani", new Date()));
        users.add(new User(2, "Nupul Kukadiya", new Date()));
        users.add(new User(3, "Java Developer", new Date()));
    }

    // find all
    public List<User> findAll() {
        return users;
    }

    // save user
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    // find by id
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // delete by id
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
