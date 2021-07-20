package io.github.filipebrenner.activitycalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Atividade")
public class Activity implements Comparable<Activity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String disciplina;
    private String data;


    @Override
    public int compareTo( Activity o) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate1 = LocalDate.parse(this.data,format);
        LocalDate localDate2 = LocalDate.parse(o.getData(),format);
        if(localDate1.isAfter(localDate2)) return 1;
        else return -1;
    }
}
