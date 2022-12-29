package tg.univ.kara.lpmmi.marches.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Marche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String emplacement;
    private String heureOuverture;
    private String heureFermeture;
    private int nbreHangars;
    @ElementCollection(targetClass = Categories_Enum.class, fetch = FetchType.EAGER)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private Collection<Categories_Enum> categories;
    private String nom;

    public Marche(Integer id, String emplacement, String heureOuverture, String heureFermeture, int nbreHangars, Collection<Categories_Enum> categories, String nom) {
        this.id = id;
        this.emplacement = emplacement;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.nbreHangars = nbreHangars;
        this.categories = categories;
        this.nom = nom;
    }

    public Marche() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heure_ouverture) {
        this.heureOuverture = heure_ouverture;
    }

    public String getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(String heure_fermeture) {
        this.heureFermeture = heure_fermeture;
    }

    public int getNbreHangars() {
        return nbreHangars;
    }

    public void setNbreHangars(int nbre_hangars) {
        this.nbreHangars = nbre_hangars;
    }

    public Collection<Categories_Enum> getCategories() {
        return categories;
    }

    public void setCategorie(Collection<Categories_Enum> categories) {
        this.categories = categories;
    }

}
