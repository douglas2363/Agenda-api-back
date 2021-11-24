package io.github.douglas2363.agenda.api.rest;

import io.github.douglas2363.agenda.model.entity.Contato;
import io.github.douglas2363.agenda.model.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContatoController {

    private final ContatoRepository contatoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato save(@RequestBody Contato contato){
        return contatoRepository.save(contato);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        contatoRepository.deleteById(id);
    }

    @GetMapping
    public List<Contato> list(@PathVariable Integer id){
        return contatoRepository.findAll();
    }


    @PatchMapping("{id}/favorito")
    public void favorite(@PathVariable Integer id, @RequestBody Boolean favorito){
            Optional<Contato> contato = contatoRepository.findById(id);
            contato.ifPresent( c -> {
                c.setFavorito(favorito);
                contatoRepository.save(c);
            });
    }
}
