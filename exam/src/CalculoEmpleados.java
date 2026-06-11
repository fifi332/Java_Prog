public class CalculoEmpleados {
    public static void main(String[] args){
        int[] empleados = {12,5,8,20};

        int totalEmpleados = 0;

        for (int i = 0; i<empleados.length;i++){
            totalEmpleados += empleados[i];
        }
        System.out.println("El número total de empleados en la empresa es: " + totalEmpleados);

    }
}
