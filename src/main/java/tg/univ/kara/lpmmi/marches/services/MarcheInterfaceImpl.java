package tg.univ.kara.lpmmi.marches.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tg.univ.kara.lpmmi.marches.model.Marche;
import tg.univ.kara.lpmmi.marches.repository.MarcheRepository;
import java.util.List;

@Component
public class MarcheInterfaceImpl implements MarcheInterface {

    @Autowired
    private MarcheRepository marcheRepository;

    public List<Marche> getMarches() {
        return marcheRepository.findAll();
    }

    public Marche findById(Integer id) {
        return marcheRepository.findById(id).orElse(null);
    }

}
