package edu.da.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.da.backend.model.Contacto;

public interface ContactoRepository extends CrudRepository<Contacto,Integer> {
    @Query(value = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'tcc' AND TABLE_NAME = 'contactos';", nativeQuery = true)
    Long getAutoIncrementValue();
}
