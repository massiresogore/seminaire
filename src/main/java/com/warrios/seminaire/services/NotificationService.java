package com.warrios.seminaire.services;

import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Notification;
import com.warrios.seminaire.repository.NotificationRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements CrudInterface<Notification> {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification findById(Integer id) {
        return notificationRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("notification",id));

    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Integer id) {
        this.findById(id);
        this.notificationRepository.deleteById(id);
    }

    @Override
    public Notification update(Notification update, Integer id) {
        Notification oldNotification = this.findById(id);
        oldNotification.setId_notification(update.getId_notification());
        oldNotification.setMessage(update.getMessage());
        oldNotification.setDate_envoi(update.getDate_envoi());
        oldNotification.setDate_reception(update.getDate_reception());
        oldNotification.setEvenement(update.getEvenement());

        return notificationRepository.save(oldNotification);
    }
}
