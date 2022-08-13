package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDeDatos {

    private ArrayList<modelo> lstEstudiantes; //unico atributo
    /*
    public static final String URL = "jdbc:mysql://localhost:3306/ciclo2";
    public static final String USER = "root";
    public static final String CLAVE = "";
     */
    public static final String URL = "jdbc:mysql://35.222.107.225:3306/ciclo2";
    public static final String USER = "estudiante";
    public static final String CLAVE = "mintic2022*";

    public BaseDeDatos() {
        this.lstEstudiantes = new ArrayList(); //nueva lista vacia   
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE IF NOT EXISTS estudiante(cedula INT(12) NOT NULL, nombre VARCHAR(45) NOT NULL, apellido VARCHAR(45) NOT NULL, telefono VARCHAR(45) NOT NULL, correo VARCHAR(45) NOT NULL, programa VARCHAR(45) NOT NULL, PRIMARY KEY (cedula));";
            stmt.executeUpdate(sql);

            System.out.println("Conectado a la base, pudimos encontrar o crear la tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarEstudiante(modelo estudiante) {  //Metodo recibe modelos
        int id = Integer.parseInt(estudiante.getId());

        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            String sql = "INSERT INTO estudiante (cedula, nombre, apellido, telefono, correo, programa) VALUES(" + id + ",'" + estudiante.getNombre() + "','" + estudiante.getApellido() + "','" + estudiante.getTelefono() + "','" + estudiante.getCorreo() + "','" + estudiante.getPrograma() + "');";
            stmt.executeUpdate(sql);
            System.out.println("Estudiante ingresado correctamente");
        } catch (SQLException e) {

            System.out.println("No se pudo registrar el estudiante");
            e.printStackTrace();
        }
    }

    public modelo buscarEstudiante(int id) {
        modelo result = null; //Por defecto
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            String sql = "SELECT * FROM estudiante WHERE cedula=" + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String programa = rs.getString("programa");
                String telefono = rs.getString("telefono");
                result = new modelo(Integer.toString(id), nombre, apellido, telefono, correo, programa);
            }
            System.out.println("estudiante encontrado");
            rs.close();
            stmt.close();

        } catch (SQLException e) {

            System.out.println("No nos pudimos conectar");
            e.printStackTrace();
        }
        return result;
    }

    public void modificarEst(int id, modelo est) {
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            //Actualizaciòn en la base de datos
            String sql = "UPDATE estudiante SET nombre='" + est.getNombre() + "',apellido='"
                    + est.getApellido() + "', correo='" + est.getCorreo() + "',telefono='"
                    + est.getTelefono() + "',programa='" + est.getPrograma()
                    + "' WHERE cedula=" + id + ";";
            stmt.executeUpdate(sql);
            System.out.println("Estudiante actualizado correctamente");
            stmt.close();
        } catch (SQLException e) {

            System.out.println("No se pudo actualizar el estudiante");
            e.printStackTrace();
        }

    }

    public void eliminar(int id) {
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            //Eliminación en la base de datos
            String sql = "DELETE FROM estudiante WHERE cedula=" + id + ";";
            stmt.executeUpdate(sql);
            System.out.println("Estudiante actualizado correctamente");
            stmt.close();
        } catch (SQLException e) {

            System.out.println("No se pudo actualizar el estudiante");
            e.printStackTrace();
        }

    }

    public void SQLtoList() {
        ArrayList<modelo> temporal = new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            //Eliminación en la base de datos
            String sql = "SELECT * FROM estudiante";
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                int id = resultado.getInt("cedula");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                String programa = resultado.getString("programa");
                modelo estudiante = new modelo(Integer.toString(id), nombre, apellido, telefono, correo, programa);
                temporal.add(estudiante);
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        this.lstEstudiantes = temporal;

    }

    public void exportarCSV() {
        String csvFilePath = "infoestudiantes.csv";
        try ( Connection conn = DriverManager.getConnection(URL, USER, CLAVE);  Statement stmt = conn.createStatement();) {
            //Eliminación en la base de datos
            String sql = "SELECT * FROM estudiante";
            ResultSet resultado = stmt.executeQuery(sql);
            BufferedWriter lapiz = new BufferedWriter(new FileWriter(csvFilePath));

            //Escribir una linea que corresponda al header del archivo csv
            lapiz.write("Cedula,Nombres,Apellido,Correo,Telefono,Programa");

            //Usamos el ResultSet resultado
            while (resultado.next()) {
                int id = resultado.getInt("cedula");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                String programa = resultado.getString("programa");

                String linea = id + "," + nombre + "," + apellido + "," + correo + "," + telefono + "," + programa;
                lapiz.newLine();
                lapiz.write(linea);

            }
            lapiz.close();
            resultado.close();
            stmt.close();

            System.out.println("Estudiante actualizado correctamente");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el estudiante");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File Error");
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "BaseDeDatos{" + "lstEstudiantes=" + lstEstudiantes + '}';
    }

    public ArrayList<modelo> getLstEstudiantes() {
        return lstEstudiantes;
    }

    public void setLstEstudiantes(ArrayList<modelo> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }

}
