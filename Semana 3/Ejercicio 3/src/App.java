import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();


        System.out.println("--- Persona 1 ---");

        System.out.print("Nombre: ");
        p1.setNombre(sc.nextLine());

        System.out.print("Altura (m): ");
        p1.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p1.setPeso(sc.nextDouble());

        sc.nextLine();


        System.out.println("--- Persona 2 ---");

        System.out.print("Nombre: ");
        p2.setNombre(sc.nextLine());

        System.out.print("Altura (m): ");
        p2.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p2.setPeso(sc.nextDouble());

        sc.nextLine();


        System.out.println("--- Persona 3 ---");

        System.out.print("Nombre: ");
        p3.setNombre(sc.nextLine());

        System.out.print("Altura (m): ");
        p3.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p3.setPeso(sc.nextDouble());

        sc.nextLine();

        
        Person masAlto = p1;

        if (p2.getAltura() > masAlto.getAltura()) {
            masAlto = p2;
        }

        if (p3.getAltura() > masAlto.getAltura()) {
            masAlto = p3;
        }

        
        Person masPesado = p1;

        if (p2.getPeso() > masPesado.getPeso()) {
            masPesado = p2;
        }

        if (p3.getPeso() > masPesado.getPeso()) {
            masPesado = p3;
        }

        

        System.out.println();
        System.out.println("--- Resultados ---");

        System.out.println("El más alto es " + masAlto.getNombre()
                + " con " + masAlto.getAltura() + " m");

        System.out.println("El que más pesa es " + masPesado.getNombre()
                + " con " + masPesado.getPeso() + " kg");

    
                
        System.out.println();
        System.out.println("--- IMC ---");

        if (p1.calcularIMC() == -1) {
            System.out.println(p1.getNombre() + ": no se puede calcular el IMC");
        } else {
            System.out.println(p1.getNombre() + ": " + p1.calcularIMC());
        }

        if (p2.calcularIMC() == -1) {
            System.out.println(p2.getNombre() + ": no se puede calcular el IMC");
        } else {
            System.out.println(p2.getNombre() + ": " + p2.calcularIMC());
        }

        if (p3.calcularIMC() == -1) {
            System.out.println(p3.getNombre() + ": no se puede calcular el IMC");
        } else {
            System.out.println(p3.getNombre() + ": " + p3.calcularIMC());
        }

        sc.close();
    }
}