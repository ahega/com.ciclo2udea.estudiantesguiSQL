package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.BaseDeDatos;
import modelo.modelo;
import vista.vista1;
import vista.vista2;
import vista.vista3;
import vista.vista4;
import vista.vista5;

public class controlador implements ActionListener {

    //Atributos de la clase
    modelo model;
    vista1 menu;
    vista2 ingresar;
    vista3 buscar;
    vista4 modificar;
    vista5 lista;
    BaseDeDatos bd;

    public controlador() {  //constructor
        this.menu = new vista1();  //Nuevo objeto de tipo vista1, ahi veremos el menu
        this.ingresar = new vista2(); //Nuevo objeto de tipo vista2
        this.bd = new BaseDeDatos(); //Nuevo objeto de tipo base de datos
        this.buscar = new vista3();// Nuevo objeto de tipo vista3, aqui buscaremos al estudiante
        this.modificar = new vista4();//Nuevo objeto de la vista4, aqui vamos a modiifcar
        this.lista = new vista5();//Nuevo objeto de la vista5 donde veremos todo el directorio
        menu.getBtn_ingresar().addActionListener(this);
        menu.getBtn_salir().addActionListener(this);
        menu.getBtn_buscar().addActionListener(this);
        menu.getBtn_modificar().addActionListener(this);
        menu.getBtn_eliminar().addActionListener(this);
        menu.getBtn_listar().addActionListener(this);
        ingresar.getBtn_guardar().addActionListener(this);
        ingresar.getBtn_cancelar().addActionListener(this);
        buscar.getBtn_buscar().addActionListener(this);
        buscar.getBtn_cancelar().addActionListener(this);
        modificar.getBtn_buscar().addActionListener(this);
        modificar.getBtn_modificar().addActionListener(this);
        modificar.getBtn_cancelar().addActionListener(this);
        lista.getAtras().addActionListener(this);

    }

    public void iniciar() throws ClassNotFoundException {
        menu.setVisible(true);
    }

    @Override
    //Darle vida a los botones
    public void actionPerformed(ActionEvent e) {
        //Aqui los botones del vista_menu
        if (e.getSource() == menu.getBtn_ingresar()) {
            ingresar.setVisible(true);
            menu.dispose();
        }
        if (e.getSource() == menu.getBtn_buscar()) {
            buscar.setVisible(true);
            menu.dispose();
        }

        if (e.getSource() == menu.getBtn_modificar()) {
            modificar.setVisible(true);
            menu.dispose();
        }

        if (e.getSource() == menu.getBtn_eliminar()) {
            int idElim = Integer.parseInt(JOptionPane.showInputDialog(menu, "Ingrese el ID del registro a Eliminar", "Eliminar Registro", 2));
            eliminar(idElim);
        }

        if (e.getSource() == menu.getBtn_listar()) {
            lista.setVisible(true);
            listar();
            menu.dispose();

        }

        if (e.getSource() == menu.getBtn_salir()) {
            //Guarda la informaciòn en archivo csv
            bd.exportarCSV();
            System.exit(0);
        }

        //Aqui los botones de Vista_ingresar
        if (e.getSource() == ingresar.getBtn_guardar()) {
            guardar();
        }

        //Aqui los botones de vista_buscar
        if (e.getSource() == buscar.getBtn_buscar()) {
            buscar();
        }

        //Aqui los botones de modificar
        if (e.getSource() == modificar.getBtn_buscar()) {
            mod_buscar();
        }

        if (e.getSource() == modificar.getBtn_modificar()) {
            modificar();
        }

        //Aqui los botones en comun de todas las vistas
        if (e.getSource() == ingresar.getBtn_cancelar() || e.getSource() == buscar.getBtn_cancelar() || e.getSource() == modificar.getBtn_cancelar() || e.getSource() == lista.getAtras()) {
            ingresar.dispose();
            buscar.dispose();
            modificar.dispose();
            lista.dispose();
            menu.setVisible(true);
        }
    }

    public void guardar() {
        String id = ingresar.getTxt_cedula().getText();
        String nombre = ingresar.getTxt_nombre().getText();
        String apellido = ingresar.getTxt_apellido().getText();
        String correo = ingresar.getTxt_correo().getText();
        String telefono = ingresar.getTxt_telefono().getText();
        String programa = ingresar.getTxt_programa().getText();
        modelo nuevoEst = new modelo(id, nombre, apellido, telefono, correo, programa);
        bd.guardarEstudiante(nuevoEst);
        JOptionPane.showMessageDialog(ingresar, "Estudiante guardado correctamente", "Todo salió OK!", 0);
        ingresar.getTxt_nombre().setText(null);
    }

    public void buscar() {
        buscar.getTxt_nombre().setText(null); // Ejemplo
        int id = Integer.parseInt(buscar.getTxt_cedula().getText());
        modelo resultado = bd.buscarEstudiante(id);
        if (resultado!=null){
        buscar.getTxt_nombre().setText(resultado.getNombre());
        buscar.getTxt_apellido().setText(resultado.getApellido());
        buscar.getTxt_correo().setText(resultado.getCorreo());
        buscar.getTxt_telefono().setText(resultado.getTelefono());
        buscar.getTxt_programa().setText(resultado.getPrograma());
        }else{
        JOptionPane.showMessageDialog(buscar, "Estudiante no registrado","Not OK!",0);
        }
    }

    public void mod_buscar() { ///If y un Else hint: if result==null
        int id = Integer.parseInt(modificar.getTxt_cedula().getText());
        modelo resultado = bd.buscarEstudiante(id);
        if (resultado!=null){
        modificar.getTxt_nombre().setText(resultado.getNombre());
        modificar.getTxt_apellido().setText(resultado.getApellido());
        modificar.getTxt_correo().setText(resultado.getCorreo());
        modificar.getTxt_telefono().setText(resultado.getTelefono());
        modificar.getTxt_programa().setText(resultado.getPrograma());
        }else{
        JOptionPane.showMessageDialog(modificar, "Estudiante no registrado","Not OK!",0);
        }
    }

    public void modificar() {
        int id = Integer.parseInt(modificar.getTxt_cedula().getText());
        String nombre = modificar.getTxt_nombre().getText();
        String apellido = modificar.getTxt_apellido().getText();
        String correo = modificar.getTxt_correo().getText();
        String telefono = modificar.getTxt_telefono().getText();
        String programa = modificar.getTxt_programa().getText();
        if ("".equals(nombre) || "".equals(apellido)) {
            JOptionPane.showMessageDialog(modificar, "No hay datos para modificar", "Not OK!", 0);
        } else {
            modelo newEst = new modelo(Integer.toString(id), nombre, apellido, telefono, correo, programa);
            bd.modificarEst(id, newEst);
            JOptionPane.showMessageDialog(modificar, "Estudiante modificado correctamente", "All OK!", 0);
        }
        ingresar.getTxt_nombre().setText(null);  //Ejemplo
    }

    public void eliminar(int id) {
        modelo estudiante = bd.buscarEstudiante(id);
        if (estudiante != null) {
            bd.eliminar(id);
            JOptionPane.showMessageDialog(menu, "Registro Eliminado correctamente", "All OK!", 0);
        }
        else{
            JOptionPane.showMessageDialog(menu, "Estudiante no registrado", "Not OK!", 0);
        }
    }

    public void listar() {
        bd.SQLtoList();
        ArrayList<modelo> Estudiantes = bd.getLstEstudiantes(); //copia de la lista que hay en la base de datos
        ArrayList<Object[]> list = new ArrayList(); //Lista de apoyo
        for (int i = 0; i < Estudiantes.size(); i++) {
            list.add(new Object[]{
                Estudiantes.get(i).getId(),
                Estudiantes.get(i).getNombre(),
                Estudiantes.get(i).getApellido(),
                Estudiantes.get(i).getCorreo(),
                Estudiantes.get(i).getTelefono(),
                Estudiantes.get(i).getPrograma(),});
            DefaultTableModel tablaModelo = new DefaultTableModel(list.toArray(new Object[][]{}), //Tabla modelo como casa modelo
                    new String[]{"ID", "Nombre", "Apellido", "Correo", "Telefono", "Programa"});

            lista.getjTable1().setModel(tablaModelo); //Seteamos la tabla modelo en el JTable de la vista lista

        }
    }

}
