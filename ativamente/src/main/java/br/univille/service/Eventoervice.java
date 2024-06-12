package br.univille.service;

import br.univille.model.Evento;
import br.univille.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Eventoervice {

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
            Evento.setnome(EventoAtualizado.getnome());
            Evento.setdata(EventoAtualizado.getdata());
            Evento.setdescricao(EventoAtualizado.getdescricao());
            Evento.sethora(EventoAtualizado.gethora());
            Evento.setvalor(EventoAtualizado.getvalor());
            Evento.setstatus(EventoAtualizado.getstatus());
            return EventoRepository.save(Evento);
        }).orElseGet(() -> {
            EventoAtualizado.setId(id);
            return EventoRepository.save(EventoAtualizado);
        });
    }
}
