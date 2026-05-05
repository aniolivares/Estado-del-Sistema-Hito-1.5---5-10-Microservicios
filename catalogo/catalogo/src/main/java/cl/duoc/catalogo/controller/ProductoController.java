package cl.duoc.catalogo.controller;

import cl.duoc.catalogo.model.Producto;
import cl.duoc.catalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto nuevo = service.guardarProducto(producto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        return new ResponseEntity<>(service.obtenerTodos(), HttpStatus.OK); 
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> editar(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id); 
        
        Producto actualizado = service.guardarProducto(producto);
        
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminarProducto(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}