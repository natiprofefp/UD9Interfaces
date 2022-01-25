package ud9;

public class Main {

    public static void main(String[] args) {

        System.out.println(Sonido.version);
        System.out.println(Perro.version);

        Sonido son1 = new Gato();
        son1.voz();         // Miau!
        Sonido son2 = new Perro();
        son2.voz();         // Guau!

       /*  Sonido son3 = new Sonido() {
            @Override
            public void voz() {
                System.out.println("sonido sin definir!!!");
            }
        };  */

        Sonido son3 = () -> System.out.println("sonido sin definir!!!");
    }
}
