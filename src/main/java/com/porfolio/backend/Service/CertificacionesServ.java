package com.porfolio.backend.Service;

import com.porfolio.backend.Entity.Certificaciones;
import com.porfolio.backend.Repository.CertificacionesRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CertificacionesServ {
    @Autowired
    CertificacionesRepo CertificacionesR;
    
  public List<Certificaciones>list(){
      return CertificacionesR.findAll();
  }  
  public Optional <Certificaciones> getOne(int id){
      return CertificacionesR.findById(id);
  }
   public Optional <Certificaciones> getByTitulo(String titulo){
       return CertificacionesR.findByTitulo(titulo);
   }
  public void save(Certificaciones certificaciones){
      CertificacionesR.save(certificaciones);
  }
  public void delete(int id){
      CertificacionesR.deleteById(id);
  }
  public boolean existsById(int id){
      return CertificacionesR.existsById(id); 
  }
  public boolean existsByTitulo(String titulo){
      return CertificacionesR.existsByTitulo(titulo);
      
  }
}
