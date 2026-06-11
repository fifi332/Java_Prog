import java.util.ArrayList;

public class GestionPersonal {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleado(1,"Ana",2500));
        listaEmpleados.add(new Empleado(2,"Pedro",2000));
        listaEmpleados.add(new Empleado(3,"Ramon",1950));

        Empleado primero = listaEmpleados.get(0);
        primero.setSalario(3000);

        for (Empleado emp : listaEmpleados){
            System.out.println("Nombre: " + emp.getNombre() + ", salario: " + emp.getSalario());
        }
    }
}
