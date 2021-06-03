package Stream.Webinar;

import Stream.Webinar.service.UserService;
import Stream.Webinar.util.Validator;

import java.time.Period;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();

        // we cannot access default methods: Validator.isAdult();
        // 'isAdult()' method needs to be static
//        Validator validator = new Validator() {
//            @Override
//            public boolean validate(User user) {
//                return isAdult(user.getBirthday());
//            }
//        };

        // over 18
        // if 'isAdult()' method is static
        Validator validator = user -> Validator.isAdult(user.getBirthday());

        System.out.println(userService.getValidUsers(validator));

        System.out.println("=======================");

        // User{id=1, name='Luis', surname='Martin', birthday=1994-06-02}
        userService.getUserById(1)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No users with such id"));

        System.out.println("=======================");

        // sort by birthday date (from more to less)
        System.out.println(userService.getSortedUsers((user1, user2) -> Period.between(user1.getBirthday(), user2.getBirthday()).getYears()));

        System.out.println("=======================");

        // take the oldest user
        // for getting the youngest -> ... > 0 ? user2 : user1
        System.out.println(userService.getReducedUsers( // Optional[User{id=0, name='Antonia', surname='Gomez', birthday=1990-06-02}]
                (user1, user2) -> Period.between(user1.getBirthday(), user2.getBirthday()).getYears() > 0 ? user1 : user2));
    }


}
