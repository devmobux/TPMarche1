package tg.univ.kara.lpmmi.marches.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tg.univ.kara.lpmmi.marches.model.Marche;
import tg.univ.kara.lpmmi.marches.repository.MarcheRepository;
import java.util.List;

@Component
public class MarcheServiceImpl implements MarcheService {

    @Autowired
    private MarcheRepository marcheRepository;

    public List<Marche> getMarches() {
        return marcheRepository.findAll();
    }

    public Marche findById(Integer id) {
        return marcheRepository.findById(id).orElse(null);
    }

    @Override
    public Marche addMarche(Marche marche) {
        return marcheRepository.save(marche);
    }

    @Override
    public Marche updateMarche(Integer id, Marche marche) {
        Marche marcheToUpdate = marcheRepository.findById(id).orElse(null);
        if (marcheToUpdate != null) {
            marcheToUpdate.setNom(marche.getNom());
            marcheToUpdate.setEmplacement(marche.getEmplacement());
            marcheToUpdate.setCategorie(marche.getCategories());
            marcheToUpdate.setHeureFermeture(marche.getHeureFermeture());
            marcheToUpdate.setHeureOuverture(marche.getHeureOuverture());
            marcheToUpdate.setNbreHangars(marche.getNbreHangars());
            marcheRepository.save(marcheToUpdate);
        }
        return marcheToUpdate;
    }

    @Override
    public Marche deleteMarche(Integer id) {
        Marche marcheToDelete = marcheRepository.findById(id).orElse(null);
        if (marcheToDelete != null) {
            marcheRepository.delete(marcheToDelete);
        }
        return marcheToDelete;
    }

}
