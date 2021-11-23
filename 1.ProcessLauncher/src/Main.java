import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // El progrma no funcionaria en otro ordenador ya que es una ruta
        // directa a un archivo de mi ordenador, pero creo que querias esto en el ejercicio

        String path1 = "C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
        String[] path2 = {"C:\\Users\\Raul\\Desktop\\Raul\\Estudios\\Grado Superior DAM\\Grado Superior DAM 2\\Interfaces\\Analisi Web - Raul Moreta Martin.pdf"};


        ProcessLauncher processLauncher = new ProcessLauncher();

        for (int i = 0; i < path2.length; i++) {
            System.out.println(i + ". " + path2[i]);
        }
        System.out.println("Que programa quieres ejecutar: ");

        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt();

        Process process = processLauncher.launch(path1, path2[seleccion]);
        System.out.printf("Lanzado el proceso %s", process);

    }
}
