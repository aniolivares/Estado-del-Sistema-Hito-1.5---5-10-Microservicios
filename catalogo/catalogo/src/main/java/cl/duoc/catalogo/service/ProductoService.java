package cl.duoc.catalogo.service;

import cl.duoc.catalogo.model.Producto;
import cl.duoc.catalogo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto); // Guarda y actualiza en BD
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll(); // Lista todos
    }
    
    public void eliminarProducto(Long id) {
        repository.deleteById(id); // Elimina de la BD por su ID
    }
}