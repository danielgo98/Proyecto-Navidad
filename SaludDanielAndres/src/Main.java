import java.util.*;

public class Main {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		int opcion;
		int numPerfil = 0;
		String linea;
		String saltoDeLinea;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Men�: " + "\n1-Crear Perfil." + "\n2-Calculo del IMC." + "\n3-Seguir h�bitos saludables."
							+ "\n4-Conocer si llevas una alimentaci�n variada y rica para una buena salud."
							+ "\n5-Salir del Programa.");
			linea = sc.nextLine();
			opcion = Integer.parseInt(linea);

			if (opcion == 1) {
				if (numPerfil == 0) {
					System.out.println("Has elegido crear un perfil. Puedes dos perfiles m�ximo.");

					do {
						System.out.println("Introduce tu nombre:");
						p1.setNombre(sc.nextLine());
					} while (p1.getNombre().equals(""));

					do {
						System.out.println("Introduce tu DNI:");
						p1.setDni(sc.nextLine());
					} while (!p1.longitudDni() || !p1.comprobarDni());

					do {
						System.out.println("Introduce tu sexo:");
						p1.setSexo(sc.nextLine());
					} while (!p1.comprobarSexo());

					do {
						System.out.println("Introduce tu edad:");
						p1.setEdad(sc.nextInt());
					} while (!p1.comprobarEdad());

					System.out.println(p1.toString());
					numPerfil++;
					saltoDeLinea = sc.nextLine();
				} else if (numPerfil == 1) {
					System.out.println("Has elegido crear otro perfil. Ya no puedes volver a crear otro perfil");

					do {
						System.out.println("Introduce tu nombre:");
						p2.setNombre(sc.nextLine());
					} while (p2.getNombre().equals(""));

					do {
						System.out.println("Introduce tu DNI:");
						p2.setDni(sc.nextLine());
					} while (!p2.longitudDni() || !p2.comprobarDni() || p1.getDni().equals(p2.getDni()));

					do {
						System.out.println("Introduce tu sexo:");
						p2.setSexo(sc.nextLine());
					} while (!p2.comprobarSexo());

					do {
						System.out.println("Introduce tu edad:");
						p2.setEdad(sc.nextInt());
					} while (!p2.comprobarEdad());

					System.out.println(p2.toString());
					numPerfil++;
					saltoDeLinea = sc.nextLine();
				}

				else if (numPerfil == 2) {
					System.out.println("Ya has creado el n�mero de perfiles permitidos.");
				}
			}

			else if (opcion == 2) {

				if (numPerfil == 0) {

					System.out.println("Para acceder a esta opci�n se necesita haber creado un perfil previamente.");

				}

				else {
					System.out.println("Introduce el DNI de tu perfil");
					String dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {
						float imc;

						if (p1.puedeCalcular()) {
							System.out.println("Hola " + p1.getNombre() + " en esta opci�n puedes calcular tu IMC");

							System.out.println("Introduce tu altura (m):");
							p1.setAltura(sc.nextFloat());

							System.out.println("Introduce tu peso (kg):");
							p1.setPeso(sc.nextFloat());
							saltoDeLinea = sc.nextLine();
						}

						imc = p1.calculoIMC();

						if (imc < 18.5) {
							System.out.println(p1.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso inferior al normal.");
						}

						else if (imc >= 18.5 && imc < 25) {

							System.out.println(p1.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso normal.");

						}

						else if (imc >= 25 && imc < 30) {

							System.out.println(p1.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso superior al normal.");

						}

						else if (imc >= 30) {

							System.out.println(p1.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes obesidad.");
						}

					}

					else if (dni.equals(p2.getDni())) {
						float imc;

						if (p2.puedeCalcular()) {
							System.out.println("Hola " + p2.getNombre() + " en esta opci�n puedes calcular tu IMC");

							System.out.println("Introduce tu altura (m):");
							p2.setAltura(sc.nextFloat());

							System.out.println("Introduce tu peso (kg):");
							p2.setPeso(sc.nextFloat());
							saltoDeLinea = sc.nextLine();
						}

						imc = p2.calculoIMC();

						if (imc < 18.5) {
							System.out.println(p2.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso inferior al normal.");
						}

						else if (imc >= 18.5 && imc < 25) {

							System.out.println(p2.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso normal.");

						}

						else if (imc >= 25 && imc < 30) {

							System.out.println(p2.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes un peso superior al normal.");

						}

						else if (imc >= 30) {

							System.out.println(p2.getNombre() + " tu IMC es de " + Math.round(imc * 100.00) / 100.00
									+ " tienes obesidad.");
						}

					}

					else {

						System.out.println("El DNI " + dni + " no se asocia a ning�n perfil registrado.");

					}

				}
			}

			else if (opcion == 3) {
				int a = 0, b = 0, c = 0;
				String respuesta;
				String dni;
				if (numPerfil == 0) {
					System.out.println("Para acceder a esta opci�n se necesita haber creado un perfil previamente.");
				} else {

					System.out.println("En esta opci�n te realizaremos un test sobre h�bitos saludables."
							+ "\nPor favor introduce el DNI de tu perfil para continuar.");
					dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {
						System.out.println("Hola " + p1.getNombre()
								+ ", completa el siguiente test para poder emitir un resultado sobre tus h�bitos de vida:");

						do {
							System.out.println("6/1 - �Fumas a menudo?" + "\na) Si" + "\nb) Algunos d�as" + "\nc) No");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar fumar menos o dejarlo.");
						} else {
							c++;
						}

						do {
							System.out.println("6/2 - �Cu�nto alcohol bebes?" + "\na) Todos los d�as."
									+ "\nb) Sobretodo los fines de semana." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar beber menos.");
						} else {
							c++;
						}

						do {

							System.out.println("6/3 - �Cu�ntas horas duermes al d�a?" + "\na) Menos de 4 horas."
									+ "\nb) Entre 5 y 6 horas." + "\nc) M�s de 6 horas.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar dormir m�s.");
						} else {
							c++;
						}

						do {
							System.out.println("6/4 - �Sueles estresarte y notar cansancion a lo largo del d�a?"
									+ "\na) Es mi d�a a d�a s." + "\nb) A veces." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar relajarte m�s.");
						} else {
							c++;
						}

						do {
							System.out.println("6/5 - �Cu�l es tu forma f�sica?"
									+ "\na) Estoy desentrenado tanto en fuerza como en resistencia."
									+ "\nb) Forma f�sica normal." + "\nc) Muy buena forma f�sica.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que cuidar tu forma f�sica.");
						} else {
							c++;
						}

						do {
							System.out.println("6/6 - �Cu�ntas veces practicas deporte a la semana?"
									+ "\na) Entre 1 y 2 veces." + "\nb) Entre 3 y 4 veces." + "\nc) Todos los d�as.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que hacer deporte m�s frecuentemente.");
						} else {
							c++;
						}

						if (a == 6) {

							System.out.println(p1.getNombre()
									+ ", tu salud corre peligro, debes cambiar tus h�bitos de forma dr�stica e inmediata");

						} else if (c == 6) {

							System.out.println("�ENHORABUENA " + p1.getNombre()
									+ "!, tus h�bitos en el d�a a d�a son muy buenos."
									+ " Debes seguir as� y gozar�s m�s facilmente de una buena salud. Est�s aumentando tu esperanza de vida m�s de 10 a�os.");
						}

					} else if (dni.equals(p2.getDni())) {

						System.out.println("Hola " + p2.getNombre()
								+ ", completa el siguiente test para poder emitir un resultado sobre tus h�bitos de vida:");

						do {
							System.out.println("6/1 - �Fumas a menudo?" + "\na) Si" + "\nb) Algunos d�as" + "\nc) No");
							respuesta = sc.nextLine();
						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar fumar menos o dejarlo.");
						} else {
							c++;
						}

						do {
							System.out.println("6/2 - �Cu�nto alcohol bebes?" + "\na) Todos los d�as."
									+ "\nb) Sobretodo los fines de semana." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar beber menos.");
						} else {
							c++;
						}

						do {

							System.out.println("6/3 - �Cu�ntas horas duermes al d�a?" + "\na) Menos de 4 horas."
									+ "\nb) Entre 5 y 6 horas." + "\nc) M�s de 6 horas.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar dormir m�s.");
						} else {
							c++;
						}

						do {
							System.out.println("6/4 - �Sueles estresarte y notar cansancion a lo largo del d�a?"
									+ "\na) Es mi d�a a d�a s." + "\nb) A veces." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deber�as intentar relajarte m�s.");
						} else {
							c++;
						}

						do {
							System.out.println("6/5 - �Cu�l es tu forma f�sica?"
									+ "\na) Estoy desentrenado tanto en fuerza como en resistencia."
									+ "\nb) Forma f�sica normal." + "\nc) Muy buena forma f�sica.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que cuidar tu forma f�sica.");
						} else {
							c++;
						}

						do {
							System.out.println("6/6 - �Cu�ntas veces practicas deporte a la semana?"
									+ "\na) Entre 1 y 2 veces." + "\nb) Entre 3 y 4 veces." + "\nc) Todos los d�as.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que hacer deporte m�s frecuentemente.");
						} else {
							c++;
						}

						if (a == 6) {

							System.out.println(p2.getNombre()
									+ ", tu salud corre peligro, debes cambiar tus h�bitos de forma dr�stica e inmediata");

						} else if (c == 6) {

							System.out.println("�ENHORABUENA " + p2.getNombre()
									+ "!, tus h�bitos en el d�a a d�a son muy buenos."
									+ " Debes seguir as� y gozar�s m�s facilmente de una buena salud. Est�s aumentando tu esperanza de vida m�s de 10 a�os.");
						}

					} else {
						System.out.println("El DNI " + dni + " no se asocia a ning�n perfil registrado.");
					}
				}
			}

			else if (opcion == 4) {
				String dni;
				int comidaRapida = 0;
				int comidas = 0;
				int fruta = 0;
				int verdura = 0;
				int comidasTotal = 0;
				double media = 0;

				if (numPerfil == 0) {

					System.out.println("Para acceder a esta opci�n se necesita haber creado un perfil previamente.");

				} else {

					System.out.println("Introduce el DNI de tu perfil asociado.");
					dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {

						System.out.println("Hola " + p1.getNombre()
								+ ", �Cu�ntas comidas realizas al d�a? (1,2,3,4,5,6,7,8,9 o 10)");
						comidas = sc.nextInt();

						for (int i = 1; i <= comidas; i++) {

							System.out.println("Comida:" + i);
							System.out.println("�Cu�ntas porciones de verdura (guarnici�n, verdura cruda, ensalada)? (1,2,3,4,5...):");
							verdura += sc.nextInt();

							System.out.println("�Cu�ntas porciones de fruta (porci�n equivale a un pu�ado de uvas)? (1,2,3,4,5...):");
							fruta += sc.nextInt();
						}
						saltoDeLinea = sc.nextLine();

						if (fruta <= 5) {
							System.out.println(p1.getNombre() + ", es necesario comer al menos 5 piezas de fruta al d�a.");
						} else {
							System.out.println(p1.getNombre() + ", contin�a con el h�bito de comer fruta.");
						}

						if (verdura <= 3) {

							System.out.println(p1.getNombre() + ", necesitas comer al menos 3 piezas de verdura al d�a.");
						} else {
							System.out.println(p1.getNombre() + ", contin�a con el h�bito de comer verdura");
						}

						System.out.println("�Cu�ntas veces a la semana comes Mcdonald's, Kebap o Burguer King?");
						comidaRapida = sc.nextInt();
						saltoDeLinea = sc.nextLine();

						comidasTotal = comidas * 7;
						media = (double) (comidaRapida * 100) / comidasTotal;

						if (media == 0) {
							System.out.println("El no comer comida r�pida va a beneficiar tu salud a largo plazo.");
						} else if (media > 0 && media < 10) {

							System.out.println("Tu porcentaje de comida r�pida ingerida es de: " + Math.round(media)
									+ "%. Est� dentro del l�mite recomendado.");
						} else if (media > 10 && media < 40) {

							System.out.println("Tu porcentaje de comida semanal ingerida es " + Math.round(media)
									+ "%. Deber�as comer menos comida r�pida para prevenir posibles problemas de salud.");
						}

						else if (media > 40) {

							System.out.println("Tu porcentaje de comida r�pida semanal ingerida es: "+ Math.round(media)
									+ "%. Debes cambiar tus h�bitos, tu salud est� en riesgo por tu alta ingesta de comida r�pida.");

						}

					}

					else if (dni.equals(p2.getDni())) {

						System.out.println("Hola " + p2.getNombre() + ", �Cu�ntas comidas realizas al d�a? (1,2,3,4,5,6,7,8,9 o 10)");
						comidas = sc.nextInt();

						for (int i = 1; i <= comidas; i++) {

							System.out.println("Comida:" + i);
							System.out.println("�Cu�ntas porciones de verdura (guarnici�n, verdura cruda, ensalada)? (1,2,3,4,5...):");
							verdura += sc.nextInt();

							System.out.println("�Cu�ntas porciones de fruta (porci�n equivale a un pu�ado de uvas)? (1,2,3,4,5...):");
							fruta += sc.nextInt();
						}
						saltoDeLinea = sc.nextLine();

						if (fruta <= 5) {
							System.out.println(p2.getNombre() + ", es necesario comer al menos 5 piezas de fruta al d�a.");
						} else {
							System.out.println(p2.getNombre() + ", contin�a con el h�bito de comer fruta.");
						}

						if (verdura <= 3) {

							System.out.println(p2.getNombre() + ", necesitas comer al menos 3 piezas de verdura al d�a.");
						} else {
							System.out.println(p2.getNombre() + ", contin�a con el h�bito de comer verdura");
						}

						System.out.println("�Cu�ntas veces a la semana comes Mcdonald's, Kebap o Burguer King?");
						comidaRapida = sc.nextInt();
						saltoDeLinea = sc.nextLine();

						comidasTotal = comidas * 7;
						media = (double) (comidaRapida * 100) / comidasTotal;

						if (media == 0) {
							System.out.println("El no comer comida r�pida va a beneficiar tu salud a largo plazo.");
						} else if (media > 0 && media < 10) {

							System.out.println("Tu porcentaje de comida r�pida ingerida es de: " + Math.round(media)
									+ "%. Est� dentro del l�mite recomendado.");
						} else if (media > 10 && media < 40) {

							System.out.println("Tu porcentaje de comida semanal ingerida es " + Math.round(media)
									+ "%. Deber�as comer menos comida r�pida para prevenir posibles problemas de salud.");
						}

						else if (media > 40) {

							System.out.println("Tu porcentaje de comida r�pida semanal ingerida es: "
									+ Math.round(media)
									+ "%. Debes cambiar tus h�bitos, tu salud est� en riesgo por tu alta ingesta de comida r�pida.");

						}

					}

					else {

						System.out.println("El DNI " + dni + " no se asocia a ning�n perfil registrado.");

					}

				}

			}

		} while (opcion != 5);

	}
}
