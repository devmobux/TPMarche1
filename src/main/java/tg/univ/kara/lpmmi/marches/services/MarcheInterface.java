package tg.univ.kara.lpmmi.marches.services;

import tg.univ.kara.lpmmi.marches.model.Marche;
import java.util.List;

public interface MarcheInterface {

    public List<Marche> getMarches();
    public Marche findById(int id);

}
