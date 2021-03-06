package com.bibliotheque.microservicemyclient.service.myLibrary;

import com.bibliotheque.microservicemyclient.bean.CopieBean;
import com.bibliotheque.microservicemyclient.bean.LivreBean;
import com.bibliotheque.microservicemyclient.bean.ReservationBean;
import com.bibliotheque.microservicemyclient.proxies.IMicroserviceMyLibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class IMicroserviceMyLibraryProxyServiceImpl implements IMicroserviceMyLibraryProxyService {

    @Autowired
    IMicroserviceMyLibraryProxy iMicroserviceMyLibraryProxy;

    /**
     *Permet la recherche de tous les livres
     * @return la liste de tous les livres
     */
    @Override
    public List<LivreBean> ListeDeLivres(){
        return iMicroserviceMyLibraryProxy.ListeDeLivres();
    }

    /**
     * Permet la recherche d'un livre
     * @param id du livre
     * @return le livre recherché
     */
    @Override
    public LivreBean afficherUnLivre(Long id){
        return iMicroserviceMyLibraryProxy.afficherUnLivre(id);
    }

    /**
     * permet de rechercher les copies d'un livre
     * @param id identifiant du livre
     * @return la liste des copies d'un livre
     */
    @Override
    public List<CopieBean> afficherLesCopiesDunLivre(Long id){
        return iMicroserviceMyLibraryProxy.afficherLesCopiesDunLivre(id);
    }

    /**
     * Permet de rechercher une copie
     * @param id identifiant de la copie
     * @return la copie recherchée
     */
    @Override
    public CopieBean afficherUneCopie(Long id){
        return iMicroserviceMyLibraryProxy.afficherUneCopie(id);
    }

    /**
     * Permet de rechercher les reservations d'un utilisateur
     * @param id identifiant de l'utilisateur
     * @return la liste des reservations d'un utilisateur
     */
    @Override
    public List<ReservationBean> afficherLaListeDesReservationsParUtilisateur(Long id){
        return iMicroserviceMyLibraryProxy.afficherLaListeDesReservationsParUtilisateur(id);
    }

    /**
     * Permet rechercher les copies disponibles d'un livre
     * @param id identifiant du livre
     * @return la liste des copies disponibles
     */
    @Override
    public List<CopieBean> afficherLesCopiesDisponibles(Long id){
        return iMicroserviceMyLibraryProxy.afficherLesCopiesDisponibles(id);
    }

    /**
     * Permet de faire une demande de reservation d'une copie d'un livre
     * @param id identifiant de la copie du livre
     * @param idUtilisateur identifiant de l'utilisateur
     */
    @Override
    public void demandeDeReservation(Long id, Long idUtilisateur){
        iMicroserviceMyLibraryProxy.demandeDeReservation(id, idUtilisateur);
    }

    /**
     * Permet de prolonger un prêt
     * @param id identifiant du prêt
     * @param idUtilisateur identifiant de l'utilisateur
     * @return le prêt prolongé
     */
    @Override
    public ReservationBean prolongerPret(Long id, Long idUtilisateur){
        return iMicroserviceMyLibraryProxy.prolongerPret(id, idUtilisateur);
    }

    /**
     * Permet de rechercher une reservation
     * @param id identifiant de la reservation
     * @return la reservation recherchée
     */
    @Override
    public ReservationBean afficherUneReservation(@PathVariable("id")Long id){
       return iMicroserviceMyLibraryProxy.afficherUneReservation(id);
    }

    /**
     * Permet de rechercher un livre par son titre
     * @param mc mot clé de la recherche
     * @return la liste du résultat de la recherche
     */
    @Override
    public List<LivreBean> faireUneRechercheParTitre(@RequestParam(name = "mc", defaultValue = "") String mc){
        return iMicroserviceMyLibraryProxy.faireUneRechercheParTitre(mc);
    }
}
