package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFab;

public class Main {
	private static Scanner sc;
	private static List<Producto>  productos;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println();
			System.out.println("========= PRODUCTOS ========");
			System.out.println("1 - Crear un producto.");
			System.out.println("2 - Mostar productos.");
			System.out.println("3 - Modificar producto. ");
			System.out.println("4 - Salir.");
			System.out.print("  Ingrese una opción: ");
			System.out.println();
			System.out.println("============================");
			op = sc.nextInt();
			sc.nextLine();
		    switch (op) {
		     	case 1:
		     		crearProducto();
		     		break;
		     	case 2:
		     		mostrarProductos();
	     			break;
		     	case 3:
		     		modificarProd();
	     			break;
		     	case 4:
		     		System.out.println(" --- FIN DEL PROGRAMA  ---");
	     			break;
	     		default: System.out.println("Opción incorrecta.");
		    }
		
		}while( op != 4 );
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
	public static void crearProducto() {
		if(productos == null) {
			productos = new ArrayList<>();
		}
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
				System.out.println("ERROR. Debe ingresar una opción de acuerdo al país.");
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
				System.out.println("ERROR. Debe ingresar una opción de acuerdo a la categoria.");
		}
		}
	    productos.add(p);
	    System.out.println("Producto agregado correctamente.");
	}
	/**
	 * Propósito: Este módulo muestra de forma iterativa los datos 
	 * de cada objeto producto agragado a el array productos.
	 * 
	 */
	public static void mostrarProductos() {
		if(productos != null) {
			System.out.println("===== Lista de Productos =====");
			productos.forEach(p->System.out.println(p));
		}else {
			System.out.println("ERROR. La lista está vacía.");
		}
	}
	/**
	 * Propósito: El siguiente múdulo función busca un objeto producto
	 * por su código, este solicitado al usuario por consola.
	 * Si lo encuentra devuelve  el objeto producto de otra forma
	 * solo devuelve null.
	 * 
	 */
	public static Producto  buscarProducto(int codigo) {
		Producto Encontrado = null;
		for(Producto cod: productos) {
			if(cod.getCodigo() == codigo) {
				Encontrado = cod;
				break;
			}
		}
		return Encontrado;
	}
	/**
	 * Propósito: Este módulo modifica determinados datos de un producto.
	 * Para esto solicita al usuario el código del producto para buscarlo
	 * y si lo encuentra solicita al usuario los nuevos datos, de otra
	 * manera informa al usuario que el código es incorrecto.
	 * 
	 */
	public static void modificarProd() {
		System.out.println("===== Modificar Producto =====");
		System.out.print("Ingrese código del producto a modificar: ");	
		int cod = sc.nextInt();
		Producto prod = buscarProducto(cod);
		if(prod != null) {
			sc.nextLine();
			System.out.print("Ingrese nueva descripción: ");
			prod.setDescripcion(sc.nextLine());
			while(true) {
				try {
					System.out.print("Ingrese nuevo precio unitario: ");
					prod.setPrecioUnit(sc.nextDouble());
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
					prod.setOrigenFab(valPais[o-1]);
					break;
				}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo al país.");
					sc.next();
				}
			}
			while(true) {
				try {
					int c = opCategoria();
				    Categoria[] valCat = Categoria.values();
				    prod.setCategoria(valCat[c-1]);
				    System.out.println("Prodcuto modificado correctamente.");
				    break;
			}catch(Exception e) {
					System.out.println("ERROR. Debe ingresar una opción de acuerdo a la categoria.");
					sc.next();
			}
			}
		}else {
			System.out.println("ERROR. El código ingresado no existe.");
		}
	}
}
