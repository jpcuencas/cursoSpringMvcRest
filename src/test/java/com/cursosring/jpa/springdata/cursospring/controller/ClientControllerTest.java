package com.cursosring.jpa.springdata.cursospring.controller;

import com.cursosring.jpa.springdata.cursospring.managers.impl.ClientManager;
import com.cursosring.jpa.springdata.cursospring.repositories.IClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ClientControllerTest {
    
    @InjectMocks
    private ClientController clientController;
    
    @Mock
    private ClientManager clientManager;
    
    @Mock
    private ModelMapper mockModelMapper;
    
    private MockMvc mockMvc;
    
    private ObjectMapper mapper;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientManager).build();
        this.mapper = new ObjectMapper();
    }
    @Test
    public void testVistaClientes() throws Exception {
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(view().name("clientes"))
                .andExpect(content().string(containsString("clientes")));
    }
}
