package co.com.ceibaparqueadero.tesintegracion;

import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YehanCeibaApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")

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
	
	 @Test
	 public void guardarTiempoServicio() throws ParqueaderoExcepcion{ 
	 try {	 
	 this.mvc.perform(post("/api/tiempos")
	 .characterEncoding("utf-8")
	 .content("{\"id\":3,\"nombre\":\"Minutos\"}")
	 .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk());
	 }catch(Exception e) {
		 throw new ParqueaderoExcepcion("Dato no registrado");
	 }	 
	 }

}
