package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] prov = Provincia.values();
		for(int i = 0; i<6 ; i++) {
			System.out.println();
			System.out.println(" Provincia: " + prov[i].name());
			System.out.println(" Cantidad de población: " + prov[i].getCantPoblacion());
			System.out.println(" Superficie: " + prov[i].getSuperficie());
			System.out.println(" Densidad de población: " + prov[i].densidadPob()
					+ " hab/km²");
		}
		

	}

}
