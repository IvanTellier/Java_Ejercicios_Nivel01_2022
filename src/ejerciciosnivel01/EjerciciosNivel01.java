/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosnivel01;

import java.util.Arrays;

/**
 *
 * @author proye
 */
public class EjerciciosNivel01 {

    
    
    public int[] maximos(int[] lista){
        int[] arrayMaximos = {lista[0],lista[0]};
        for (int i=0; i<lista.length; i++){
            if (lista[i] > arrayMaximos[0]){
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            }
            else if (lista[i] > arrayMaximos[1]) {
                arrayMaximos[1] = lista[i];
            }
        }
        return arrayMaximos;
    }
    //segundo ejercicio : PALÍNDROMO
    //para hacer este ejercicio necesito hacer primero
    //una función que "limpie" el string para quitarle
    //los acentos y los espacios en blanco
    private String limpiaFrase(String frase){
        frase = frase.toLowerCase(); //paso la frase a minúsculas
        frase = frase.replace('á', 'a');
        frase = frase.replace('é', 'e');
        frase = frase.replace('í', 'i');
        frase = frase.replace('ó', 'o');
        frase = frase.replace('ú', 'u');
        //quito también los espacios en blanco
        frase = frase.replace(" ", "");
        
        return frase; 
    }
  
    public boolean esPalindromo(String frase){
        frase = limpiaFrase(frase); //quita acentos y espacios en blanco
        
        int indiceIzquierdo = 0;
        int indiceDerecho = frase.length()-1;
        
        while (frase.charAt(indiceIzquierdo) 
                == frase.charAt(indiceDerecho)  
                && indiceIzquierdo <= indiceDerecho){
            indiceIzquierdo++;
            indiceDerecho--;
        }
        if (indiceIzquierdo > indiceDerecho){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean esIsograma (String palabra){
        palabra = limpiaFrase(palabra);
        for(int i = 0; i < palabra.length(); i++){
            for(int j = i + 1; j < palabra.length(); j++){
                if (palabra.charAt(i) == palabra.charAt(j)){
                return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Convirte una frase en acrónimo
     * @param frase la frase a convertir en acrónimo en mayúsculas
     * @return el Acrónimo en mayúsculas
     */
    public String acronimo(String frase){
        //Suponemos que por lo menos hay una letra en la frase
        frase = frase.toUpperCase();
        String palabras[] = frase.split(" ");
        String resultado = "";
        for(int i = 0; i < palabras.length; i++){
            if (!(palabras[i].equals("Y") || palabras[i].equals("E") || palabras[i].equals("DE") || palabras[i].equals("LA") || palabras[i].equals("LAS"))){
            resultado = resultado + palabras[i].charAt(0);
            }
        }
        
        return resultado;
    }
    
    /**
     *  codigo sacado de la pagina "lawebdelprogramador"
     * @param frase
     * @return 
     */
    public boolean esAnagrama (String frase){
        
        String palabra1 = "amor";
        String palabra2 = "mora";
 
    //valida si tienen el mismo tamaño
    if(palabra1.length() == palabra2.length()){
 
    //recorre el largo de la primera palabra
     for(int i = 0; i < palabra1.length(); i++){
 
    //si la segunda palabra no contiene algun caracter de la primera, no es un anagrama y termina
    if(!palabra2.contains(String.valueOf(palabra1.charAt(i)))){
      return false;
        }
     }
    //Si nada falló hasta aqui, probablemente es un anagrama
    return true;
    }
    else{
     return false;
        }
    }
    
    /**
     *  codigo de Jorge Cisneros
     * 
     * @param palabra1
     * @param palabra2
     * @return 
     */
    
    public boolean sonAnagrama (String palabra1, String palabra2){
    
        palabra1 = limpiaFrase(palabra1);
        palabra2 = limpiaFrase(palabra2);
        
        if(palabra1.length() != palabra2.length()){
        return false; // tienen distinto nº de letras, luego 
        }
        else{
            for (int i=0; i<palabra1.length(); i++){
                int j = 0;
                while (j<palabra2.length() && (palabra1.charAt(i) != palabra2.charAt(j))){
                    j++;
                }
                
                if (j == palabra2.length()){ // sale del while porque la letra no esta
                    return false;
                }
                
                palabra2 = palabra2.substring(0, j) + palabra2.substring(j);
            }
            
            if (palabra2.length() == 0){
                return true;
            }
            
            else{
            return false;
            }
        }
    }
    
    public boolean sonAnagramaV2 (String palabra1, String palabra2){
    
        palabra1 = limpiaFrase(palabra1);
        palabra2 = limpiaFrase(palabra2);
        
        if(palabra1.length() != palabra2.length()){
        return false; // tienen distinto nº de letras, luego 
        }
        else{
            for (int i=0; i<palabra1.length(); i++){
                if (palabra2.contains("" + palabra1.charAt(i))){
                    palabra2 = palabra2.replaceFirst("" + palabra1.charAt(i), " ");
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    
    
    public static void main(String[] args) {
        int[] numeros = {99,37,7,54,13};
        int[] numeros2 = {-1,100,8,84,103,100005,77};
        int[] numeros3 = {-1,-100,-8,-84,-103,-100005,-77};
        EjerciciosNivel01 e = new EjerciciosNivel01();
        System.out.println(Arrays.toString(e.maximos(numeros)));
        System.out.println(Arrays.toString(e.maximos(numeros2)));
        System.out.println(Arrays.toString(e.maximos(numeros3)));
    
        System.out.println(e.esPalindromo("Acaso hubo buhos acá"));
        
        System.out.println("Isograma Pájaro:" + e.esIsograma("Pájaro"));
        System.out.println("Isograma Tijeras:" + e.esIsograma("Tijeras"));
        
        System.out.println("acronimo de Alta Velocidad Española: " + e.acronimo("Alta Velocidad Española "));
        System.out.println("acronimo de Objeto Volador No Identificado: " + e.acronimo("Objeto Volador No Identificado "));
        System.out.println("acronimo de Tecnología de la Información y de las Comunicaciones: " + e.acronimo("Tecnología de la Información y de las Comunicaciones"));
        
        System.out.println("Anagrama Amor:" + e.esAnagrama("amor, mora"));
        System.out.println(e.sonAnagrama("amor", "mora"));
        System.out.println(e.sonAnagramaV2("amor", "mora"));
    }
    
    
}
