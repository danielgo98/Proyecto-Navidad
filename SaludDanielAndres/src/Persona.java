
public class Persona {

	//atributos
	private String nombre;
	private int edad;
	private String sexo;
	private String dni;
	private float altura;
	private float peso;
	
	//constructores
	public Persona() {
		
	}
	
	public Persona(String nombre, String dni, int edad, String sexo, float altura, float peso) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	//getter
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public float getPeso() {
		return peso;
	}
	
	
	//setter
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	//metodos
	
	public boolean longitudDni() { //compruebo que la longitud del DNI no supere 9 caracteres
		
		if (dni.length() == 9) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	//compruebo la letra del dni
	public boolean comprobarDni() {
		String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
		int posicionLetra = Integer.parseInt(dni.substring(0,8)) % 23;
		
		if (!String.valueOf(letra.charAt(posicionLetra)).equalsIgnoreCase(String.valueOf(this.dni.charAt(8)))){
			System.out.println("La letra del DNI es incorrecta, intentalo de nuevo");
			return false;
		}else {
			return true;
		}
		
	}
	
	//comprebo que la edad que se introduzca sea un número entre 5 y 120
	public boolean comprobarEdad() {
		
		return edad > 4 && edad < 121;
	}
	
	//compruebo que se pueda introducir solo dos valores H o M
	public boolean comprobarSexo() {
		
		return sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M");
	}
	
	//metodo para comprobar si se ha pedido la altura y el peso para calcular el IMC
	public boolean puedeCalcular() {
		
		return this.altura == 0.0 && this.peso == 0.0;
	}
	
	//metodo para calcular el IMC
	public float calculoIMC() {
		float imc = peso / (float)(Math.pow(altura, 2));
		
		return imc;
	}
	
	@Override
	public String toString() {
		return "Perfil creado, tus datos son: " + "\nNombre: " + this.nombre + "\nDNI: " + this.dni + "\nEdad:" + this.edad + "\nSexo: " + this.sexo + "\n";
	}
}
