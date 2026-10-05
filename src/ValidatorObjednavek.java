import java.util.regex.Pattern;

public class ValidatorObjednavek {

    // Regulární výrazy pro jednotlivá pole
    private Pattern patternJmeno = Pattern.compile("^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]+\\s+[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]+$");
    private Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private Pattern patternProdukt = Pattern.compile("^Herní myš$|^Klávesnice$|^Monitor$|^Grafická karta$");
    private Pattern patternCena = Pattern.compile("^([0-9]+),([0-9]{2})$");
    private Pattern patternPocetKusu = Pattern.compile("^([1-9]{1})$|^(10)$");

    boolean jePlatnyRadek(String radek) {
        if (radek == null || radek.trim().isEmpty()) {
            System.out.println("Chyba: Prázdný řádek!");
            return false;
        }

        // Parametr -1 zajistí, že split nevymaže prázdné hodnoty na konci řádku
        String[] udaje = radek.split(";", -1);

        if (udaje.length != 5) {
            System.out.println("Chyba: Špatný počet údajů (očakáváno 5, nalezeno " + udaje.length + ")");
            return false;
        }

        boolean jeVseOk = true;

        String jmeno = udaje[0].trim();
        String email = udaje[1].trim();
        String produkt = udaje[2].trim();
        String cena = udaje[3].trim();
        String pocetKusu = udaje[4].trim();

        if (!patternJmeno.matcher(jmeno).matches()) {
            System.out.println("Neplatné jméno a příjmení: " + jmeno);
            jeVseOk = false;
        }

        if (!patternEmail.matcher(email).matches()) {
            System.out.println("Neplatný e-mail: " + email);
            jeVseOk = false;
        }

        if (!patternProdukt.matcher(produkt).matches()) {
            System.out.println("Neplatný produkt: " + produkt);
            jeVseOk = false;
        }

        if (!patternCena.matcher(cena).matches()) {
            System.out.println("Neplatna cena: " + cena);
            jeVseOk = false;
        }

        if (!patternPocetKusu.matcher(pocetKusu).matches()) {
            System.out.println("Neplatny pocet kusu: " + pocetKusu);
            jeVseOk = false;
        }

        return jeVseOk;
    }
}