//package br.com.letscode.letsgoal;
//
//import br.com.letscode.letsgoal.controller.PatrocinadorController;
//import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.nio.charset.Charset;
//
//@WebMvcTest
//@AutoConfigureMockMvc
//public class PatrocinadorControllerTest {
//
//    @MockBean
//    private PatrocinadorRepository patrocinadorRepository;
//    @Autowired
//    private PatrocinadorController patrocinadorController;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void whenPostRequestToPatrocinadorSave() throws Exception {
//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//        String user = "{\n" +
//                "    \"descricao\": \" \",\n" +
//                "    \"urlLink\": \"http://ciet.com.br\",\n" +
//                "    \"imagemMarca\": \"http://ciet.com.br\",\n" +
//                "    \"nome\": \"CI&T Technogy\"\n" +
//                "}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/patrocinadores")
//                        .content(user)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(textPlainUtf8));
//    }
//}
