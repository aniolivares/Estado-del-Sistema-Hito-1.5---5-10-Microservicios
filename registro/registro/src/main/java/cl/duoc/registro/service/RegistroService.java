package cl.duoc.registro.service;

import cl.duoc.registro.model.Registro;
import cl.duoc.registro.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final RegistroRepository registroRepository;

    public Registro crearRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public List<Registro> obtenerTodos() {
        return registroRepository.findAll();
    }

    public Registro obtenerPorId(Long id) {
        return registroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
    }

    public Registro actualizarRegistro(Long id, Registro datosNuevos) {
        Registro existente = registroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
        existente.setNombre(datosNuevos.getNombre());
        existente.setEmail(datosNuevos.getEmail());
        existente.setPassword(datosNuevos.getPassword());
        existente.setRol(datosNuevos.getRol());
        return registroRepository.save(existente);
    }

    public void eliminarRegistro(Long id) {
        if (!registroRepository.existsById(id)) {
            throw new RuntimeException("Registro no encontrado con ID: " + id);
        }
        registroRepository.deleteById(id);
    }
}