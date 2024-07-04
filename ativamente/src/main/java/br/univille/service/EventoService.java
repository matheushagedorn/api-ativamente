package br.univille.service;

import br.univille.model.Evento;
import br.univille.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:5173")
public class EventoService {

    @Autowired
    private EventoRepository EventoRepository;

    public List<Evento> listarTodos() {
        return EventoRepository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return EventoRepository.findById(id);
    }

    public Evento salvarEvento(Evento Evento) {
        return EventoRepository.save(Evento);
    }

    public void deletarEvento(Long id) {
        EventoRepository.deleteById(id);
    }

    public Evento atualizarEvento(Long id, Evento EventoAtualizado) {
        return EventoRepository.findById(id).map(Evento -> {
            Evento.setNome(EventoAtualizado.getNome());
            Evento.setData(EventoAtualizado.getData());
            Evento.setDescricao(EventoAtualizado.getDescricao());
            Evento.setHora(EventoAtualizado.getHora());
            Evento.setValor(EventoAtualizado.getValor());
            Evento.setStatus(EventoAtualizado.getStatus());
            return EventoRepository.save(Evento);
        }).orElseGet(() -> {
            EventoAtualizado.setId(id);
            return EventoRepository.save(EventoAtualizado);
        });
    }
}
