package dmitriy.tsoy.russia.authServiceTraining.repo;

import dmitriy.tsoy.russia.authServiceTraining.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepo {

    private List<User> users;

    public UserRepo() {
        this.users = Arrays.asList(
                new User("anton", "user1"),
                new User("ivan", "user2"));
    }

    public User findByUsernameAndPassword(String username, String password) {
        return this.users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .filter(user -> password.equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAll() {
        return this.users;
    }

    public User findByUsername(String username) {
        return this.users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst()
                .orElse(null);
    }
}
