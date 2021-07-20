package io.github.filipebrenner.activitycalendar.repository;

import io.github.filipebrenner.activitycalendar.entity.Atividades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAtividade extends JpaRepository<Atividades,Long> {
}
