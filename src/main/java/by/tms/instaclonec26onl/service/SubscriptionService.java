package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;
import by.tms.instaclonec26onl.storage.InMemorySubStorage;

public class SubscriptionService {

    private final InMemorySubStorage inMemorySubStorage = new InMemorySubStorage();

    public void subscribeByUser (User sub) {
        inMemorySubStorage.subscribeByIdUser(sub);
    }

    public void addSubscribeByUser (User user) {
        inMemorySubStorage.addUserSub(user);
    }

}
