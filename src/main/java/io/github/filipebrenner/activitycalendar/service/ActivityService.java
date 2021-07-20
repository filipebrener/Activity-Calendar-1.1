package io.github.filipebrenner.activitycalendar.service;

import io.github.filipebrenner.activitycalendar.entity.Activity;
import io.github.filipebrenner.activitycalendar.exeptions.ActivityNotFoundException;
import io.github.filipebrenner.activitycalendar.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ActivityService {

    ActivityRepository activityRepository;

    public Stream<Activity> findAllInOrder() {
        return activityRepository.findAll().stream().sorted();
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity findById(Long id) throws ActivityNotFoundException {
        Optional<Activity> optional = activityRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        else throw new ActivityNotFoundException(id);
    }

    public void delete(Activity activity) throws ActivityNotFoundException {
        try {
        activityRepository.delete(activity);
        } catch (IllegalArgumentException e){
            throw new ActivityNotFoundException(activity.getId());
        }
    }

    public Activity update(Activity activity) throws ActivityNotFoundException {
        Optional<Activity> optional = activityRepository.findById(activity.getId());
        if(optional.isPresent()) return activityRepository.save(activity);
        else throw new ActivityNotFoundException(activity.getId());
    }
}
