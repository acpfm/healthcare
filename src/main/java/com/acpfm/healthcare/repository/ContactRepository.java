package com.acpfm.healthcare.repository;

import com.acpfm.healthcare.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findByNumUtente(Integer numUtente);
}
