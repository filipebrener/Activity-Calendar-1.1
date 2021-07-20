package io.github.filipebrenner.activitycalendar.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends Throwable {

    private final Long id;

    public ActivityNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "is not a valid id";
    }
}
