package br.univille.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.univille.model.Evento;
import br.univille.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Evento")
public class EventoController {

    @Autowired
    private EventoRepository EventoRepository;

    //Listar todos os Evento
    @GetMapping
    public List<Evento> listarTodos() {
        return EventoRepository.findAll();
    }

    //Buscar um Evento pelo ID
    @GetMapping("/{id}")
    public Evento buscarPorId(@PathVariable Long id) {
        Optional<Evento> Evento = EventoRepository.findById(id);
        return Evento.orElse(null);
    }

    //Criar um novo Evento
    @PostMapping
    public Evento criarEvento(@RequestBody Evento Evento) {
        return EventoRepository.save(Evento);
    }

    //Atualizar um Evento existente
    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Long id, @RequestBody Evento EventoAtualizado) {
        return EventoRepository.findById(id)
            .map(Evento -> {
                Evento.setnome(EventoAtualizado.getnome());
                Evento.setdata(EventoAtualizado.getdata());
                Evento.setdescricao(EventoAtualizado.getdescricao());
                Evento.sethora(EventoAtualizado.gethora());
                Evento.setvalor(EventoAtualizado.getvalor());
                Evento.setstatus(EventoAtualizado.getstatus());
                return EventoRepository.save(Evento);
            })
            .orElseGet(() -> {
                EventoAtualizado.setId(id);
                return EventoRepository.save(EventoAtualizado);
            });
    }

    //DELETE: Deletar um Evento
    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        EventoRepository.deleteById(id);
    }
}

