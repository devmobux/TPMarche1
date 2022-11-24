package tg.univ.kara.lpmmi.marches.services;

import org.springframework.stereotype.Component;
import tg.univ.kara.lpmmi.marches.model.Marche;
import java.util.List;

@Component
public interface MarcheInterface {

    public List<Marche> getMarches();
    public Marche findById(Integer id);

}
