package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testSaveUser(){
        //Cria um novo utilizador
        User user = new User();
        user.setNum_mecanog(1324);
        user.setEmail("rweasley@email.com");
        user.setUsername("rweasley");
        user.setPassword("hogwartsforever");
        user.setNum_cedula(5768);
        user.setStatus(1);
        user.setId_perfil(1);
        //Salvar o utente
        User savedUser = userService.registerUser(user);

        //Confere se o ID foi gerado e os dados salvos
        assertNotNull(savedUser.getId());
        assertEquals(1324,savedUser.getNum_mecanog());
        assertEquals(5768,savedUser.getNum_cedula());
        assertEquals("rweasley@email.com",savedUser.getEmail());
        assertEquals("rweasley",savedUser.getUsername());
        assertEquals(1,savedUser.getStatus());
        assertEquals(1,savedUser.getId_perfil());
    }
}
