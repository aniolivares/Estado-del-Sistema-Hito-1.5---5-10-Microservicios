package cl.duoc.carrito.controller;

import cl.duoc.carrito.model.ItemCarrito;
import cl.duoc.carrito.service.ItemCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService service;

    @PostMapping("/crear")
    public ResponseEntity<ItemCarrito> crear(@RequestBody ItemCarrito item) {
        ItemCarrito nuevo = service.guardarItem(item);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED); // 201 Created
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ItemCarrito>> listar() {
        return new ResponseEntity<>(service.obtenerTodos(), HttpStatus.OK); // 200 OK
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ItemCarrito> editar(@PathVariable Long id, @RequestBody ItemCarrito item) {
        item.setId(id);
        ItemCarrito actualizado = service.guardarItem(item);
        return new ResponseEntity<>(actualizado, HttpStatus.OK); // 200 OK
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}