import User.User;
import ZooPark.*;
import Exception.*;

import java.time.LocalDateTime;

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
    public static void main(String[] args) throws SectionNotAvailableException {
        ZooPark zoo1 = new ZooPark("zoo1", LocalDateTime.of(2000, 7, 13, 7, 0), LocalDateTime.of(2025, 7, 13, 18, 0), 10);
        Section standard = new Section(TypeOfSection.STANDARD, LocalDateTime.of(2000, 7, 13, 7, 0), LocalDateTime.of(2025, 7, 13, 18, 0));
        Section volatili = new Section(TypeOfSection.VOLATILI, LocalDateTime.of(2000, 7, 13, 7, 0), LocalDateTime.of(2025, 7, 13, 18, 0));
        Section acquatici = new Section(TypeOfSection.AQUATICI, LocalDateTime.of(2000, 7, 13, 7, 0), LocalDateTime.of(2025, 7, 13, 18, 0));
        zoo1.aggiungiSezione(standard);
        zoo1.aggiungiSezione(volatili);
        zoo1.aggiungiSezione(acquatici);
        Animals scimmia = new Animals("Scimmia", 10, TypeOfSection.STANDARD);
        Animals aquila = new Animals("Aquila", 15, TypeOfSection.VOLATILI);
        Animals coccodrillo = new Animals("Coccodrillo", 50, TypeOfSection.AQUATICI);
        Animals rinoceronte = new Animals("Rinoceronte", 100, TypeOfSection.STANDARD);
        try {
            zoo1.selezionaSezione(standard).aggiungiAnimale(scimmia);
            zoo1.selezionaSezione(standard).aggiungiAnimale(aquila);
            zoo1.selezionaSezione(acquatici).aggiungiAnimale(coccodrillo);
            zoo1.selezionaSezione(volatili).aggiungiAnimale(rinoceronte);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        User user = new User();
        System.out.println(user.cercaAnimale(scimmia));
        user.printAnimalInAZooParkForSection(zoo1, standard);
        System.out.println(user.isThatZooOpen(zoo1));
        System.out.println(user.findAnimalInZooPark(zoo1, aquila));
        user.printAnimalInAZooPark(zoo1);
    }
}