package io.github.filipebrenner.activitycalendar.resource;

import io.github.filipebrenner.activitycalendar.entity.Activity;
import io.github.filipebrenner.activitycalendar.exeptions.ActivityNotFoundException;
import io.github.filipebrenner.activitycalendar.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@Api(value = "Activity Calendar API REST")
public class ActivityResource {

    ActivityService service;

    @GetMapping
    @ApiOperation(value = "Lista todas as atividades em ordem de acontecimento")
    public ResponseEntity<Stream<Activity>> findAllInOrder(){
        return ResponseEntity.ok(service.findAllInOrder());
    }

    @PostMapping
    @ApiOperation(value = "Salva uma atividade")
    public ResponseEntity<Activity> postActivity(@RequestBody Activity atividade){
        service.save(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista apennas uma atividade")
    public ResponseEntity<Activity> getById(@PathVariable("id") Long id) throws ActivityNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma atividade")
    public ResponseEntity deleteActivity(@PathVariable("id") Long id) throws ActivityNotFoundException {
        service.delete(service.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma atividade")
    public ResponseEntity<Activity> updateAtividade(@RequestBody Activity activity) throws ActivityNotFoundException {
        return ResponseEntity.ok(service.update(activity));
    }

}
