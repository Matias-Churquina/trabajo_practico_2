package ar.edu.unju.fi.ejercicio1.main;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	private static Scanner sc;
	private static List<Producto>  productos;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println("============================");
			System.out.println("1 - Crear un producto.");
			System.out.println("2 - Mostar productos.");
			System.out.println("3 - Modificar producto. ");
			System.out.println("4 - Salir.");
			System.out.println("============================");
			System.out.print("  Ingrese una opción: ");
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
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 9 );

	}

}
