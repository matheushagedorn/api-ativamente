package br.univille.service;

import br.univille.model.Evento;
import br.univille.repository.EventoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EventoServiceTest {

    @Autowired
    private EventoService EventoService;

    @MockBean
    private EventoRepository EventoRepository;

    @Test
    public void testSalvarEvento() {
        Evento Evento = new Evento();
        Evento.setnome("c3");
        when(EventoRepository.save(any(Evento.class))).thenReturn(Evento);

        Evento savedEvento = EventoService.salvarEvento(Evento);
        assertEquals("c3", savedEvento.getnome());
    }

    @Test
    public void testBuscarPorId() {
        Evento Evento = new Evento();
        Evento.setId(1L);
        when(EventoRepository.findById(1L)).thenReturn(Optional.of(Evento));

        Optional<Evento> foundEvento = EventoService.buscarPorId(1L);
        assertEquals(true, foundEvento.isPresent());
        assertEquals(1L, foundEvento.get().getId());
    }
}

