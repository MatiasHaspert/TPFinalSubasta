import java.io.Serializable;
import java.util.Scanner;

public class Subastador extends Usuario implements Serializable {

    public Subastador(){super("","", Rol.SUBASTADOR);}
    public Subastador(String nombre, String email) {
        super(nombre, email, Rol.SUBASTADOR);
    }

    public Articulo generarArticuloASubastar(){
        Scanner scanner = new Scanner(System.in);
        String nombreArticulo;
        String descripcionArticulo;
        System.out.println("Ingrese el nombre del articulo: ");
        do{
            nombreArticulo = scanner.nextLine();
            if(nombreArticulo.length() < 3){
                System.out.println("El nombre del articulo debe tener al menos 3 caracteres");
            }
        }while(nombreArticulo.length() < 3);

        System.out.println("Ingrese la descripcion del articulo: ");
        do{
            descripcionArticulo = scanner.nextLine();
            if(descripcionArticulo.length() < 10){
                System.out.println("La descripcion del articulo debe tener al menos 10 caracteres");
            }
        }while(descripcionArticulo.length() < 10);

        float precioBaseArticulo = 0;
        boolean precioValido = false;
        System.out.println("Ingrese el precio base del articulo (Debe ser mayor a 0): ");
        do{
            try{
                precioBaseArticulo = Float.parseFloat(scanner.nextLine());
                if(precioBaseArticulo > 0){
                    precioValido = true;
                }else{
                    System.out.println("Debes ingresar un valor mayor a 0. Intente nuevamente");
                }
            }catch(NumberFormatException e){
                System.out.println("Debes ingresar un numero válido. Intente nuevamente");
            }
        }while(!precioValido);

        return new Articulo(nombreArticulo,descripcionArticulo,precioBaseArticulo);
    }

    public int fijarTiempoSubasta(){
        Scanner scanner = new Scanner(System.in);
        int tiempoEnSegundos = 0;
        boolean tiempoValido = false;
        System.out.print("Ingrese el tiempo para la subasta (en segundos, entre 20 y 120): ");
        do{
            try {
                System.out.print("Ingrese el tiempo para la subasta (en segundos, entre 20 y 120): ");
                tiempoEnSegundos = Integer.parseInt(scanner.nextLine());
                if (tiempoEnSegundos >= 20 && tiempoEnSegundos <= 120) {
                    tiempoValido = true;
                } else {
                    System.out.println("El tiempo debe estar entre 30 y 120 segundos. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número valido. Intente nuevamente.");
            }
        }while(!tiempoValido);

        return tiempoEnSegundos;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\n" +
                            "Email: %s \n",
                            this.getNombre(), this.getEmail());
    }
}
