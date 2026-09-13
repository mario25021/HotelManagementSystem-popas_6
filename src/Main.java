import java.util.Scanner;

public class Main {

    static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args)
    {

        Room room1 = new Room(101, "single", 150, false);
        Room room2 = new Room(102, "double", 250);
        Room room3 = new Room(103, "Suite", 400, false);
        Room room4 = new Room(104, "double", 325, true);

        boolean terminat=true;

        Room[] rooms ={room1,room2,room3,room4};

        while(terminat){
        meniu();
        int alegere=scanner.nextInt();

        switch(alegere)
        {
            case 1->afisareCamere(rooms);
            case 2->{
                System.out.println("Alege camera de o cauti");
                int numar= scanner.nextInt();
                cautaCamera(rooms, numar);
            }
            case 3->{
                System.out.println("ce camera vrei sa rezervi?");
                int rezervare= scanner.nextInt();
                rezervaCamera(rooms,rezervare);
            }
            case 4->{
                System.out.println("Ce camera vrei sa eliberezi?");
                int eliberare= scanner.nextInt();
                eliberareCamera(rooms,eliberare);
            }
            case 5 -> camereLibere(rooms);

            case 6-> terminat=false;

            case 7->Room.Camere();

            case 8->{
                System.out.println("ce tip de camera cauti?");
                scanner.nextLine();
                String tip=scanner.nextLine();
                cautaTipCamera(rooms,tip);
            }

            case 9->{
                System.out.println("Ce camera vrei sa inchiriezi?");
                int numar= scanner.nextInt();
                System.out.println("Cate nopti vrei sa o inchiriezi?");
                int nopti= scanner.nextInt();
                double pret=pret(rooms,numar,nopti);
                System.out.println("Pretul va fi: " + pret);
            }


            default-> System.out.println("Invalid, mai alege o data");
        }

        }
        System.out.println("Multumesc ca ne ati ales service ul, La revedere!");


    }

    static void meniu()
    {
        System.out.println("===== HOTEL MANAGEMENT SYSTEM =====\n" +
                "\n" +
                "1. Afiseaza camerele\n" +
                "2. Cauta camera\n" +
                "3. Rezerva camera\n" +
                "4. Elibereaza camera\n" +
                "5. Afiseaza camerele libere\n" +
                "6. Exit \n"+
                "7. Numarul total camere \n"+
                "8. Cauta tipul de camera \n"+
                "9. Nopti si plata\n"
                +"tu alegi: ");
    }

    static void afisareCamere(Room[] rooms)
    {
        for(int i=0;i<rooms.length;i++)
        {
            rooms[i].afisareCamere();
        }
    }

    static void cautaCamera(Room[] rooms, int numar)
    {
        for(int i=0;i< rooms.length;i++)
        {
            if(numar==rooms[i].roomNumber)
            {
                rooms[i].afisareCamere();
                return;
            }
        }
        System.out.println("camera nu exista");

    }

    static void rezervaCamera(Room[] rooms, int rezervare)
    {

        for(int i=0;i< rooms.length;i++)
        {
            if(rooms[i].roomNumber==rezervare)
            {
                if(rooms[i].occupied==false)
                {
                    System.out.println("Tocmai ati rezervat camera: " + rezervare);
                    rooms[i].occupied=true;
                    return;
                }
                else
                {
                    System.out.println("Camera este deja rezervata");
                    return;
                }

            }

        }
        System.out.println("Camera nu este valabila");

     }

     static void eliberareCamera(Room[] rooms, int eliberare)
     {
         for(int i=0;i<rooms.length;i++)
         {
             if(rooms[i].roomNumber==eliberare)
             {
                 if(rooms[i].occupied)
                 {
                     System.out.println("Tocmai ai eliberat camera: " + eliberare);
                     rooms[i].occupied=false;
                     return;
                 }
                 else
                 {
                     System.out.println("Camera este deja eliberata");
                     return;
                 }
             }
         }
         System.out.println("Camera nu este valabila");
     }

     static void camereLibere(Room[] rooms)
     {
         boolean exista=false;
         for(int i =0; i< rooms.length;i++)
         {
             if(rooms[i].occupied==false)
             {
                 exista=true;
             }
         }

         if(exista)
         {
             System.out.println("Camerele libere sunt");
             for(int i =0; i< rooms.length;i++)
             {
                 if(rooms[i].occupied==false)
                 {
                     System.out.println(rooms[i].roomNumber);
                 }
             }
         }
         else
         {
             System.out.println("Nu mai sunt camere libere");
         }

     }

     static void cautaTipCamera(Room[] rooms, String tip)
     {
         boolean exista1=false;
         for(int i =0; i< rooms.length;i++)
         {
             if(rooms[i].type.equals(tip))
             {
                 exista1=true;
             }
         }

         if(exista1)
         {
             System.out.printf("Camerele %s sunt: ", tip);
             for(int i =0; i< rooms.length;i++)
             {
                 if(rooms[i].type.equals(tip))
                 {
                     System.out.print(rooms[i].roomNumber+ " ");
                 }
             }
             System.out.println("\n");
         }
         else
         {
             System.out.println("Nu sunt camere " + tip);
         }

     }

     static double pret(Room[] rooms, int numar, int nopti)
     {
         for(int i=0;i<rooms.length;i++)
         {
             if(rooms[i].roomNumber==numar)
             {
                 if(rooms[i].occupied==false)
                 {
                     return rooms[i].price*nopti;
                 }
                 else
                 {
                     System.out.println("camera este ocupata");
                     return 0;
                 }
             }

         }

         System.out.println("nu exista camera");
         return 0;

     }

}
