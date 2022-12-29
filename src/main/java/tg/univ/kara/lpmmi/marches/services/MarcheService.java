package tg.univ.kara.lpmmi.marches.services;

import org.springframework.stereotype.Component;
import tg.univ.kara.lpmmi.marches.model.Marche;
import java.util.List;

@Component
public interface MarcheService {

    public List<Marche> getMarches();
    public Marche findById(Integer id);
    public Marche addMarche(Marche marche);
    public Marche updateMarche(Integer id, Marche marche);
    public Marche deleteMarche(Integer id);

}
