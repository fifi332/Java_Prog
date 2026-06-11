public class Evaluador {
    public static void main(String[] args){
        int antiguedad = 12;
        boolean tieneAscensor = false;

        if (antiguedad > 10 && !tieneAscensor){
            System.out.println("Requiere reforma urgente");
        }else if(antiguedad > 10 && tieneAscensor){
            System.out.println("Requiere mantenimiento de rutina");
        }else{
            System.out.println("oficina en buen estado");
        }

    }
}
