package com.porfolio.backend.Controller;

import com.porfolio.backend.Dto.DtoProyectos;
import com.porfolio.backend.Entity.Proyectos;
import com.porfolio.backend.Security.Controller.Mensaje;
import com.porfolio.backend.Service.ProyectosServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
//@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectosControlller {

    @Autowired
    ProyectosServ proyectosS;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosS.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        }       
        Proyectos proyectos = proyectosS.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
      
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproyec) {
        if (StringUtils.isBlank(dtoproyec.getNombre()))
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
     
        if (proyectosS.existsByNombre(dtoproyec.getNombre())) 
            return new ResponseEntity(new Mensaje("nombre ya existe"), HttpStatus.BAD_REQUEST);
        

        Proyectos proyectos = new Proyectos(
                dtoproyec.getNombre(),
                dtoproyec.getDescripcion(),
                dtoproyec.getImg(),
                dtoproyec.getUrl());
        
        proyectosS.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecyo creado con exito"), HttpStatus.OK);

    }
   
       @PutMapping("/editar/{id}")
    public ResponseEntity<?> Update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproyec) {
        if (!proyectosS.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        if (proyectosS.existsByNombre(dtoproyec.getNombre()) && proyectosS.getByNombre(dtoproyec.getNombre()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoproyec.getNombre())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = proyectosS.getOne(id).get();
        proyectos.setNombre(dtoproyec.getNombre());
        proyectos.setDescripcion(dtoproyec.getDescripcion());
        proyectos.setImg(dtoproyec.getImg());
                
            proyectosS.save(proyectos);
             return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }             
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> Delete(@PathVariable("id") int id) {
        if (!proyectosS.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        proyectosS.delete(id);
        
             return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
             
    }   


} 



