/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlsm;

import java.util.Comparator;

public class Red implements Comparable<Red> {
    
    private String nombre;
    private String red;
    private String mask;
    private int host;
    private int mascara;
    public Red(){
        red="";
        mask="";
        host=0;
    }
    public Red(int h,String n){
        host=h;
        nombre=n;
    }
    public Red(int mask,String n,String ip){
        mascara=mask;
        nombre=n;
        red=ip;
    }
     public Red(int mask,String n,String ip, String m){
        mascara=mask;
        nombre=n;
        red=ip;
        this.mask=m;
    }
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public int getMascara() {
        return mascara;
    }

    public void setMascara(int mascara) {
        this.mascara = mascara;
    }
    
    @Override
    public int compareTo(Red comparar) {
           return  Comparators.host.compare(this, comparar);
         
    }
    public static class Comparators{
        public static Comparator<Red> host= new Comparator<Red>(){
          @Override
          public int compare(Red r1,Red r2){
              return r2.getHost()-(r1.getHost());
          }  
        
        };
    
    
    };

   
}
