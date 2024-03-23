package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemorySubStorage;

import java.util.List;

public class SubscriptionService {

    private final InMemorySubStorage inMemorySubStorage = new InMemorySubStorage();

    public void addSubscribeUser(User fol, User sub) {
        inMemorySubStorage.addUserSub(fol, sub);
    }

    public void unSubUser (User fol, User sub) {
        inMemorySubStorage.unSubUser(fol, sub);
    }

    public List<User> findSubUser (long id) {
        return inMemorySubStorage.findSubUser(id);
    }

    public List<User> findFollowerUser (long id) {
        return inMemorySubStorage.findFollowerUser(id);
    }

}
