package com.warrios.seminaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warrios.seminaire.modeles.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	
}

