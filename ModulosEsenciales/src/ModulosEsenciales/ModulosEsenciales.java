/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModulosEsenciales;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Paco G. <DAW 2016/2017 Ponferrada-Distancia>
 */
public class ModulosEsenciales {
    
//Modulos esenciales para comprobar entrada de datos y otras cosas.
    //Modulo para comprobar si el NIF introducido es correcto:
        public static boolean isNifNie(String nif) throws InterruptedException{
            //si es NIE, eliminar la x,y,z inicial para tratarlo como nif
            if (nif.toUpperCase().startsWith("X")||nif.toUpperCase().startsWith("Y")||nif.toUpperCase().startsWith("Z"))
            nif = nif.substring(1);
            Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
            Matcher m = nifPattern.matcher(nif);
            if(m.matches()){
            String letra = m.group(2);
            //Extraer letra del NIF
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int dni = Integer.parseInt(m.group(1));
            dni = dni % 23;
            String reference = letras.substring(dni,dni+1);
            if (reference.equalsIgnoreCase(letra)){
            String r=reference;
                Thread.sleep(1000);
                System.out.println(nif+": NIF Correcto ");
            return true;
            }else{
                Thread.sleep(1000);
                System.err.println(nif+": El NIF no es correcto la letra para ese DNI es "+reference);
            return false;
            }
            }
            else
                Thread.sleep(1000);
                System.err.println(nif+": No es un formato correcto de NIF");  
            return false;
        }
    //Modulo para validar CIF:

    //Modulo para validar cuenta bancaria
        public static boolean esCuentaBancaria (String cuenta) throws InterruptedException{
            Pattern cuentaPattern = Pattern.compile("\\d{20}");
            Matcher m = cuentaPattern.matcher(cuenta);
            if(m.matches()){
                Thread.sleep(1000);    
                System.out.println(cuenta+": Cumple el patrón (20 dígitos)");

                    String banco = "00"+cuenta.substring(0,8);
                    //System.out.println("Banco (con 00) "+banco);

                    int suma = Integer.parseInt(banco.substring(0,1))*1+
                            Integer.parseInt(banco.substring(1,2))*2+
                            Integer.parseInt(banco.substring(2,3))*4+
                            Integer.parseInt(banco.substring(3,4))*8+
                            Integer.parseInt(banco.substring(4,5))*5+
                            Integer.parseInt(banco.substring(5,6))*10+
                            Integer.parseInt(banco.substring(6,7))*9+
                            Integer.parseInt(banco.substring(7,8))*7+
                            Integer.parseInt(banco.substring(8,9))*3+
                            Integer.parseInt(banco.substring(9,10))*6;

                    int control= 11 - (suma%11);
                    //System.out.println("control banco después del modulo 11 "+control);
                    if (control==10)
                            control=1;
                    else if (control==11)
                            control=0;

                    //System.out.println("control "+control );

                    int controlBanco = Integer.parseInt(cuenta.substring(8,9));
                    if (controlBanco!=control){
                            Thread.sleep(1000);
                            System.err.println(cuenta+": No es un número de cuenta válido");
                            return false;
                    }
                    //System.out.println("El control del banco está bien");

                   //System.out.println("cuenta "+cuenta.substring(10,20));

                    suma = Integer.parseInt(cuenta.substring(10,11))*1+
                            Integer.parseInt(cuenta.substring(11,12))*2+
                            Integer.parseInt(cuenta.substring(12,13))*4+
                            Integer.parseInt(cuenta.substring(13,14))*8+
                            Integer.parseInt(cuenta.substring(14,15))*5+
                            Integer.parseInt(cuenta.substring(15,16))*10+
                            Integer.parseInt(cuenta.substring(16,17))*9+
                            Integer.parseInt(cuenta.substring(17,18))*7+
                            Integer.parseInt(cuenta.substring(18,19))*3+
                            Integer.parseInt(cuenta.substring(19,20))*6;

                    control= 11 - (suma%11);
                    //System.out.println("control cuenta después del modulo 11 "+control);
                    if (control==10)
                            control=1;
                    else if (control==11)
                            control=0;

                    //System.out.println("control "+control);

                    int controlcuenta = Integer.parseInt(cuenta.substring(9,10));
                    if (controlcuenta!=control){
                            Thread.sleep(1000);
                            System.err.println(cuenta+": No es un número de cuenta válido");
                            return false;
                    }else{
                            Thread.sleep(1000);
                            System.out.println(cuenta+": Es un número de cuenta válido");
                            return true;

                            }
                    }else{
                        Thread.sleep(1000);
                        System.err.println(cuenta+": No tiene un formato de número de cuenta válido");
                        return false;
                    }

    }
}
