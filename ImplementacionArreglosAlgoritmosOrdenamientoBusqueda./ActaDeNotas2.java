import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class ActaDeNotas2 {
    public static void main(String[] args) {
         Scanner lector = new Scanner(System.in);
        int datoS = 8;

        String[] datos = new String[8];
        datos[0] = "Curso";
        datos[1] = "Período lectivo";
        datos[2] = "Carrera";
        datos[3] = "Modalidad";
        datos[4] = "Código del curso";
        datos[5] = "Grupo";
        datos[6] = "Código de asignatura";
        datos[7] = "Código de programa de asignatura";

        String[] DatosLlenar = new String[datoS];
        System.out.println("Bienvenido, Ingresa los valores solicitados");
        for (int i = 0; i < DatosLlenar.length; i++) {
            System.out.print((i + 1) + "|" + " " + datos[i] + ":");
            DatosLlenar[i] = lector.nextLine();
        }

        String[] nombreDatos = new String[8];
        System.out.println("::::::::::::::::::::::::::::::::::");
        System.out.println("Datos Generales");
        for (int i = 0; i < datos.length; i++) {
            System.out.println((i + 1) + "|" + " " + datos[i] + ":" + "\t" + " " + DatosLlenar[i]);
        }

        System.out.println("Ingrese la cantidad de estudiantes: ");
        int cantEst = lector.nextInt();

        while (cantEst <= 0) {
            System.out.println("No se permiten valores negativos ni cero");
            System.out.println("Ingrese la cantidad de notas: ");
            cantEst = lector.nextInt();
        }

        String[] nombre = new String[cantEst];
        TreeMap<String, String> apellidosMap = new TreeMap<>();
        TreeMap<String, Double> notasMap = new TreeMap<>();
        TreeMap<String, Double> notas2Map = new TreeMap<>();
        TreeMap<String, Double> notasSistMap = new TreeMap<>();
        TreeMap<String, Double> notaTotalMap = new TreeMap<>();
        TreeMap<String, Double> notasConv1Map = new TreeMap<>();
        TreeMap<String, Double> notasConv2Map = new TreeMap<>();
        TreeMap<String, Double> notaFinal1Map = new TreeMap<>();
        TreeMap<String, String> numCarnetsMap = new TreeMap<>();

        System.out.println("Ingrese el nombre completo y los apellidos del estudiante: ");

        try {
            for (int i = 0; i < cantEst; i++) {
                lector.nextLine();

                System.out.print("Nombre del estudiante " + (i + 1) + ": ");
                nombre[i] = lector.nextLine();

                for (char c : nombre[i].toCharArray()) {
                    if (Character.isDigit(c)) {
                        System.out.println(" ");
                        System.out.println("El nombre que ingreso contiene numeros.");
                        return;
                    }
                }

                System.out.print("Apellidos del estudiante " + (i + 1) + ": ");
                String apellido = lector.nextLine();
                apellidosMap.put(apellido, nombre[i]);

                for (char c : apellido.toCharArray()) {
                    if (Character.isDigit(c)) {
                        System.out.println(" ");
                        System.out.println("El apellido que ingreso contiene numeros.");
                        return;
                    }
                }

                System.out.println("Ingrese el numero de carnet: ");
                String numCarnet = lector.nextLine();
                numCarnetsMap.put(apellido, numCarnet);

                System.out.println("Nota Primer Parcial del estudiante " + (i + 1) + "(Maximo 35.00) ");
                double nota = lector.nextDouble();
                notasMap.put(apellido, nota);

                while (nota > 35 || nota < 0) {
                    System.out.println("La nota que ha ingresado es incorrecta, por favor intente de nuevo");
                    System.out.println("Nota Primer Parcial del estudiante " + (i + 1) + "(Maximo 35.00) ");
                    nota = lector.nextDouble();
                    notasMap.put(apellido, nota);
                }

                System.out.println("Nota segundo parcial del estudiante " + (i + 1) + "(Maximo 35.00) ");
                double nota2 = lector.nextDouble();
                notas2Map.put(apellido, nota2);

                while (nota2 > 35 || nota2 < 0) {
                    System.out.println("La nota que ha ingresado es incorrecta, por favor intente de nuevo");
                    System.out.println("Nota segundo Parcial del estudiante " + (i + 1) + "(Maximo 35.00) ");
                    nota2 = lector.nextDouble();
                    notas2Map.put(apellido, nota2);
                }

                System.out.println("Nota total de sistematicos del estudiante " + (i + 1) + "(Maximo 30.00 ) ");
                double notaSist = lector.nextDouble();
                notasSistMap.put(apellido, notaSist);

                while (notaSist > 30 || notaSist < 0) {
                    System.out.println("La nota que ha ingresado es incorrecta, por favor intente de nuevo");
                    System.out.println("Nota total de sistematicos del estudiante " + (i + 1) + "(Maximo 30.00) ");
                    notaSist = lector.nextDouble();
                    notasSistMap.put(apellido, notaSist);
                }

                double SumaNotas = nota + nota2 + notaSist;
                notaTotalMap.put(apellido, SumaNotas);

                if (SumaNotas < 60) {
                    System.out.println("El estudiante va a primera convocatoria: ");
                    System.out.println("Nota de primer conovocatoria estudiante " + (i + 1) + "(Maximo 70.00)");
                    double notaConv = lector.nextDouble();
                    notasConv1Map.put(apellido, notaConv);

                    double notaFinalConvo = notaSist + notaConv;
                    notaFinal1Map.put(apellido, notaFinalConvo);

                    while (notaConv > 70 || notaConv < 0) {
                        System.out.println(" ");
                        System.out.println("La nota que ha ingresado es incorrecta, por favor intente de nuevo");
                        System.out.println("Nota de primer convocatoria del estudiante " + (i + 1) + "(Maximo 70.00) ");
                        notaConv = lector.nextDouble();
                        notasConv1Map.put(apellido, notaConv);

                        notaFinalConvo = notaSist + notaConv;
                        notaFinal1Map.put(apellido, notaFinalConvo);
                    }

                    if (notaFinalConvo < 60) {
                        System.out.println("El estudiante va a segunda convocatoria: ");
                        System.out.println("Nota de segunda convocatoria del estudiante " + (i + 1) + "(Maximo 100.00) ");
                        double notaConv2 = lector.nextDouble();
                        notasConv2Map.put(apellido, notaConv2);

                        while (notaConv2 > 100 || notaConv2 < 0) {
                            System.out.println(" ");
                            System.out.println("La nota que ha ingresado es incorrecta, por favor intente de nuevo");
                            System.out.println("Nota de primer convocatoria del estudiante " + (i + 1) + "(Maximo 100.00) ");
                            notaConv2 = lector.nextDouble();
                            notasConv2Map.put(apellido, notaConv2);
                        }
                    }
                }

                System.out.println(" ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Se ha producido una excepción, por favor ingrese un número: " + e.getMessage());
        }

        System.out.println(" ");
        System.out.println("Acta de Notas: ");
        System.out.println("No." + " Carnet " + " Apellidos y Nombres " + "      I P " + "      II P " + "     SIST " + "      N.F. " + "   EXA I CONV " + "   N.F.I CONV " + "   II CONV");
        System.out.println(" ");
        int contador = 1;
        for (String apellido : apellidosMap.keySet()) {
            String nombreEstudiante = apellidosMap.get(apellido);
            double notaEstudiante = notasMap.get(apellido);
            double notaEstudiante2 = notas2Map.get(apellido);
            double notaSistematico = notasSistMap.get(apellido);
            double notaFinal = notaTotalMap.get(apellido);

            double notaConvo1 = 0;
            if (notasConv1Map.containsKey(apellido)) {
                notaConvo1 = notasConv1Map.get(apellido);
            }

            double notaFinalConvo1 = 0;
            if (notaFinal1Map.containsKey(apellido)) {
                notaFinalConvo1 = notaFinal1Map.get(apellido);
            }

            double notaConvo2 = 0;
            if (notasConv2Map.containsKey(apellido)) {
                notaConvo2 = notasConv2Map.get(apellido);
            }

            String carnetEst = numCarnetsMap.get(apellido);
            System.out.println(contador + " | " + carnetEst + " | " + apellido + " | " + nombreEstudiante + " | " + notaEstudiante + " | " + notaEstudiante2 + " | " + notaSistematico + " | " + notaFinal + " | " + notaConvo1 + " | " + notaFinalConvo1 + " | " + notaConvo2);
            contador++;
        }

        
        System.out.println(" ");
        int matriculaInicial = cantEst;
        int deserciones;
        
        System.out.println("Ingrese la cantidad de estudiantes que desertaron: ");
        deserciones = lector.nextInt();
        
        int matriculaEfectiva = matriculaInicial - deserciones;
        int aprobados = 0;
        for (double nota : notaTotalMap.values()) {
            if (nota >= 60) {
                aprobados++;
            }
        }
        int reprobados = matriculaEfectiva - aprobados;
        double porcentajeAprobados = (aprobados * 100.0) / matriculaEfectiva;
        double porcentajeReprobados = (reprobados * 100.0) / matriculaEfectiva;

        double notaMinima = notaTotalMap.values().stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        double notaMaxima = notaTotalMap.values().stream().mapToDouble(Double::doubleValue).max().orElse(0.0);

        double sumaNotas = notaTotalMap.values().stream().mapToDouble(Double::doubleValue).sum();
        double promedioNotas = sumaNotas / matriculaEfectiva;

        System.out.println("Reporte de Matrícula:");
        System.out.print("Matrícula Inicial: " + matriculaInicial + " | ");
        System.out.print("Matrícula Efectiva: " + matriculaEfectiva + " | ");
        System.out.print("Número de Deserciones: " + deserciones + " | ");
        System.out.print("Cantidad de Aprobados: " + aprobados + " (" + porcentajeAprobados + "%) | ");
        System.out.print("Cantidad de Reprobados: " + reprobados + " (" + porcentajeReprobados + "%) | ");
        System.out.print("Nota Mínima: " + notaMinima + " | ");
        System.out.print("Nota Máxima: " + notaMaxima + " | ");
        System.out.print("Promedio de Notas: " + promedioNotas);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Acciones:");
            System.out.println("1. Ordenar notas");
            System.out.println("2. Buscar notas");
            System.out.println("3. Mostrar y graficar rangos de notas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    ordenarNotas(notasMap, notasConv1Map, notasConv2Map);
                    break;
                case 2:
                    buscarNotas(notasMap, notasConv1Map, notasConv2Map);;
                    break;
                case 3:
                    mostrarRangosNotas(notaTotalMap);;
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
        lector.close();        
    }  

    private static void ordenarNotas(TreeMap<String, Double> notasMap, TreeMap<String, Double> notasConv1Map, TreeMap<String, Double> notasConv2Map) {
        Scanner lector = new Scanner(System.in);
    
        System.out.println("Seleccione cómo desea ordenar las notas:");
        System.out.println("1. Por nota final");
        System.out.println("2. Por nota final después de primera convocatoria");
        System.out.println("3. Por nota final después de segunda convocatoria");
        System.out.print("Ingrese la opción: ");
        int opcion = lector.nextInt();
    
        TreeMap<String, Double> notasOrdenadas = new TreeMap<>();
    
        switch (opcion) {
            case 1:
                notasOrdenadas = ordenarSegunNota(notasMap);
                break;
            case 2:
                notasOrdenadas = ordenarSegunNota(notasConv1Map);
                break;
            case 3:
                notasOrdenadas = ordenarSegunNota(notasConv2Map);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }
    
        System.out.println("Notas ordenadas:");
        for (String apellido : notasOrdenadas.keySet()) {
            System.out.println(apellido + ": " + notasOrdenadas.get(apellido));
        }
    }
    
    private static TreeMap<String, Double> ordenarSegunNota(TreeMap<String, Double> map) {
        TreeMap<String, Double> notasOrdenadas = new TreeMap<>((o1, o2) -> {
            double diff = map.get(o1) - map.get(o2);
            if (diff > 0) return 1;
            if (diff < 0) return -1;
            return o1.compareTo(o2);
        });
    
        notasOrdenadas.putAll(map);
        return notasOrdenadas;
    }

    private static void buscarNotas(TreeMap<String, Double> notasMap, TreeMap<String, Double> notasConv1Map, TreeMap<String, Double> notasConv2Map) {
        Scanner lector = new Scanner(System.in);
    
        System.out.println("Seleccione cómo desea buscar las notas:");
        System.out.println("1. Por nota final");
        System.out.println("2. Por nota final después de primera convocatoria");
        System.out.println("3. Por nota final después de segunda convocatoria");
        System.out.print("Ingrese la opción: ");
        int opcion = lector.nextInt();
    
        double notaBuscada = 0.0;
        switch (opcion) {
            case 1:
                System.out.print("Ingrese la nota final a buscar: ");
                notaBuscada = lector.nextDouble();
                buscarNotaEspecifica(notasMap, notaBuscada);
                break;
            case 2:
                System.out.print("Ingrese la nota final después de primera convocatoria a buscar: ");
                notaBuscada = lector.nextDouble();
                buscarNotaEspecifica(notasConv1Map, notaBuscada);
                break;
            case 3:
                System.out.print("Ingrese la nota final después de segunda convocatoria a buscar: ");
                notaBuscada = lector.nextDouble();
                buscarNotaEspecifica(notasConv2Map, notaBuscada);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
    
    private static void buscarNotaEspecifica(TreeMap<String, Double> map, double notaBuscada) {
        boolean encontrado = false;
        System.out.println("Estudiantes con la nota buscada:");
        for (String apellido : map.keySet()) {
            if (map.get(apellido).equals(notaBuscada)) {
                System.out.println(apellido + ": " + notaBuscada);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron estudiantes con esa nota.");
        }
    }

    private static void mostrarRangosNotas(TreeMap<String, Double> notaTotalMap) {
        int reprobados = 0, regulares = 0, buenos = 0, muyBuenos = 0, excelentes = 0;
    
        for (double nota : notaTotalMap.values()) {
            if (nota >= 0 && nota < 60) {
                reprobados++;
            } else if (nota >= 60 && nota < 70) {
                regulares++;
            } else if (nota >= 70 && nota < 80) {
                buenos++;
            } else if (nota >= 80 && nota < 90) {
                muyBuenos++;
            } else {
                excelentes++;
            }
        }

        System.out.println("Rangos de Notas:");
        System.out.println("Reprobados (0 - 59): " + reprobados);
        System.out.println("Regulares (60 - 69): " + regulares);
        System.out.println("Buenos (70 - 79): " + buenos);
        System.out.println("Muy Buenos (80 - 89): " + muyBuenos);
        System.out.println("Excelentes (90 - 100): " + excelentes);
    }
}