package Test;
import java.util.*;
import Pojos.*;
import Beans.*;

public class Main{
    public static void main(String[] args) {
        var escaner = new Scanner(System.in);

		System.out.print("Escribe el primer número: ");
		double numero1 = escaner.nextDouble();

        System.out.print("Escribe el segundo numero: ");
        double numero2 = escaner.nextDouble();

		var numeros = new Numeros(numero1, numero2);

		var validacion = new Validacion();
		String resultado = validacion.consola(numeros.getNumero1(), numeros.getNumero2());

		System.out.println(resultado);
    }
}