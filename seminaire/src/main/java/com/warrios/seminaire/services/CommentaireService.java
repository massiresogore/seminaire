package com.warrios.seminaire.services;

import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Commentaire;
import com.warrios.seminaire.repository.CommentaireRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentaireService implements CrudInterface<Commentaire> {
    private final CommentaireRepository commentaireRepository;

    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }


    @Override
    public Commentaire findById(Integer id) {

        return commentaireRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("commentaire",id));
    }

    @Override
    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire save(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void delete(Integer id) {
        this.findById(id);
        this.commentaireRepository.deleteById(id);
    }

    @Override
    public Commentaire update(Commentaire update, Integer id) {
        Commentaire oldCommentaire = this.findById(id);
        oldCommentaire.setId_commentaire(update.getId_commentaire());
        oldCommentaire.setContenu(update.getContenu());
        oldCommentaire.setUtilisateur(update.getUtilisateur());

        return oldCommentaire;
    }
}
