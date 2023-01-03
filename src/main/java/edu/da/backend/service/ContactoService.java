package edu.da.backend.service;

import java.util.List;
import java.util.Optional;

import edu.da.backend.model.Contacto;

public interface ContactoService {
    public Contacto create(Contacto contacto);
    public Optional<Contacto> getcontacto(Integer id);
    public List<Contacto> contactos();
    public Contacto update(Contacto contacto);
    public void delete(Integer id);
    public Long getAutoIncrementValue();
}
