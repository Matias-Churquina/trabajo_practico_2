package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFab;

public class Main {
	private static Scanner sc;
	private static List<Producto> productos;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		precargaProducto();
		int op = 0;
		do {
			System.out.println();
			System.out.println("========= COMPRAS ========");
			System.out.println("1 - Mostrar productos.");
			System.out.println("2 - Mostrar procustos faltantes.");
			System.out.println("3 - Incrementar los precios de los productos en 20%.");
			System.out.println("4 - Mostar productos de Electrohogar y tengan stock.");
			System.out.println("5 - Ordenar productos por precios en forma descendente.");
			System.out.println("6 - Mostar productos con los nombres en mayúsculas.");
			System.out.println("7 - Salir.");
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
		
		     		break;
		     	case 6:
		
		     		break;
		     	case 7:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 7 );
				
	}
	/**
	 * Propósito: Este módulo muestra un menú por consola para que el
	 * usuario pueda elegir un pais de acuerdo a su número asignado.
	 * 
	 */
	public static int opPais() {
		int op = 0;
		System.out.println("    Elija su origen de fabricación ");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil ");
		System.out.println("4 - Uruguay");;
		System.out.print("  Ingrese una opción: ");
		System.out.println();
		System.out.println("=================================");
		op = sc.nextInt();
		return op;
	}
	/**
	 * Propósito: Este módulo muestra un menú por consola para que el
	 * usuario pueda elegir una categoria de acuerdo a su número asignado.
	 * 
	 */
	public static int opCategoria() {
		int op = 0;
		System.out.println("    Elija su categoría =====");
		System.out.println("1 - Telefonía");
		System.out.println("2 - Informática");
		System.out.println("3 - Electro hogar ");
		System.out.println("4 - Herramientas");;
		System.out.print("  Ingrese una opción: ");
		System.out.println();
		System.out.println("======================");
		op = sc.nextInt();
		return op;
	}
	/**
	 * Propósito: Este módulo crea un nuevo objeto Producto solicitando
	 * por consola al usuario los datos del producto.
	 * También agrega un objeto Producto a un array 'productos'.
	 * 
	 */
	public static void precargaProducto() {
		if(productos == null) {
			productos = new ArrayList<>();
		}
		for(int i=1; i<=15; i++) {
			Producto p = new Producto();
			System.out.println("===== Nuevo Producto =====");
			System.out.print("Ingrese código del producto: ");
			p.setCodigo(sc.nextInt());
			sc.nextLine();
			System.out.print("Ingrese descripción: ");
			p.setDescripcion(sc.nextLine());
			while(true) {
				try {
					System.out.print("Ingrese precio unitario: ");
					p.setPrecioUnit(sc.nextDouble());
					break;
				}catch(Exception e) {
					System.out.println("Debe usar coma ',' como separador decimal.");
					sc.nextLine();
				}
			}
			while(true) {
			try {
				int o = opPais();
				OrigenFab[] valPais = OrigenFab.values();
				OrigenFab pais = valPais[o-1];
				p.setOrigenFab(pais);
				break;
			}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo "
							+ "al país.");
			}
			}
			while(true) {
			try {
			 	int c = opCategoria();
			    Categoria[] valCat = Categoria.values();
			    Categoria categ = valCat[c-1];
			    p.setCategoria(categ);
			    break;
			}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo"
							+ " a la categoria.");
			}
			}
			while(true) {
				try {
					System.out.print("Ingrese si hay stock (true) o no (false): ");
					p.setStock(sc.nextBoolean());
					break;
				}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar 'true' si hay stock, de lo"
							+ "contario debe ingresar 'false'.");
					sc.nextLine();
				}
			}
		    productos.add(p);
		    System.out.println("Producto agregado correctamente.");
		}
	}

}
