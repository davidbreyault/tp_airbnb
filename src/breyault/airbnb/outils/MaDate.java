package breyault.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {

    /**
     *
     * @param year L'année
     * @param month Le mois (entre 1 et 12)
     * @param date La date (entre 1 et 31)
     */
    public MaDate(int year, int month, int date) {
        super(year - 1900, month - 1, date);
    }

    @Override
    public String toString() {
        return (this.getDate() < 10? "0" : "") + this.getDate()
                + "/" + ((this.getMonth() + 1) < 10 ? "0" : "") + (this.getMonth() + 1)
                + "/" + (this.getYear() + 1900);
    }
}
