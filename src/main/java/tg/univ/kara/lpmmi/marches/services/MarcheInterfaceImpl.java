package tg.univ.kara.lpmmi.marches.services;

import tg.univ.kara.lpmmi.marches.model.Categories_Enum;
import tg.univ.kara.lpmmi.marches.model.Marche;

import java.util.ArrayList;
import java.util.List;

public class MarcheInterfaceImpl implements MarcheInterface {

    private List<Marche> marches;

    public MarcheInterfaceImpl() {
        marches = new ArrayList<Marche>();

        var c1 = new ArrayList<Categories_Enum>();
        c1.add(Categories_Enum.TECHNOLOGIE);
        c1.add(Categories_Enum.MEDECINE);
        c1.add(Categories_Enum.COSMETIQUE);
        c1.add(Categories_Enum.ALIMENTATION);
        var m1 = new Marche(1, "Kozah", "6h00", "20h00", 150, c1,"Kara");

        var c2 = new ArrayList<Categories_Enum>();
        c2.add(Categories_Enum.TECHNOLOGIE);
        c2.add(Categories_Enum.MEDECINE);
        c2.add(Categories_Enum.COSMETIQUE);
        c2.add(Categories_Enum.ALIMENTATION);
        var m2 = new Marche(2, "Binah", "6h00", "22h00", 50, c1,"Pagouda");

        marches.add(m1);
        marches.add(m2);
    }

    public List<Marche> getMarches() {
        return marches;
    }

    public Marche findById(int id) {
        return marches.stream().filter(m -> m.getId() == id)
                               .findFirst()
                               .orElse(null);
    }

}
