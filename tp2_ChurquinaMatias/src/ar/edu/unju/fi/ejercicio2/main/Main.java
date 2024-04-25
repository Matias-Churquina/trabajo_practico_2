package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner sc;
	private static List<Efemeride> efemerides;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println();
			System.out.println("========= EFEMÉRIDES ========");
			System.out.println("1 - Crear una efeméride.");
			System.out.println("2 - Mostar efemérides.");
			System.out.println("3 - Eliminar efeméride. ");
			System.out.println("4 - Modificar efeméride. ");
			System.out.println("5 - Salir.");
			System.out.print("  Ingrese una opción: ");
			System.out.println();
			System.out.println("============================");
			op = sc.nextInt();
			sc.nextLine();
		    switch (op) {
		     	case 1:
		     		crearEfemeride();
		     		break;
		     	case 2:
		     		mostrarEfemeride();
	     			break;
		     	case 3:
		     		elimnarEfemeride();
	     			break;
		     	case 4:
		     		modificarEfem();
	     			break;
		     	case 5:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 4 );
		

	}
	/**
	 * Propósito: Muestra al usuario un serie de meses que debe elegir para
	 * asiganarlo a la nueva efeméride o modificada.
	 * 
	 */
	public static Mes selecMes() {
		while(true) {
			try {
				System.out.println("    Elija el mes de la efeméride   ");
				System.out.println("1 - Enero    5 - Mayo    9 - Septiembre ");
				System.out.println("2 - Febrero  6 - Junio   10- Octubre ");
				System.out.println("3 - Marzo    7 - Julio   11- Noviembre ");
				System.out.println("4 - Abril    8 - Agostp  12- Diciembre ");;
				System.out.print("  Ingrese una opción: ");
				System.out.println();
				System.out.println("=================================");
				Mes[] valMes = Mes.values();
				Mes mes = valMes[sc.nextInt()-1];
				return mes;
			}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo al mes.");
			}
		}
	}
	/**
	 * Propósito: Crea un objeto Efemeride y lo agrega a un array 'efemerides'.
	 * 
	 */
	public static void crearEfemeride() {
		if(efemerides == null) {
			efemerides = new ArrayList<>();
		}
		Efemeride ef = new Efemeride();
		System.out.println("===== Nueva Efeméride =====");
		ef.setMes(selecMes());
		while(true) {
			try {
				System.out.print("Ingrese código de la efeméride: ");
				ef.setCodigo(sc.nextInt());
				break;
			}catch(Exception e) {
				System.out.println("ERROR. El código está compuesto solo por números.");
				sc.nextLine();
			}
		}	
		System.out.print("Ingrese dia: ");
		ef.setDia(sc.nextInt()); //verificar el buffer
		sc.nextLine();
		System.out.print("Ingrese detalle: ");
		ef.setDetalle(sc.nextLine());
	    efemerides.add(ef);
	    System.out.println("Efemeride creada y agregada correctamente.");
	    System.out.println();
	}
	/**
	 * Propósito: Muestra de manera iterativa cada uno de los objetos Efemeride
	 * agregados al array 'efemerides'.
	 */
	public static void mostrarEfemeride() {
		if(efemerides != null) {
			System.out.println("===== Efemérides =====");
			efemerides.forEach(e->System.out.println(e));
		}else {
			System.out.println("ERROR. La lista está vacía.");
		}
	}
	/**
	 * Propósito: Elimina un objeto Efemeride de acuerdo a el código ingresado
	 * por el usuario por consola.
	 * 
	 */
	public static void elimnarEfemeride() {
		boolean band = false;
		System.out.println("- Ingrese código de efeméride a eliminar: ");
		int cod = sc.nextInt();
		Iterator<Efemeride> iterator = efemerides.iterator();
		while(iterator.hasNext()) {
			Efemeride ef = iterator.next();
			if(ef.getCodigo() == cod){
				iterator.remove();
				System.out.println("Efeméride eliminada correctamente.");
				band = true;
			}
		}
		if(band != true) {
			System.out.println("ERROR. Código ingresado incorrecto.");;
		}
	}
	/**
	 * Propósito: De acuerdo a un código ingresado por el usuario por consola
	 * se busca y modifica una efeméride.
	 * 
	 */
	public static void modificarEfem() {
		boolean band = false;
		System.out.println("===== Modificar Efeméride =====");
		System.out.println("- Ingrese código de efeméride a modificar: ");
		int cod = sc.nextInt();
		Iterator<Efemeride> iterator = efemerides.iterator();
		while(iterator.hasNext()) {
			Efemeride ef = iterator.next();
			if(ef.getCodigo() == cod){
				ef.setMes(selecMes());
				System.out.print("Ingrese nuevo dia: ");
				ef.setDia(sc.nextInt()); 
				sc.nextLine();
				System.out.print("Ingrese nuevo detalle: ");
				ef.setDetalle(sc.nextLine());
			    efemerides.add(ef);
			    System.out.println("Efemeride modificada correctamente.");
			    System.out.println();
			    band = true;
			}
		}
		if(band != true) {
			System.out.println("ERROR. Código ingresado incorrecto.");;
		}
	}
}
