package cl.duoc.registro.controller;

import cl.duoc.registro.model.Registro;
import cl.duoc.registro.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
@RequiredArgsConstructor
public class RegistroController {

    private final RegistroService registroService;

    @PostMapping
    public ResponseEntity<Registro> crear(@RequestBody Registro registro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registroService.crearRegistro(registro));
    }

    @GetMapping
    public ResponseEntity<List<Registro>> obtenerTodos() {
        return ResponseEntity.ok(registroService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> obtenerPorId(@PathVariable long id) {
        return ResponseEntity.ok(registroService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> actualizar(@PathVariable long id,
                                                @RequestBody Registro datosNuevos) {
        return ResponseEntity.ok(registroService.actualizarRegistro(id, datosNuevos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        registroService.eliminarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}