package med.voll.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AppointmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Should get 400 http code when informations are invalid")
    @WithMockUser
    void make_appointmentScenario1() throws Exception {
        var response = mvc.perform(post("/appointments"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(400);
    }
}
