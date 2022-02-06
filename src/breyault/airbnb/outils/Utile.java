package breyault.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utile {

    // Attribut privé constant pour être créé qu'une seule fois.
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    // Constructeur privé pour ne pas créer d'instance de cette classe Utile
    private Utile() {
        throw new AssertionError();
    }

    /**
     * Méthode permettant de créer un objet de type Date correctement formaté.
     * @param year L'année
     * @param month Le mois (entre 1 et 12)
     * @param day Le jour (entre 1 et 31)
     * @return
     */
    public static Date buildDateObject(int year, int month, int day) {
        return new Date(year - 1900, month - 1, day);
    }

    /**
     * Méthode permettant de renvoyer une chaîne de caractère au format dd/MM/yyyy
     * @param date Un objet de type Date
     * @return
     */
    public static String buildDateString(Date date) {
        return
                date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate() + "/"
                + (date.getMonth() < 10 ? ("0" + date.getMonth()) : date.getMonth())  + "/"
                + (date.getYear());
    }

    /**
     * Méthode permettant de retourner une chaîne de caractères au format indiqué par le pattern de l'objet SimpleDateFormat
     * @param date Un objet de type Date
     * @return
     */
    public static String buildDateStringBis(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
