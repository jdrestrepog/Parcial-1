/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import interfaces.CalcInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author juan
 */
public class Archivo {

    String ruta;
    Alumno a;

    public Archivo() {
    }

    public Archivo(String ruta, Alumno a) {
        this.ruta = ruta;
        this.a = a;
    }

    public boolean EscribeFichero(String ruta, Alumno a) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = a.getIdentificación() + ";" + a.getNombreCompleto() + ";" + a.getSemestre() + ";"
                    + a.getId_programa() + ";" + a.getEstado() + "\n";
            File file = new File(ruta);

            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean EscribeFichero2(String ruta, Programa p) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = p.getId_programa() + ";" + p.getPrograma() + "\n";
            File file = new File(ruta);

            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public List LeerFichero(String ruta) {
        ArrayList<Alumno> list = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                Alumno a = new Alumno();

                String[] parts = linea.split(";");
                String part1 = parts[0]; // Identificacion
                String part2 = parts[1]; // Nombre completo
                String part3 = parts[2]; // Semestre
                String part4 = parts[3]; // Id Programa
                String part5 = parts[4]; // Estado

                a.setIdentificación(part1);
                a.setNombreCompleto(part2);
                a.setSemestre(Integer.parseInt(part3));
                a.setId_programa(Integer.parseInt(part4));
                a.setEstado(Boolean.parseBoolean(part5));

                CalcInterface c = (CalcInterface) Naming.lookup("Calc");
                Remote lookup = Naming.lookup("Calc");

                if (c.calculate(a.getEstado()) == true) {
                    list.add(a);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    public List LeerFichero2(String ruta) {
        ArrayList<Programa> list = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                Programa p = new Programa();

                String[] parts = linea.split(";");
                String part1 = parts[0]; // Identificacion
                String part2 = parts[1]; // Nombre completo

                p.setId_programa(Integer.parseInt(part1));
                p.setPrograma(part2);

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }
}
