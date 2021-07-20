package io.github.filipebrenner.activitycalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividades")
public class Atividades{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private Integer numero;
    private String disciplina;
    private String data;


   //@SneakyThrows
   //@Override
   //public int compareTo(Atividades o) {
   //    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
   //    return 0;
   //}
}
