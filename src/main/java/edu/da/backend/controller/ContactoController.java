package edu.da.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import edu.da.backend.model.Contacto;
import edu.da.backend.service.ContactoImp;

@RestController
@RequestMapping("api/Contacto")
@CrossOrigin(origins = "*")
public class ContactoController {
    @Autowired
    private ContactoImp contactoService;
    public static Contacto contacto;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContacto(@RequestBody Contacto contacto){
        contactoService.create(contacto);
    }

    @GetMapping("/all")
    public List<Contacto> getContactos(){
        return contactoService.contactos();
    }

    @GetMapping("/auto_increment_value")
    public Long auto_increment_value(){
        return contactoService.getAutoIncrementValue();
    }

    @GetMapping("/host")
    public String getHost(){
        String host = datasourceUrl.replace("jdbc:mysql://", "");
        host = host.replace(":3306/tcc", "");
        return host;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Contacto updateContacto(@RequestBody Contacto contacto){
        return contactoService.update(contacto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContacto(@PathVariable ("id") Integer id){
        contactoService.delete(id);
    }
}
