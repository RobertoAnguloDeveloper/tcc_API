package edu.da.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.da.backend.model.Contacto;
import edu.da.backend.repository.ContactoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactoImp implements ContactoService{
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    @Transactional
    public Contacto create(Contacto contacto) {
        if (contacto.getId() == null){
            return contactoRepository.save(contacto);
        }else{
            Optional<Contacto> contactoNew = getcontacto(contacto.getId());
            if (contactoNew.isEmpty()){
                return contactoRepository.save(contacto);
            }else {
                return contacto;
            }
        }
    }

    @Override
    public Optional<Contacto> getcontacto(Integer id) {
        return contactoRepository.findById(id);
    }

    @Override
    public List<Contacto> contactos() {
        return (List<Contacto>) contactoRepository.findAll();
    }

    @Override
    public Contacto update(Contacto contacto) {
        if (contacto != null && contacto.getId() != null){
            if (contactoRepository.existsById(contacto.getId())){
                Optional<Contacto> oldcontacto = contactoRepository.findById(contacto.getId());
                Contacto editedcontacto = oldcontacto.get();

                if (contacto.getImagen() != null){
                    editedcontacto.setImagen(contacto.getImagen());
                }
                if (contacto.getNombres() != null){
                    editedcontacto.setNombres(contacto.getNombres());
                }
                if (contacto.getApellidos() != null){
                    editedcontacto.setApellidos(contacto.getApellidos());
                }
                if (contacto.getTelefono() != null){
                    editedcontacto.setTelefono(contacto.getTelefono());
                }
                if (contacto.getEmail() != null){
                    editedcontacto.setEmail(contacto.getEmail());
                }
                if (contacto.getDomicilio() != null){
                    editedcontacto.setDomicilio(contacto.getDomicilio());
                }
                
                return contactoRepository.save(editedcontacto);
            }else{
                return contacto;
            }
        }else {
            return contacto;
        }
    }

    @Override
    public void delete(Integer id) {
        if(contactoRepository.existsById(id)){
            contactoRepository.deleteById(id);
        }
    }

    @Override
    public Long getAutoIncrementValue() {
        return contactoRepository.getAutoIncrementValue();
    }
}
