package ar.edu.unlam.basica2.tp4.barHomero;

import java.util.Comparator;

public class CompararPorEdad implements Comparator <Cliente> { // para darle un criterio de ordenacion por parametro

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getEdad().compareTo(cliente2.getEdad());
	}

	
}
