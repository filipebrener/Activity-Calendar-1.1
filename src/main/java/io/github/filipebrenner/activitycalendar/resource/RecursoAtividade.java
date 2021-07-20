package io.github.filipebrenner.activitycalendar.resource;

import io.github.filipebrenner.activitycalendar.entity.Atividades;
import io.github.filipebrenner.activitycalendar.exeptions.AtividadeNotFoundExeption;
import io.github.filipebrenner.activitycalendar.service.ServicoAtividade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
@AllArgsConstructor
public class RecursoAtividade {

    ServicoAtividade service;

    @GetMapping
    public ResponseEntity<List<Atividades>> findAllInOrder(){
        return ResponseEntity.ok(service.findAllInOrder());
    }

    @PostMapping
    public ResponseEntity<Atividades> postAtividade(@RequestBody Atividades atividades){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(atividades));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAtividade(@PathVariable("id") Long id) throws AtividadeNotFoundExeption {
        service.delete(service.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Atividades> updateAtividade(@RequestBody Atividades atividades) throws AtividadeNotFoundExeption {
        return ResponseEntity.ok(service.update(atividades));
    }

}
