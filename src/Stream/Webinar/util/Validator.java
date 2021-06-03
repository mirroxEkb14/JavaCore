package Stream.Webinar.util;

import Stream.Webinar.model.User;

import java.time.LocalDate;
import java.time.Period;

@FunctionalInterface
public interface Validator {

    boolean validate(User user);

    // users over 18
    static boolean isAdult(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears() >= 18;
    }
}
