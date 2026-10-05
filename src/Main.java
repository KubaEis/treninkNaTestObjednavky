void main() throws IOException {
    Validator val =  new Validator();
    List<Objednavka> obj = new ArrayList<>();
    Path objednavky = Path.of("data", "trenink_objednavky_testovaci_data.txt");
    //Path piloti = Path.of("data", "trenink_piloti_testovaci_data.txt");

    if (!Files.exists(objednavky.getParent())) {
        Files.createDirectories(objednavky.getParent());
    }
    /*if (!Files.exists(piloti.getParent())) {
        Files.createDirectories(piloti.getParent());
    }*/

    /*String textObjednavky = Files.readString(objednavky);
    System.out.println(Files.readString(objednavky));*/

    /*String textPiloti = Files.readString(piloti);
    System.out.println(Files.readString(piloti));*/

    try {
        // Otevření BufferedWriter v try-with-resources
        try (BufferedReader objednavkyReader = Files.newBufferedReader(objednavky))
             //BufferedReader pilotiReader = Files.newBufferedReader(piloti))
        {
            String[] radkyObjednavky = objednavkyReader.lines().toArray(String[]::new);
            for (int i=0; i<radkyObjednavky.length; i++) {

                if (val.jePlatnyRadek(radkyObjednavky[i])){
                    System.out.println("===== VALIDNI RADEN: "+i+" ["+radkyObjednavky[i]+"]=====");
                    String[] radka = radkyObjednavky[i].split(";");
                    obj.add(new Objednavka(radka[0],radka[1],radka[2],Double.parseDouble(radka[3].replace(",", ".")),Integer.parseInt(radka[4])));
                    System.out.println("Radek nacten do objektu.\n");

                }else{
                    System.out.println("===== NEVALIDNI RADEN: "+i+" ["+radkyObjednavky[i]+"]=====\n");
                }

                /*if (radka.length != 5) {
                    System.out.println("Nevalidni radek: "+i+" ["+radkyObjednavky[i]+"]");
                }else{
                    System.out.println("Validni radek: "+i+" ["+radkyObjednavky[i]+"]");

                    obj.add(new Objednavka(radka[0],radka[1],radka[2],Double.parseDouble(radka[3].replace(",", ".")),Integer.parseInt(radka[4])));
                    System.out.println("Radek nacten do objektu.");
                }*/
            }
        }
    } catch (IOException e) {
        System.out.println("Chyba při čtení souboru:");
        e.printStackTrace();
    }


    double celkovaCena = 0;
    int pocetMysi = 0;
    int pocetKlavesnic = 0;
    int pocetMonitoru = 0;
    int pocetGrafickychKaret = 0;

    for (int i = 0; i< obj.size(); i++) {
        celkovaCena += obj.get(i).getCena() * obj.get(i).getPocetKusu();
        if (obj.get(i).getProdukt().equals("Herní myš")){
            pocetMysi += obj.get(i).getPocetKusu();
        }
        if (obj.get(i).getProdukt().equals("Klávesnice")){
            pocetKlavesnic += obj.get(i).getPocetKusu();
        }
        if (obj.get(i).getProdukt().equals("Monitor")){
            pocetMonitoru += obj.get(i).getPocetKusu();
        }
        if (obj.get(i).getProdukt().equals("Grafická karta")){
            pocetGrafickychKaret += obj.get(i).getPocetKusu();
        }

    }

    System.out.println("=====STATICTIKY=====");
    System.out.println("Pocet platnych objednavek: "+obj.size());
    System.out.println("Celkova cena vsech produktu: "+celkovaCena+" kč");
    System.out.println("Pocet objednanych hernich mysi: "+pocetMysi+" ks");
    System.out.println("Pocet objednanych klavesnici: "+pocetKlavesnic+" ks");
    System.out.println("Pocet objednanych monitoru: "+pocetMonitoru+" ks");
    System.out.println("Pocet objednanych grafickych karet: "+pocetGrafickychKaret+" ks");

    System.out.println("\n=====PLATNE OBJEDNAVKY=====");
    for (int i=0; i<obj.size(); i++) {
        System.out.println(obj.get(i).toString());
    }
}
