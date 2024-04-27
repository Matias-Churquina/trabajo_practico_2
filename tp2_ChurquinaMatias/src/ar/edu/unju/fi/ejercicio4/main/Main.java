package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static Scanner sc;
	private static List<Jugador> jugadores;
	public static void main(String[] args) {
			sc = new Scanner(System.in);
			int op = 0;
			do {
				System.out.println("============================");
				System.out.println("1 – Alta de jugadores.");
				System.out.println("2 – Mostrar todos los jugadores. ");
				System.out.println("3 – Modificar posición de un jugador");
				System.out.println("4 – Eliminar un jugador");
				System.out.println("5 – Salir.");
				System.out.println("============================");
				System.out.print("    Ingrese una opción: ");
				op = sc.nextInt();
				sc.nextLine();
			    switch (op) {
			     	case 1:
			     		altaJugadores();
			     		break;
			     	case 2:
			     		mostrarJugadores();
		     			break;
			     	case 3:
			     		modificarJugador();
		     			break;
			     	case 4:
			     		eliminarJugador();
		     			break;
			     	case 5:
			     		System.out.println(" --- FIN DEL PROGRAMA  ---");
		     			break;
		     		default: System.out.println("Opción incorrecta.");
			    }
			}while(op != 5);
			sc.close();
		}
	
	public static Posicion selecPosicion() {
		while(true) {
			try {
				System.out.println("    Elija posicion del jugador  ");
				System.out.println("1 - Defensa ");
				System.out.println("2 - Medio");
				System.out.println("3 - Defensa ");
				System.out.println("4 - Arquero");;
				System.out.print("  Ingrese una opción: ");
				System.out.println();
				System.out.println("=================================");
				Posicion[] valPos = Posicion.values();
				Posicion pos = valPos[sc.nextInt()-1];
				return pos;
			}catch(Exception e) {
				System.out.println("ERROR. Debe ingresar una opción de acuerdo a la posición.");
			}
		}
	}
		public static void altaJugadores() {
			if(jugadores == null) {
				jugadores = new ArrayList<>();
			}
			Jugador j = new Jugador(); 
			System.out.println();
			System.out.println("======= Alta Jugador =======");
			System.out.print("Ingrese nombre: ");
			j.setNombre(sc.next());
			System.out.print("Ingrese apellido: ");
			j.setApellido(sc.next());
			System.out.println("Ingrese fecha de nacimiento ");
			System.out.print("Día(dd): ");
			Integer fechaDia = sc.nextInt();
			System.out.print("Mes(MM): ");
			Integer fechaMes = sc.nextInt();
			System.out.print("Año(AAAA): ");
			Integer fechaAño = sc.nextInt();
			LocalDate f = LocalDate.of(fechaAño, fechaMes, fechaDia );
			j.setFechaNac(f);
			System.out.print("Ingrese nacionalidad: ");
			j.setNacionalidad(sc.next());
			while(true) {
				try {
					System.out.print("Ingrese estatura.: ");
					j.setEstatura(sc.nextDouble());
					break;
				}catch(Exception e) {
					System.out.println("ERROR. Debe usar coma ',' como separador decimal.");
					sc.nextLine();
				}
			}
			while(true) {
				try {
					System.out.print("Ingrese peso.: ");
					j.setPeso(sc.nextDouble());
					break;
				}catch(Exception e) {
					System.out.println("ERROR. Debe usar coma ',' como separador decimal.");
					sc.nextLine();
				}
			}
			j.setPosicion(selecPosicion());
			jugadores.add(j);
		}
		public static void mostrarJugadores() {
			if(jugadores != null) {
				System.out.println("===== Jugadores =====");
				jugadores.forEach(j->System.out.println(j));
			}else {
				System.out.println("ERROR. La lista está vacía.");
			}
		}
		public static Jugador buscarJugador(String nombre, String apellido) {
			Jugador Encontrado = null;
			for(Jugador jugador: jugadores) {
				if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
					Encontrado = jugador;
					break;
				}
			}
			return Encontrado;
		}
		
		public static void modificarJugador() {
			System.out.println("===== Modificar jugadores =====");
			System.out.print("- Ingrese nombre de jugador a modificar: ");
			String nombreM = sc.next();
			System.out.print("- Ingrese apellido de jugador a modificar: ");
			String apellidoM = sc.next();
			Jugador bus = buscarJugador(nombreM, apellidoM);				
			if(bus != null) {
				bus.setPosicion(selecPosicion());
			}else {
				System.out.println("ERROR. Jugador no encontrado.");
			}
		}
		
		public static void eliminarJugador() {
			boolean band = false;
			System.out.println("===== Eliminar jugadores =====");
			System.out.println("- Ingrese nombre de jugador a eliminar: ");
			String nombreM = sc.next();
			System.out.println("- Ingrese apellido de jugador a eliminar: ");
			String apellidoM = sc.next();
			Iterator<Jugador> iterator = jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador jug = iterator.next();
				if(jug.getNombre().equals(nombreM) && jug.getApellido().equals(apellidoM)){
					iterator.remove();
					System.out.println("Jugador eliminado correctamente.");
					band = true;
				}
			}
			if (band == false) {
				System.out.println("ERROR. Jugador no encontrado.");
			}
		}
}
