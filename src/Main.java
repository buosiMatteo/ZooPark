import User.User;
import ZooPark.*;
import Exception.*;

import java.time.LocalTime;

/*
    Creare un programma Java che possa gestire una serie di giardini zoologici

    Ogni parco deve poter contenere:
    -orario di apertura
    -numero di animali max (capienza)
    -deve indicare quali sezioni/spazi sono presenti fra questi 3:
        - RecintoAcquatico (può contenere solo animali acquatici)
        - RecintoVolatili (può contenere solo volatili)
        - RecintoStandard (può contenere il resto degli animali)
    -ogni sezione/spazio deve specificare:
        -lista degli animali presenti
        -orario di apertura del recinto (OGNI ZOO DEVE AVERE ORARI DIVERSI)

    Il programma  deve consentire ad un utente di consultare il registro di questi parchi per:
    1)	Cercare quali zoo contengono un certo tipo di animale
    2)	Selezionare uno zoo per capire se è aperto in questo momento
    3)	Cercare in modo specifico un certo animale in un certo zoo
    4)	Richiedere la possibilità di visitare un certo animale in un certo zoo all’interno di un recinto in questo momento
    5)	Stampare lista degli animali presenti in un certo zoo
    6)	Stampare lista degli animali presenti in un certo zoo per un certo sezione/spazio richiesto
 */
public class Main {
    public static void main(String[] args) {
        ZooPark zoo1 = new ZooPark("zoo1", LocalTime.of(7,30,0), LocalTime.of( 18, 0,0), 10);
        ZooPark zoo2 = new ZooPark("zoo2", LocalTime.of( 7, 0,0), LocalTime.of( 19, 0,0), 20);
        Section standard = new Section(TypeOfSection.STANDARD, LocalTime.of(7, 30, 0), LocalTime.of( 12, 30,0));
        Section winged = new Section(TypeOfSection.WINGED, LocalTime.of(10, 30, 0), LocalTime.of( 18, 30,0));
        Section acquatic = new Section(TypeOfSection.ACQUATIC, LocalTime.of(7, 30, 0), LocalTime.of( 18, 30,0));
        Animals scimmia = new Animals("Scimmia", 10, TypeOfSection.STANDARD);
        Animals aquila = new Animals("Aquila", 15, TypeOfSection.WINGED);
        Animals coccodrillo = new Animals("Coccodrillo", 50, TypeOfSection.ACQUATIC);
        Animals rinoceronte = new Animals("Rinoceronte", 100, TypeOfSection.STANDARD);
        try{
            zoo1.aggiungiSezione(standard).aggiungiAnimale(scimmia);
            zoo1.aggiungiSezione(winged).aggiungiAnimale(aquila);
            zoo1.aggiungiSezione(acquatic).aggiungiAnimale(coccodrillo);
            zoo1.aggiungiSezione(standard).aggiungiAnimale(rinoceronte);
            zoo2.aggiungiSezione(standard).aggiungiAnimale(scimmia);
        }catch (AnimalNotBelongsToSectionException e){
            System.out.println(e.getMessage());
        }
        try {
            zoo1.aggiungiSezione(winged).aggiungiAnimale(scimmia);          //throws exception
        } catch (AnimalNotBelongsToSectionException e){
            System.out.println(e.getMessage());
        }
        User user = new User();
        System.out.printf("The animal\n %s\n is located in \n %s",scimmia,user.cercaAnimale(scimmia).toString());                                 // task 1
        user.printAnimalInAZooParkForSection(zoo1, standard);                           // task 6
        user.isThatZooOpen(zoo1);                                                       // task 2
        user.findAnimalInZooPark(zoo1, aquila);                                         // task 3
        user.printAnimalInAZooPark(zoo1);                                               // task 5
        user.visitAnimalInASection(zoo2, standard, scimmia);                            // task 4
        user.findAnimalInZooPark(zoo2,aquila);                                          // task 3 with exception
    }
}