package ar.edu.unlam.basica2.tp4.barHomero;

import java.util.TreeSet;
import org.junit.Assert;
import org.junit.Test;

public class TestBarDeLosNoHomeros {

	
	
	@Test
	public void queUnBarSeCreeVacio(){
		
		Bar miBar = new Bar();
		
		Integer esperado = 0;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void verCuantosClientesHayEnElBar(){
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Mel");
		cliente1.setEdad(23);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Flor");
		cliente2.setEdad(24);
		
		miBar.agregarCliente(cliente1);;
		miBar.agregarCliente(cliente2);;
		
		
		Integer esperado = 2;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		
		Assert.assertEquals(esperado, obtenido);
		
	}
	
	@Test
	public void testQueNoSeAgregenNombresDuplicados(){
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Florchus");
		cliente1.setEdad(12);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Florchus");
		cliente2.setEdad(13);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Mel");
		cliente3.setEdad(13);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.mostrarCliente();
		
		Integer esperado = 2;
		Integer obtenido = miBar.getMiSetDeClientes().size();
		
		Assert.assertEquals(esperado,obtenido);
		
		
		
	}
	
	@Test
	public void queLosClientesSePresentenAlfabeticamente(){
		
		Bar miBar = new Bar();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Mel");
		cliente1.setEdad(23);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Flor");
		cliente2.setEdad(24);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Ana");
		cliente3.setEdad(20);
		
		Cliente cliente4 = new Cliente();
		cliente4.setNombre("Claudia");
		cliente4.setEdad(30);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		miBar.agregarCliente(cliente3);
		miBar.agregarCliente(cliente4);
		
		miBar.mostrarCliente(); 
		
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getNombre().equals("Ana"));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getNombre().equals("Mel"));
	
		
	}
	
	
	@Test
	public void queSePuedanCompararUnClienteQueEsteDentroDelBarConUnoQueEsteAfuera(){
		
		Bar miBar = new Bar ();
		Cliente miCliente = new Cliente();
		miCliente.setNombre("Mel");
		miCliente.setEdad(23);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Mel");
		cliente1.setEdad(23);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Mel");
		cliente3.setEdad(23);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente3);
		
		Assert.assertTrue(miCliente.equals(cliente1));
		Assert.assertEquals(1,miBar.getMiSetDeClientes().size());
	}
	
	@Test
	public void testQueSePuedanCompararPorEdad(){
		Bar miBar = new Bar();
		CompararPorEdad comparador = new CompararPorEdad();
		
		miBar.setMiSetDeClientes(new TreeSet<Cliente>(comparador));
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Dario");
		cliente1.setEdad(35);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Maty");
		cliente2.setEdad(29);
		
		miBar.agregarCliente(cliente1);
		miBar.agregarCliente(cliente2);
		
		miBar.mostrarCliente();
		
		Assert.assertTrue(miBar.getMiSetDeClientes().first().getEdad().equals(29));
		Assert.assertTrue(miBar.getMiSetDeClientes().last().getEdad().equals(35));
	}
	
	@Test (expected = Exception.class)
	public void queElBarNoSeCierreConClientesAdentro() throws Exception{
		Bar miBar = new Bar();
		Cliente miCliente = new Cliente();
		
	
		miCliente.setNombre("Mel");
		miCliente.setEdad(36);
		
		miBar.agregarCliente(miCliente);
		
		miBar.estaCerrado();
		
		Assert.assertFalse(miBar.getEstadoDelBar());
		
	}
	
	@Test
	public void queSeAbraElBar(){
		
		Bar miBar = new Bar();
		
		miBar.estaAbierto();
		
		Assert.assertTrue(miBar.getEstadoDelBar());
	}
	
	
	
}
