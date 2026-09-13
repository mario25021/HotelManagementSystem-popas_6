public class Room {

    int roomNumber;
    String type;
    double price;
    boolean occupied;
    static int numarDeCamere;

    Room(int roomNumber, String type, double price, boolean occupied)
    {
        this.roomNumber=roomNumber;
        this.type=type;
        this.price=price;
        this.occupied=occupied;
        numarDeCamere++;
    }

    Room(int roomNumber, String type, double price)
    {
        numarDeCamere++;
        this.roomNumber=roomNumber;
        this.type=type;
        this.price=price;
        this.occupied=true;
    }

    void afisareCamere(){

        System.out.println("camera: " +this.roomNumber);
        System.out.println("Tip: " +this.type);
        System.out.println("Pret: " +this.price);
        System.out.println("Status: " +this.occupied + "\n");
    }


    static void Camere()
    {
        System.out.println("numarul de camere este " + numarDeCamere);
    }


}
