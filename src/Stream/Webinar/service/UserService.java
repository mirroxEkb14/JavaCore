package Stream.Webinar.service;

import Stream.Webinar.model.User;
import Stream.Webinar.util.Validator;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class UserService {

    // user storage
    private List<User> users = new ArrayList<>();

    // create some users
    {
        users.add(new User("Antonia", "Gomez", LocalDate.now().minusYears(31))); // LocalDate.now().minusYears(31) -> 1990-06-01
        users.add(new User("Luis", "Martin", LocalDate.now().minusYears(27)));
        users.add((new User("Maria", "Sanchez", LocalDate.now().minusYears(21))));
        users.add(new User("Francisco", "Perez", LocalDate.now().minusYears(10)));
        users.add(new User("Carlos", "Martinez", LocalDate.now().minusYears(17)));
    }

    // get all added users
    public List<User> getUsers() {
        return users;
    }

    // empty optional if id is more than list size,
    // user otherwise
    public Optional<User> getUserById(long id) {
        if (id > users.size())
            return Optional.empty();
        else
            return Optional.of(users.get((int) id));
    }

    // take one user by some sign
    public Optional<User> getReducedUsers(BinaryOperator<User> binaryOperator) {
        return users.stream()
                .reduce(binaryOperator);
    }

    // sort by passed comparator
    public List<User> getSortedUsers(Comparator<User> comparator) {
        return users.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // users over 18
    public List<User> getValidUsers(Validator validator) {
        return users.stream()
                .filter(validator::validate)
                .collect(Collectors.toList());

        // non-functional style
//        List<User> validUsers = new ArrayList<>();
//        for (User user: users) {
//            if (validator.validate(user)) validUsers.add(user);
//        }
//        return validUsers;
    }
}
