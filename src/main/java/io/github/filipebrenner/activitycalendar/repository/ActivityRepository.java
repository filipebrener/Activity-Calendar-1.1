package io.github.filipebrenner.activitycalendar.repository;

import io.github.filipebrenner.activitycalendar.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
