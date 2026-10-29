package com.example.demo.service;

import com.example.demo.model.Contacto;
import com.example.demo.repository.ContactoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactoService {
    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAll();
    }

    @Transactional
    public Contacto guardar(Contacto contacto) {
        if (contacto.getLeido() == null) contacto.setLeido(false);
        return contactoRepository.save(contacto);
    }
}
