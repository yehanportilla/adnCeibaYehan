package co.com.ceibaparqueadero.tesintegracion;

import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceibaparqueadero.YehanCeibaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YehanCeibaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.yaml")

public class TiempoControlerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	/**
	 * Test de integracion que valida metodo get de tiempo parqueadero
	 * @throws Exception
	 */
	@Test
	public void listarTiempoServicio() throws Exception {
		mvc.perform(get("/api/tiempos")
	    .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
		
	}

}
