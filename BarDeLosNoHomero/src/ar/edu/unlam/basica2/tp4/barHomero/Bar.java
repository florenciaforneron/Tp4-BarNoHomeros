package ar.edu.unlam.basica2.tp4.barHomero;


import java.util.TreeSet;

public class Bar{
	
	 private TreeSet<Cliente> miSetDeClientes = new TreeSet<Cliente>();
	 private Boolean estadoDelBar = false;
	
	 public void agregarCliente(Cliente cliente){
		if(miSetDeClientes.contains(cliente)){
			try {
				throw new Exception("No puede ingresar un cliente con el mismo nombre");
				}catch(Exception e){
				this.miSetDeClientes.remove(cliente);
				this.miSetDeClientes.add(cliente);
				e.printStackTrace();
				System.out.println(e.getMessage());
				} 
		}else {
			miSetDeClientes.add(cliente);
		}
	 }
		public void estaAbierto(){
			this.estadoDelBar = true;
		}
		
		public void estaCerrado()throws Exception{
			if(miSetDeClientes.isEmpty()){
				this.estadoDelBar= false;
				
			}else{
				this.estadoDelBar= true;
				throw new Exception("No se puede cerrar con clientes adentro");
			}
		}
		
		public void mostrarCliente(){
			System.out.println(miSetDeClientes);
		}
	

	
	public Boolean getEstadoDelBar() {
		return estadoDelBar;
	}
	public void setEstadoDelBar(Boolean estadoDelBar) {
		this.estadoDelBar = estadoDelBar;
	}
	public TreeSet<Cliente> getMiSetDeClientes() {
		return miSetDeClientes;
	}
	public void setMiSetDeClientes(TreeSet<Cliente> miSetDeClientes) {
		this.miSetDeClientes = miSetDeClientes;
	}
	
	


	
	
	
	

	
}
