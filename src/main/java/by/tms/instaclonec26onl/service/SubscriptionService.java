package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.SubscriberDAO;

import java.util.List;

public class SubscriptionService {

    private final SubscriberDAO daoSub = new SubscriberDAO();

    public void addSubscribeUser(User fol, User sub) {
        daoSub.addUserSub(fol, sub);
    }

    public void unSubUser (User fol, User sub) {
        daoSub.unSubUser(fol, sub);
    }

    public List<User> findSubUser (long id) {
        return daoSub.findSubUser(id);
    }

    public List<User> findFollowerUser (long id) {
        return daoSub.findFollowerUser(id);
    }

}
