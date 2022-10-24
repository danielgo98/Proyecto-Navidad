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
			System.out.println("Menú: " + "\n1-Crear Perfil." + "\n2-Calculo del IMC." + "\n3-Seguir hábitos saludables."
							+ "\n4-Conocer si llevas una alimentación variada y rica para una buena salud."
							+ "\n5-Salir del Programa.");
			linea = sc.nextLine();
			opcion = Integer.parseInt(linea);

			if (opcion == 1) {
				if (numPerfil == 0) {
					System.out.println("Has elegido crear un perfil. Puedes dos perfiles máximo.");

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
					System.out.println("Ya has creado el número de perfiles permitidos.");
				}
			}

			else if (opcion == 2) {

				if (numPerfil == 0) {

					System.out.println("Para acceder a esta opción se necesita haber creado un perfil previamente.");

				}

				else {
					System.out.println("Introduce el DNI de tu perfil");
					String dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {
						float imc;

						if (p1.puedeCalcular()) {
							System.out.println("Hola " + p1.getNombre() + " en esta opción puedes calcular tu IMC");

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
							System.out.println("Hola " + p2.getNombre() + " en esta opción puedes calcular tu IMC");

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

						System.out.println("El DNI " + dni + " no se asocia a ningún perfil registrado.");

					}

				}
			}

			else if (opcion == 3) {
				int a = 0, b = 0, c = 0;
				String respuesta;
				String dni;
				if (numPerfil == 0) {
					System.out.println("Para acceder a esta opción se necesita haber creado un perfil previamente.");
				} else {

					System.out.println("En esta opción te realizaremos un test sobre hábitos saludables."
							+ "\nPor favor introduce el DNI de tu perfil para continuar.");
					dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {
						System.out.println("Hola " + p1.getNombre()
								+ ", completa el siguiente test para poder emitir un resultado sobre tus hábitos de vida:");

						do {
							System.out.println("6/1 - ¿Fumas a menudo?" + "\na) Si" + "\nb) Algunos días" + "\nc) No");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar fumar menos o dejarlo.");
						} else {
							c++;
						}

						do {
							System.out.println("6/2 - ¿Cuánto alcohol bebes?" + "\na) Todos los días."
									+ "\nb) Sobretodo los fines de semana." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar beber menos.");
						} else {
							c++;
						}

						do {

							System.out.println("6/3 - ¿Cuántas horas duermes al día?" + "\na) Menos de 4 horas."
									+ "\nb) Entre 5 y 6 horas." + "\nc) Más de 6 horas.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar dormir más.");
						} else {
							c++;
						}

						do {
							System.out.println("6/4 - ¿Sueles estresarte y notar cansancion a lo largo del día?"
									+ "\na) Es mi día a día s." + "\nb) A veces." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar relajarte más.");
						} else {
							c++;
						}

						do {
							System.out.println("6/5 - ¿Cuál es tu forma física?"
									+ "\na) Estoy desentrenado tanto en fuerza como en resistencia."
									+ "\nb) Forma física normal." + "\nc) Muy buena forma física.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que cuidar tu forma física.");
						} else {
							c++;
						}

						do {
							System.out.println("6/6 - ¿Cuántas veces practicas deporte a la semana?"
									+ "\na) Entre 1 y 2 veces." + "\nb) Entre 3 y 4 veces." + "\nc) Todos los días.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que hacer deporte más frecuentemente.");
						} else {
							c++;
						}

						if (a == 6) {

							System.out.println(p1.getNombre()
									+ ", tu salud corre peligro, debes cambiar tus hábitos de forma drástica e inmediata");

						} else if (c == 6) {

							System.out.println("¡ENHORABUENA " + p1.getNombre()
									+ "!, tus hábitos en el día a día son muy buenos."
									+ " Debes seguir así y gozarás más facilmente de una buena salud. Estás aumentando tu esperanza de vida más de 10 años.");
						}

					} else if (dni.equals(p2.getDni())) {

						System.out.println("Hola " + p2.getNombre()
								+ ", completa el siguiente test para poder emitir un resultado sobre tus hábitos de vida:");

						do {
							System.out.println("6/1 - ¿Fumas a menudo?" + "\na) Si" + "\nb) Algunos días" + "\nc) No");
							respuesta = sc.nextLine();
						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar fumar menos o dejarlo.");
						} else {
							c++;
						}

						do {
							System.out.println("6/2 - ¿Cuánto alcohol bebes?" + "\na) Todos los días."
									+ "\nb) Sobretodo los fines de semana." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar beber menos.");
						} else {
							c++;
						}

						do {

							System.out.println("6/3 - ¿Cuántas horas duermes al día?" + "\na) Menos de 4 horas."
									+ "\nb) Entre 5 y 6 horas." + "\nc) Más de 6 horas.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar dormir más.");
						} else {
							c++;
						}

						do {
							System.out.println("6/4 - ¿Sueles estresarte y notar cansancion a lo largo del día?"
									+ "\na) Es mi día a día s." + "\nb) A veces." + "\nc) Muy poco.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Deberías intentar relajarte más.");
						} else {
							c++;
						}

						do {
							System.out.println("6/5 - ¿Cuál es tu forma física?"
									+ "\na) Estoy desentrenado tanto en fuerza como en resistencia."
									+ "\nb) Forma física normal." + "\nc) Muy buena forma física.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que cuidar tu forma física.");
						} else {
							c++;
						}

						do {
							System.out.println("6/6 - ¿Cuántas veces practicas deporte a la semana?"
									+ "\na) Entre 1 y 2 veces." + "\nb) Entre 3 y 4 veces." + "\nc) Todos los días.");
							respuesta = sc.nextLine();

						} while (!respuesta.equalsIgnoreCase("a") && !respuesta.equalsIgnoreCase("b")
								&& !respuesta.equalsIgnoreCase("c"));

						if (respuesta.equalsIgnoreCase("a")) {
							a++;
						} else if (respuesta.equalsIgnoreCase("b")) {
							b++;
							System.out.println("Tienes que hacer deporte más frecuentemente.");
						} else {
							c++;
						}

						if (a == 6) {

							System.out.println(p2.getNombre()
									+ ", tu salud corre peligro, debes cambiar tus hábitos de forma drástica e inmediata");

						} else if (c == 6) {

							System.out.println("¡ENHORABUENA " + p2.getNombre()
									+ "!, tus hábitos en el día a día son muy buenos."
									+ " Debes seguir así y gozarás más facilmente de una buena salud. Estás aumentando tu esperanza de vida más de 10 años.");
						}

					} else {
						System.out.println("El DNI " + dni + " no se asocia a ningún perfil registrado.");
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

					System.out.println("Para acceder a esta opción se necesita haber creado un perfil previamente.");

				} else {

					System.out.println("Introduce el DNI de tu perfil asociado.");
					dni = sc.nextLine();

					if (dni.equals(p1.getDni())) {

						System.out.println("Hola " + p1.getNombre()
								+ ", ¿Cuántas comidas realizas al día? (1,2,3,4,5,6,7,8,9 o 10)");
						comidas = sc.nextInt();

						for (int i = 1; i <= comidas; i++) {

							System.out.println("Comida:" + i);
							System.out.println("¿Cuántas porciones de verdura (guarnición, verdura cruda, ensalada)? (1,2,3,4,5...):");
							verdura += sc.nextInt();

							System.out.println("¿Cuántas porciones de fruta (porción equivale a un puñado de uvas)? (1,2,3,4,5...):");
							fruta += sc.nextInt();
						}
						saltoDeLinea = sc.nextLine();

						if (fruta <= 5) {
							System.out.println(p1.getNombre() + ", es necesario comer al menos 5 piezas de fruta al día.");
						} else {
							System.out.println(p1.getNombre() + ", continúa con el hábito de comer fruta.");
						}

						if (verdura <= 3) {

							System.out.println(p1.getNombre() + ", necesitas comer al menos 3 piezas de verdura al día.");
						} else {
							System.out.println(p1.getNombre() + ", continúa con el hábito de comer verdura");
						}

						System.out.println("¿Cuántas veces a la semana comes Mcdonald's, Kebap o Burguer King?");
						comidaRapida = sc.nextInt();
						saltoDeLinea = sc.nextLine();

						comidasTotal = comidas * 7;
						media = (double) (comidaRapida * 100) / comidasTotal;

						if (media == 0) {
							System.out.println("El no comer comida rápida va a beneficiar tu salud a largo plazo.");
						} else if (media > 0 && media < 10) {

							System.out.println("Tu porcentaje de comida rápida ingerida es de: " + Math.round(media)
									+ "%. Está dentro del límite recomendado.");
						} else if (media > 10 && media < 40) {

							System.out.println("Tu porcentaje de comida semanal ingerida es " + Math.round(media)
									+ "%. Deberías comer menos comida rápida para prevenir posibles problemas de salud.");
						}

						else if (media > 40) {

							System.out.println("Tu porcentaje de comida rápida semanal ingerida es: "+ Math.round(media)
									+ "%. Debes cambiar tus hábitos, tu salud está en riesgo por tu alta ingesta de comida rápida.");

						}

					}

					else if (dni.equals(p2.getDni())) {

						System.out.println("Hola " + p2.getNombre() + ", ¿Cuántas comidas realizas al día? (1,2,3,4,5,6,7,8,9 o 10)");
						comidas = sc.nextInt();

						for (int i = 1; i <= comidas; i++) {

							System.out.println("Comida:" + i);
							System.out.println("¿Cuántas porciones de verdura (guarnición, verdura cruda, ensalada)? (1,2,3,4,5...):");
							verdura += sc.nextInt();

							System.out.println("¿Cuántas porciones de fruta (porción equivale a un puñado de uvas)? (1,2,3,4,5...):");
							fruta += sc.nextInt();
						}
						saltoDeLinea = sc.nextLine();

						if (fruta <= 5) {
							System.out.println(p2.getNombre() + ", es necesario comer al menos 5 piezas de fruta al día.");
						} else {
							System.out.println(p2.getNombre() + ", continúa con el hábito de comer fruta.");
						}

						if (verdura <= 3) {

							System.out.println(p2.getNombre() + ", necesitas comer al menos 3 piezas de verdura al día.");
						} else {
							System.out.println(p2.getNombre() + ", continúa con el hábito de comer verdura");
						}

						System.out.println("¿Cuántas veces a la semana comes Mcdonald's, Kebap o Burguer King?");
						comidaRapida = sc.nextInt();
						saltoDeLinea = sc.nextLine();

						comidasTotal = comidas * 7;
						media = (double) (comidaRapida * 100) / comidasTotal;

						if (media == 0) {
							System.out.println("El no comer comida rápida va a beneficiar tu salud a largo plazo.");
						} else if (media > 0 && media < 10) {

							System.out.println("Tu porcentaje de comida rápida ingerida es de: " + Math.round(media)
									+ "%. Está dentro del límite recomendado.");
						} else if (media > 10 && media < 40) {

							System.out.println("Tu porcentaje de comida semanal ingerida es " + Math.round(media)
									+ "%. Deberías comer menos comida rápida para prevenir posibles problemas de salud.");
						}

						else if (media > 40) {

							System.out.println("Tu porcentaje de comida rápida semanal ingerida es: "
									+ Math.round(media)
									+ "%. Debes cambiar tus hábitos, tu salud está en riesgo por tu alta ingesta de comida rápida.");

						}

					}

					else {

						System.out.println("El DNI " + dni + " no se asocia a ningún perfil registrado.");

					}

				}

			}

		} while (opcion != 5);

	}
}
