package co.com.ceibaparqueadero.tesintegracion;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YehanCeibaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.yaml")

public class SalidaParqueaderoControlerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	 @Test
	 public void guardarRegistroSalidaError() throws ParqueaderoExcepcion{ 
	 try {	 
	 this.mvc.perform(patch("/api/registro/COO123")
	 .characterEncoding("utf-8")
	 .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().is4xxClientError());
	 }catch(Exception e) {
		 throw new ParqueaderoExcepcion("Placa no registrada");
	 }	 
	 }
	

}
