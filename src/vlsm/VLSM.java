/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlsm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class VLSM {

    public static void main(String[] args) {

        //System.out.println(calcularTipo("192.0.1.1"));
        //System.out.println(verificarMascara("1000"));
        String ipPrincipal = convertidorDecimalBinario("192.168.128.0");
        String maskPrincipal = convertidorDecimalBinario("255.255.240.0");
        Red r1 = new Red(2000, "R1");
        Red r2 = new Red(1000, "R2");
        Red r3 = new Red(512, "R3");
        Red r4 = new Red(20, "R4");
        Red r5= new Red (12, "R5");
        Red r6= new Red (12, "R6");
        Red r7= new Red (0, "R7");
        Red r8= new Red (0, "R8");
        ArrayList<Red> redes = new ArrayList();
        redes.add(r1);
        redes.add(r2);
        redes.add(r3);
       // redes.add(r4);
       // redes.add(r5);
        redes.add(r6);
 //       redes.add(r7);
  //      redes.add(r8);
        redes = organizaYCalculaMask(redes, maskPrincipal);
        ArrayList<Red> redesLibresViejas = new ArrayList();
        //redesLibres=redesLibres("192.168.10.0","255.255.255.0", 60);
        boolean primera=false;
        for(int i=0;i<redes.size();i++){
            ArrayList<Red> redesLibresNuevas=new ArrayList();
            if (redesLibresViejas.size()==0 && !primera){
                redesLibresNuevas=redesLibres(ipPrincipal,maskPrincipal,redes.get(i).getHost());
                redes.get(i).setMascara(redesLibresNuevas.get(0).getMascara());
                redes.get(i).setMask(redesLibresNuevas.get(0).getMask());
                redes.get(i).setRed(redesLibresNuevas.get(0).getRed());
                redesLibresNuevas.remove(0);
                for (Red r: redesLibresNuevas){
                    redesLibresViejas.add(r);
                }
                redesLibresNuevas= null;
                primera=true;
            }else{
            //   int siguiente= 32 - cantBinarios(redes.get(i).getHost());
            //   System.out.println(siguiente+ " siguiente ");
               Red auxiliar=null;
               int remover=0;
               for (int j=0; j< redesLibresViejas.size();j++){
                   if (j==0){
                       auxiliar=redesLibresViejas.get(0);
                       //remover=0;
                   }else{
                       if (auxiliar.getMascara()<redesLibresViejas.get(j).getMascara()){
                           auxiliar=redesLibresViejas.get(j);
                            remover=j;
                       }/*else if (auxiliar.getMascara()==redesLibresViejas.get(j).getMascara()&& auxiliar!=null) {
                            auxiliar=redesLibresViejas.get(j);
                             remover=j;
                       }*/else{         
                          // System.out.println("NO SE PUEDE ASIGNAR");
                       }
                   }
                  // System.out.println(auxiliar.getRed()+" AUX");
                }
               if (auxiliar!=null){
                    redesLibresNuevas= redesLibres(convertidorDecimalBinario(auxiliar.getRed()),numABinario(auxiliar.getMascara()),redes.get(i).getHost());
                    redes.get(i).setMascara(redesLibresNuevas.get(0).getMascara());
                    redes.get(i).setMask(redesLibresNuevas.get(0).getMask());
                    redes.get(i).setRed(redesLibresNuevas.get(0).getRed());
                    redesLibresNuevas.remove(0);
                  //  System.out.println(redesLibresViejas.get(remover).getRed()+" RED nueva");
                    redesLibresViejas.remove(remover);
                    for (Red r: redesLibresNuevas){
                        redesLibresViejas.add(r);
                    }
               }
            }
    /*boolean asignadaLista=false;
            if (maskPrincipal.equals(numABinario(redesLibresNuevas.get(0).getMascara())) && primera) {
                int con = 0;
                while (!asignadaLista) {
                    if (maskPrincipal.equals(redesLibresViejas.get(con).getMascara()) && "Libre".equals(redesLibresViejas.get(con).getNombre())) {
                        redes.get(i).setRed(redesLibresViejas.get(con).getRed());
                        redesLibresViejas.get(con).setNombre("Ocupado");
                        asignadaLista = true;
                    }
                    con++;
                }
            } else {
                boolean asignada = false;
                int cont = 0;
                while (!asignada) {
                    if (redesLibresNuevas.get(cont).getNombre() == "Libre") {
                        redes.get(i).setNombre(redesLibresNuevas.get(cont).getRed());
                        redesLibresNuevas.get(cont).setNombre("Ocupado");
                        System.out.println("this " + redes.get(i).getNombre() + " " + redes.get(i).getRed() + " " + redes.get(i).getMascara());
                        asignada = true;
                    }
                    cont++;
                }
                if (i + 1 != redes.size()) {
                    boolean inicioAsignado = false;
                    int contInicio = 0;
                    while (!inicioAsignado) {
                        if (redesLibresNuevas.get(contInicio).getNombre() != "Ocupado") {
                            String x1=redesLibresNuevas.get(contInicio).getRed();
                            System.out.println(x1);
                            ipPrincipal = convertidorDecimalBinario(x1);
                            maskPrincipal = numABinario(redesLibresNuevas.get(contInicio).getMascara());
                        }
                        contInicio++;
                    }
                    //maskPrincipal=convertidorDecimalBinario(newMask);
                    for (int j = 0; j < redesLibresNuevas.size(); j++) {
                        redesLibresViejas.add(redesLibresNuevas.get(j));
                    }
                }
                if (i == 0) {
                    primera = true;
                }
            }*/
        }
        for (Red r: redes){
              System.out.println(r.getNombre()+" - "+ r.getRed()+"/"+ r.getMascara() );
         }
    }

    
    
    public static ArrayList<Red> redesLibres(String ip, String mask, int host) {
        int x = 32 - bitsLibres(mask);
        int y = 32 - cantBinarios(host);
        int delta = y - x;
        ArrayList<Red> misRedes = new ArrayList();
        StringTokenizer tk = new StringTokenizer(ip, ".");
        ArrayList<String> arregloIp = new ArrayList();
        String union = "";
        while (tk.hasMoreElements()) {
            String l = tk.nextToken();
            union = union + l;
        }
        char[] cosa = new char[32];
        for (int i = 0; i < union.length(); i++) {
            cosa[i] = union.charAt(i);
        }
        int elevado = 1;
        for (int i = 0; i < delta; i++) {
            elevado = elevado * 2;
        }
        for (int i = 0; i < elevado; i++) {
            String numeroBin = binario(i, delta);
            int cont = 0;
            for (int j = x; j < y; j++) {
                cosa[j] = numeroBin.charAt(cont);
                cont++;
            }
            String primerOct = new String(cosa, 0, 8);
            String segundoOct = new String(cosa, 8, 8);
            String tercerOct = new String(cosa, 16, 8);
            String cuartoOct = new String(cosa, 24, 8);
            int p1 = binarioADecimal(primerOct);
            int p2 = binarioADecimal(segundoOct);
            int p3 = binarioADecimal(tercerOct);
            int p4 = binarioADecimal(cuartoOct);
            String completo = p1 + "." + p2 + "." + p3 + "." + p4;
            misRedes.add(new Red(y, "Libre", completo,numABinario(y)));
        }

        return misRedes;

    }

    
    
    public static int binarioADecimal(String numeroBinario) {
        int longitud = numeroBinario.length();//Numero de digitos que tiene nuestro binario
        int resultado = 0;//Aqui almacenaremos nuestra respuesta final
        int potencia = longitud - 1;
        for (int i = 0; i < longitud; i++) {//recorremos la cadena de numeros
            if (numeroBinario.charAt(i) == '1') {
                resultado += Math.pow(2, potencia);
            }
            potencia--;//drecremantamos la potencia
        }
        return resultado;
    }

    
    
    public static ArrayList organizaYCalculaMask(ArrayList<Red> redes, String maskPrincipal) {
        Collections.sort(redes);
        for (Red a : redes) {
            a.setHost(a.getHost() + 2);
        }
        int libres = bitsLibres(maskPrincipal) - cantBinarios(redes.get(0).getHost());
        if (libres < 0) {
            return null;
        }

        for (Red a : redes) {
            int mask = 32 - cantBinarios(a.getHost());
            //String maskf="/"+mask;
            a.setMascara(mask);
        }
        return redes;
    }

    
    
    public static String calcularTipo(String ip) {
        StringTokenizer tk = new StringTokenizer(ip, ".");

        int num = 0;
        ArrayList dir = new ArrayList();
        while (tk.hasMoreElements()) {
            num = Integer.parseInt((String) tk.nextElement());
            dir.add(num);
            if (num > 255 || num < 0) {
                System.out.println("IP invalida");
                return "Invalida";
            }
        }
        if ((int) dir.get(0) < 128) {
            return "A";
        }
        if ((int) dir.get(0) < 192) {
            return "B";
        }
        if ((int) dir.get(0) < 256) {
            return "C";
        }
        return "Invalida";
    }

    
    
    public static String verificarMascara(String mask) {
        StringTokenizer tk = new StringTokenizer(mask, ".");

        int num = 0;
        ArrayList dir = new ArrayList();
        while (tk.hasMoreElements()) {
            num = Integer.parseInt((String) tk.nextElement());
            dir.add(num);
            if (num > 255 || num < 0) {
                System.out.println("Mascara invalida");
                return "Mascara Invalida";
            }
        }
        if ((int) dir.get(0) < 256 && (int) dir.get(1) == 0 && (int) dir.get(2) == 0 && (int) dir.get(3) == 0) {
            return "A";
        }
        if ((int) dir.get(0) < 256 && (int) dir.get(1) < 256 && (int) dir.get(2) < 256 && (int) dir.get(3) == 0) {
            return "B";
        }
        if ((int) dir.get(0) < 256 && (int) dir.get(1) < 256 && (int) dir.get(2) < 256 && (int) dir.get(3) < 256) {
            return "C";
        }
        return "Invalida";
    }

    
    
    public static int cantBinarios(int host) {
        String bin = Integer.toBinaryString(host);
        return bin.length();
    }

    
    
    public static String binario(int num, int cant) {
        String bin = Integer.toBinaryString(num);
        for (int i = bin.length(); i < cant; i++) {
            bin = "0" + bin;
        }
        return bin;
    }

    
    
    public static String convertidorDecimalBinario(String mask) {
        StringTokenizer tk = new StringTokenizer(mask, ".");

        int num = 0;
        String dir = "";
        while (tk.hasMoreElements()) {
            num = Integer.parseInt((String) tk.nextElement());
            String bin = Integer.toBinaryString(num);
            for (int i = bin.length(); i < 8; i++) {
                bin = "0" + bin;
            }
            dir = dir + bin + ".";
        }
        dir = dir.substring(0, 35);
        //  System.out.println(dir);
        return dir;
    }

    
    
    public static int bitsLibres(String mask) {
        int cont = 0;
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '0') {
                cont++;
            }
        }
        return cont;
    }

    
    
    public static String numABinario(int mascara){
	if (mascara>=0 && mascara <=32){
		String num= "";
                int delta= 32 - mascara;
                String cont ="1";
		for (int i=0;i<mascara;i++){
			
			if ((i%8)==0 && i!=32 && i!=0){
				num=num+".";
			}
                        num=num+cont;
                        if ((i+1)==mascara && mascara<33){
                                mascara= 32;
                                cont= "0";
                        }
		}
		return num;
	}
	return "ERROR";
    }
    
}
