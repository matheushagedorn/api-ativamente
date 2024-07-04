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
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Local: " + evento.getLocal());
        System.out.println("Data: " + evento.getData());
        System.out.println("Hora: " + evento.getHora());
        System.out.println("Descrição: " + evento.getDescricao());
        System.out.println("Valor: " + evento.getValor());
        System.out.println("Status: " + evento.getStatus());
        
        return eventoRepository.save(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
        System.out.println("Recebendo dados para atualização de evento:");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + eventoAtualizado.getNome());
        System.out.println("Local: " + eventoAtualizado.getLocal());
        System.out.println("Data: " + eventoAtualizado.getData());
        System.out.println("Hora: " + eventoAtualizado.getHora());
        System.out.println("Descrição: " + eventoAtualizado.getDescricao());
        System.out.println("Valor: " + eventoAtualizado.getValor());
        System.out.println("Status: " + eventoAtualizado.getStatus());

        return eventoRepository.findById(id)
            .map(evento -> {
                evento.setNome(eventoAtualizado.getNome());
                evento.setLocal(eventoAtualizado.getLocal());
                evento.setData(eventoAtualizado.getData());
                evento.setDescricao(eventoAtualizado.getDescricao());
                evento.setHora(eventoAtualizado.getHora());
                evento.setValor(eventoAtualizado.getValor());
                evento.setStatus(eventoAtualizado.getStatus());
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
