/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModulosEsenciales;
/**
 *
 * @author Paco G. <DAW 2016/2017 Ponferrada-Distancia>
 */
public class Validaciones {
 public static void main(String[] args) throws InterruptedException {
    
     //Prueba de validar NIF/NIE.
        System.out.println("VALIDANDO NIF");
        ModulosEsenciales.isNifNie("78521455F");
        ModulosEsenciales.isNifNie("78521455S");
        ModulosEsenciales.isNifNie("1234567982S");
        Thread.sleep(1000);
    // Prueba validar cuenta bancaria
        System.out.println("VALIDANDO CUENTA BANCARIA");
        ModulosEsenciales.esCuentaBancaria("12345678010123456789");
        ModulosEsenciales.esCuentaBancaria("22345678010123456789");
        ModulosEsenciales.esCuentaBancaria("2345678010123456789");
        
 }
}
