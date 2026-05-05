package cl.duoc.carrito.service;

import cl.duoc.carrito.model.ItemCarrito;
import cl.duoc.carrito.repository.ItemCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemCarritoService {

    @Autowired
    private ItemCarritoRepository repository;

    
    public ItemCarrito guardarItem(ItemCarrito item) {
        return repository.save(item);
    }

    public List<ItemCarrito> obtenerTodos() {
        return repository.findAll();
    }

    public void eliminarItem(Long id) {
        repository.deleteById(id);
    }
}