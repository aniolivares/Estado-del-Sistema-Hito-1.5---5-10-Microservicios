package cl.duoc.notificaciones.controller;

import cl.duoc.notificaciones.model.Notificacion;
import cl.duoc.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository repository;

    @PostMapping("/crear")
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nuevaNotificacion = repository.save(notificacion);
        return new ResponseEntity<>(nuevaNotificacion, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Notificacion>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        List<Notificacion> notificaciones = repository.findByUsuarioId(usuarioId);
        return new ResponseEntity<>(notificaciones, HttpStatus.OK);
    }

    @PutMapping("/marcar-leida/{id}")
    public ResponseEntity<Notificacion> marcarComoLeida(@PathVariable Long id) {
        Optional<Notificacion> notificacionExistente = repository.findById(id);
        
        if (notificacionExistente.isPresent()) {
            Notificacion notificacion = notificacionExistente.get();
            notificacion.setLeida(true);
            repository.save(notificacion);
            return new ResponseEntity<>(notificacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}