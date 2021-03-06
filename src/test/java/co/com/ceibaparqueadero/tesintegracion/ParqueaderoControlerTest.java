package co.com.ceibaparqueadero.tesintegracion;

import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceibaparqueadero.YehanCeibaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YehanCeibaApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class ParqueaderoControlerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * Test de integracion que valida metodo get de estado de registro
	 * 
	 * @throws Exception
	 */
	@Test
	public void listarRegistroAutomotor() throws Exception {
		mvc.perform(get("/api/registros").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is2xxSuccessful());

	}
	
     /**
      * Test de integracion que valida metodo post guardar registro
      * @throws Exception
      */
	@Test
	public void guardarRegistroServicio() throws Exception {

		this.mvc.perform(post("/api/registros").characterEncoding("utf-8")
				.content("{\"placa\":\"CCD123\",\"cilindraje\":500,\"claseAutomotorEntidad\":{\"id\":2},\"estadoEntidad\":{\"id\":1}}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print()).andExpect(status().isOk());

	}
	
	
    /**
     * Test de integracion que valida metodo post fallida
     * @throws Exception
     */
	@Test
	public void guardarRegistroServicioError() throws Exception {

		this.mvc.perform(post("/api/registros").characterEncoding("utf-8")
				.content("{\"placa\":\"ACD123\",\"cilindraje\":0,\"claseAutomotorEntidad\":{\"id\":2},\"estadoEntidad\":{\"id\":1}}")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print()).andExpect(status().is4xxClientError());

	}
	
	

}
