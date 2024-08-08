package com.petshow.petshow.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshow.petshow.exception.UserAlreadyExistsException;
import com.petshow.petshow.service.UserRegisterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.petshow.petshow.modules.UserRegisterEntityStub.userRegisterEntity;
import static com.petshow.petshow.modules.UserRegisterRequestStub.userRegisterRequest;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegisterControllerTest {

    private final String URI = "/petshow/v1/userRegister/create";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRegisterService userRegisterService;
    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    final class Create {

//        @Test
        @DisplayName("Deve executar POST de criar usuário com sucesso")
        void test01() throws Exception {
            // ASSETS
            var request = userRegisterRequest();
            var entity = userRegisterEntity();
            when(userRegisterService.create(request))
                    .thenReturn(entity);
            // ACTION
            // ASSERTIONS
            mockMvc.perform(post(URI)
                    .contentType("application/json")
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk());
        }

//        @Test
        @DisplayName("Deve executar POST de criar usuário com erro, quando usuário já existente")
        void test02() throws Exception {
            // ASSETS
            var request = userRegisterRequest();
//            doThrow(new UserAlreadyExistsException("Usuário já cadastrado: " + request.getUsername()))
//                    .when(userRegisterService.create(request));
            when(userRegisterService.create(request))
                    .thenThrow(new UserAlreadyExistsException("Usuário já cadastrado: " + request.getEmail()));
            // ACTION
            // ASSERTIONS
            mockMvc.perform(post(URI)
                            .contentType("application/json")
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

    }

}