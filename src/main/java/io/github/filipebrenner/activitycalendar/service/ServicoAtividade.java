package io.github.filipebrenner.activitycalendar.service;

import io.github.filipebrenner.activitycalendar.entity.Atividades;
import io.github.filipebrenner.activitycalendar.exeptions.AtividadeNotFoundExeption;
import io.github.filipebrenner.activitycalendar.repository.RepositorioAtividade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicoAtividade {

    RepositorioAtividade repositorioAtividade;

    public List<Atividades> findAllInOrder() {
        return repositorioAtividade.findAll();
    }

    public Atividades save(Atividades atividades) {
        return repositorioAtividade.save(atividades);
    }

    public Atividades findById(Long id) throws AtividadeNotFoundExeption {
        Optional<Atividades> optional = repositorioAtividade.findById(id);
        if(optional.isPresent()) return optional.get();
        else throw new AtividadeNotFoundExeption(id);
    }

    public void delete(Atividades atividades) throws AtividadeNotFoundExeption {
        try {
        repositorioAtividade.delete(atividades);
        } catch (IllegalArgumentException e){
            throw new AtividadeNotFoundExeption(atividades.getId());
        }
    }

    public Atividades update(Atividades atividades) throws AtividadeNotFoundExeption {
        Optional<Atividades> optional = repositorioAtividade.findById(atividades.getId());
        if(optional.isPresent()) return repositorioAtividade.save(atividades);
        else throw new AtividadeNotFoundExeption(atividades.getId());
    }
}
