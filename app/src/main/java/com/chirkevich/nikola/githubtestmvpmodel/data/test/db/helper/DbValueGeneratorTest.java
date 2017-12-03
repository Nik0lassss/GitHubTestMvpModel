package com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Колян on 02.12.2017.
 */

public class DbValueGeneratorTest {

    private List<String> templateUserNames = Arrays.asList("Name1", "Name2", "Name3");
    private final Random random = new Random();

    public User generateUser() {
        User user = new User();
        user.setId(random.nextInt(100));
        user.setName(getRandomName());
        return user;
    }

    public List<User> generateUserList(int size) {
        ArrayList<User> usersArrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            usersArrayList.add(generateUser());
        }
        return usersArrayList;
    }

    private String getRandomName() {
        return templateUserNames.get(random.nextInt(2));
    }
}
