package cl.duoc.favoritos.controller;

import cl.duoc.favoritos.model.Favorito;
import cl.duoc.favoritos.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService service;

    @PostMapping("/agregar")
    public ResponseEntity<Favorito> agregar(@RequestBody Favorito favorito) {
        return new ResponseEntity<>(service.guardarFavorito(favorito), HttpStatus.CREATED); // 201 Created
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Favorito>> listarPorUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(service.obtenerPorUsuario(id), HttpStatus.OK); // 200 OK
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<Favorito> editar(@PathVariable Long id, @RequestBody Favorito favoritoRecibido) {
        
        
        Favorito favoritoExistente = service.obtenerPorId(id);
        
        if (favoritoExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        favoritoExistente.setUsuarioId(favoritoRecibido.getUsuarioId());
        favoritoExistente.setProductoId(favoritoRecibido.getProductoId());
        
        Favorito actualizado = service.guardarFavorito(favoritoExistente);
        
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarFavorito(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}