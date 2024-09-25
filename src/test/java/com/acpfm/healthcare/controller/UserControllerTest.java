package com.acpfm.healthcare.controller;

import com.acpfm.healthcare.model.User;
import com.acpfm.healthcare.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

    public UserControllerTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListUser(){
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userService.getAllUsers()).thenReturn(users);

        String viewName = userController.listUsers(model);

        verify(userService,times(1)).getAllUsers();
        verify(model,times(1)).addAttribute("users",users);
        assertEquals("users",viewName);
    }

    @Test
    void testRegisterUser(){
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userService.getAllUsers()).thenReturn(users);

        String viewName = userController.registerUser(user,model);

        verify(userService,times(1)).registerUser(user);
        verify(model,times(1)).addAttribute("users",users);
        assertEquals("fragments/user-list :: userList", viewName);
    }

    @Test
    void testSearchUsers(){

        String username = "HPotter";
        List<User> users = new ArrayList<>();
        users.add(new User());

        when(userService.searchUsers(username)).thenReturn(users);

        String viewName = userController.searchUsers(username,model);

        verify(userService, times(1)).searchUsers(username);
        verify(model,times(1)).addAttribute("users",users);
        assertEquals("fragments/user-list :: userList", viewName);
    }
}
