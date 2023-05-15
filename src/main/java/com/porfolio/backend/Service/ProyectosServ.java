package com.porfolio.backend.Service;

import com.porfolio.backend.Entity.Proyectos;
import com.porfolio.backend.Repository.ProyectosRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosServ {

    @Autowired
    ProyectosRepo proyectosR;

    public List<Proyectos> list() {
        return proyectosR.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return proyectosR.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre) {
        return proyectosR.findByNombre(nombre);
    }

    public void save(Proyectos proyectos) {
        proyectosR.save(proyectos);
    }

    public void delete(int id) {
        proyectosR.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyectosR.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return proyectosR.existsByNombre(nombre);

    }
}
