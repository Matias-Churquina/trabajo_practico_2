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
		try {
			System.out.print("Ingrese precio unitario: ");
			p.setPrecioUnit(sc.nextDouble());
		}catch(Exception e) {
			System.out.println("Debe usar coma ',' como separador decimal.");
		}
		try {
			int o = opPais();
			OrigenFab[] valPais = OrigenFab.values();
			OrigenFab pais = valPais[o-1];
			p.setOrigenFab(pais);
		}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo al país.");
		}
		try {
		 	int c = opCategoria();
		    Categoria[] valCat = Categoria.values();
		    Categoria categ = valCat[c-1];
		    p.setCategoria(categ);
		}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo a la categoria.");
		}
	    productos.add(p);
	}
	public static void mostrarProductos() {
		if(productos != null) {
			System.out.println("===== Lista de Productos =====");
			productos.forEach(p->System.out.println(p));
		}else {
			System.out.println("ERROR. La lista está vacía.");
		}
	}
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
	public static void modificarProd() {
		System.out.println("===== Modificar Producto =====");
		System.out.print("Ingrese código del producto a modificar: ");	
		int cod = sc.nextInt();
		Producto prod = buscarProducto(cod);
		if(prod != null) {
			sc.nextLine();
			System.out.print("Ingrese nueva descripción: ");
			prod.setDescripcion(sc.nextLine());
			System.out.print("Ingrese nuevo precio unitario: ");
			prod.setPrecioUnit(sc.nextDouble());
			try {
			int o = opPais();
			OrigenFab[] valPais = OrigenFab.values();
			prod.setOrigenFab(valPais[o-1]);
			}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo al país.");
			}
			try {
			int c = opCategoria();
		    Categoria[] valCat = Categoria.values();
		    prod.setCategoria(valCat[c-1]);
			}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo a la categoria.");
			}
		} else {
			System.out.println("ERROR. El código ingresado no existe.");
			
		}
	}
}
