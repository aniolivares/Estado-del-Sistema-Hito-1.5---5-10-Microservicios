package cl.duoc.favoritos.service;

import cl.duoc.favoritos.model.Favorito;
import cl.duoc.favoritos.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository repository;

    public Favorito guardarFavorito(Favorito favorito) {
        return repository.save(favorito);
    }

    public List<Favorito> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Favorito obtenerPorId(Long id) {
        return repository.findById(id).orElse(null); 
    }

    public void eliminarFavorito(Long id) {
        repository.deleteById(id);
    }
}