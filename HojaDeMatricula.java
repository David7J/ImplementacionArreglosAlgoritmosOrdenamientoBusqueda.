import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class HojaDeMatricula {

    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);

        int dato = 9;

        String[] info = new String[9];
        info[0] = "Numero de recibo";
        info[1] = "Numero de inscripcion";
        info[2] = "Nombres y apellidos";
        info[3] = "Numero de carnet";
        info[4] = "Carrera";
        info[5] = "Turno";
        info[6] = "Plan de estudio";
        info[7] = "Semestre";
        info[8] = "Fecha de matricula";

        String[] llenarInfo = new String[dato];
        System.out.println("Por favor ingrese la informacion solicitada. ");
        for (int i = 0; i < llenarInfo.length; i++) {
            System.out.println((i+1) + ")" + " " + info[i] + ":");
            llenarInfo[i] = lector.nextLine();
        }

        String[] informacion = new String[9];
        System.out.println("**************************"); 
        System.out.println("Datos del estudiante: ");
        for (int i = 0; i < info.length; i++) {
            System.out.println((i+1) + "|" + " " + info[i] + ": " + llenarInfo[i]);
        }
        System.out.println(" ");

        System.out.println("Ingrese la cantidad de asignaturas (Maximo 7): ");
        int cantAsig = lector.nextInt();

        while(cantAsig <= 0 || cantAsig > 7){
            System.out.println("Por favor ingrese la cantidad de asignaturas solicitada");
            System.out.println("Ingrese la cantidad de asignaturas (Maximo 7): ");
            cantAsig = lector.nextInt();
        }

        String[] codAsig = new String[cantAsig];
        TreeMap<String, String> asignaturasMap = new TreeMap<>();
        TreeMap<String, String> gruposMap = new TreeMap<>();
        TreeMap<String, Integer> aulasMap = new TreeMap<>();
        TreeMap<String, Double> creditosMap = new TreeMap<>();
        TreeMap<String, Integer> frecuenciasMap = new TreeMap<>();
        TreeMap<String, Integer> retirosMap = new TreeMap<>();

        System.out.println("Ingrese el codigo de asignatura y el nombre: ");

        try{
            for (int i = 0; i < cantAsig; i++) {
                lector.nextLine();

                System.out.println("Codigo de la asignatura " + (i+1) + ": ");
                codAsig[i] = lector.nextLine();

                System.out.println("Nombre de la asignatura: " + (i+1) + ": ");
                String nombreAsig = lector.nextLine();
                asignaturasMap.put(codAsig[i], nombreAsig);

                for (char c : nombreAsig.toCharArray()) {
                    if (Character.isDigit(c)) {
                        System.out.println(" ");
                        System.out.println("La asignatura que ingreso contiene numeros.");
                        return;
                    }
                }

                System.out.println("Ingrese el grupo en el que cursara: ");
                String grupo = lector.nextLine();
                gruposMap.put(codAsig[i], grupo);

                System.out.println("Ingrese el numero de aula: ");
                int aula = lector.nextInt();
                aulasMap.put(codAsig[i], aula);

                while(aula < 0){
                System.out.println("No se permieten negativos ni cero");
                System.out.println("Ingrese el numero de aula: ");
                aula = lector.nextInt();
                aulasMap.put(codAsig[i], aula);
                }

                System.out.println("Ingrese los creditos de la clase (Maximo 4): ");
                double credito = lector.nextDouble();
                creditosMap.put(codAsig[i], credito);

                while(credito < 0 || credito > 4 ){
                System.out.println("Por favor ingrese una cantidad de creditos valida");
                System.out.println("Ingrese los creditos de la clase (Maximo 4): ");
                credito = lector.nextDouble();
                creditosMap.put(codAsig[i], credito);
                }

                System.out.println("Ingrese la frecuencia de inscripcion de asignatura (Maximo 3): ");
                int frecuencia = lector.nextInt();
                frecuenciasMap.put(codAsig[i], frecuencia);

                while(frecuencia < 0 || frecuencia > 3){
                System.out.println("Por favor ingrese una cantidad de frecuencia correcta");
                System.out.println("Ingrese la frecuencia de inscripcion de asignatura (Maximo 3): ");
                frecuencia = lector.nextInt();
                frecuenciasMap.put(codAsig[i], frecuencia);
                }

                System.out.println("Ingrese la cantidad de retiros de asignatura (Maximo 1): ");
                int retiro = lector.nextInt();
                retirosMap.put(codAsig[i], retiro);

                while(retiro < 0 || retiro > 1){
                System.out.println("Por favor ingrese una cantidad de retiros valida");
                System.out.println("Ingrese la cantidad de retiros de asignatura (Ingrese: 0 o 1)): ");
                retiro = lector.nextInt();
                retirosMap.put(codAsig[i], retiro);
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Se ha producido una excepcion, porfavor ingrese un valor que sea valido: " + e);
        }

        System.out.println(" ");
        System.out.println("Hoja de matricula: ");
        System.out.println("No. " + "Asignatura " +         "Grupo " +      "Aula " +     "Cred. " +  "F " +  "R ");
        System.out.println(" ");
        int contador = 1;

        for(String nombreAsig: asignaturasMap.keySet()){
            String codigo = asignaturasMap.get(nombreAsig);
            String grupos = gruposMap.get(nombreAsig);
            int aulas = aulasMap.get(nombreAsig);
            double creds = creditosMap.get(nombreAsig);
            int frecuencias = frecuenciasMap.get(nombreAsig);
            int ret = retirosMap.get(nombreAsig);

            System.out.println(contador + " | " + codigo + " | " + nombreAsig + " | " + grupos + " | " + aulas + " | " + creds + " | " + frecuencias + " | " + ret );
            contador++;
        }


        lector.close();
    }
}
