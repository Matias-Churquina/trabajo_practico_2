package ar.edu.unju.fi.ejercicio2.main;

import java.util.List;
import java.util.Scanner;

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
		     		
		     		break;
		     	case 2:
		     		
	     			break;
		     	case 3:
		     		
	     			break;
		     	case 4:
		     		
	     			break;
		     	case 5:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 4 );
		

	}

}
