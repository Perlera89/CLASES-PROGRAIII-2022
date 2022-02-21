package Beans;

import Services.IConsola;

public class Validacion implements IConsola{

    @Override
    public String consola(double numero1, double numero2) {
        String resultado;

        if(numero1 >= 0 && numero2 >= 0){
            resultado = "Ambos numeros son positivos";
        }

        else if(numero1 < 0 && numero2 >= 0){
            resultado = "El numero " + numero1 + " es negativo y el numero " + numero2 + " es positivo";
        }

        else if(numero2 < 0 && numero1 >= 0){
            resultado = "El numero " + numero2 + " es negativo y el numero " + numero1 + " es positivo";
        }

        else{
            resultado = "Ambos numeros son negativos";
        }

        return resultado;
    }
    
}
