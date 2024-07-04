package br.univille.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.univille.model.Evento;
import br.univille.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Evento buscarPorId(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElse(null);
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        System.out.println("Recebendo dados para criação de evento:");
        System.out.println("Nome: " + evento.getnome());
        System.out.println("Local: " + evento.getlocal());
        System.out.println("Data: " + evento.getData());
        System.out.println("Hora: " + evento.gethora());
        System.out.println("Descrição: " + evento.getdescricao());
        System.out.println("Valor: " + evento.getvalor());
        System.out.println("Status: " + evento.getstatus());
        
        return eventoRepository.save(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
        System.out.println("Recebendo dados para atualização de evento:");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + eventoAtualizado.getnome());
        System.out.println("Local: " + eventoAtualizado.getlocal());
        System.out.println("Data: " + eventoAtualizado.getData());
        System.out.println("Hora: " + eventoAtualizado.gethora());
        System.out.println("Descrição: " + eventoAtualizado.getdescricao());
        System.out.println("Valor: " + eventoAtualizado.getvalor());
        System.out.println("Status: " + eventoAtualizado.getstatus());

        return eventoRepository.findById(id)
            .map(evento -> {
                evento.setnome(eventoAtualizado.getnome());
                evento.setlocal(eventoAtualizado.getlocal());
                evento.setData(eventoAtualizado.getData());
                evento.setdescricao(eventoAtualizado.getdescricao());
                evento.sethora(eventoAtualizado.gethora());
                evento.setvalor(eventoAtualizado.getvalor());
                evento.setstatus(eventoAtualizado.getstatus());
                return eventoRepository.save(evento);
            })
            .orElseGet(() -> {
                eventoAtualizado.setId(id);
                return eventoRepository.save(eventoAtualizado);
            });
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }
}
