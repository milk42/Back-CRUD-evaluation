package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.SuspectModel;

public interface IRepositorySuspect extends JpaRepository<SuspectModel, Long>{

	// Interface Repository qui implemente JpaRepository contenant les méthodes 
	// qui vont permettre de créercréant la base des requêtes SQL dont on aura besoin 
	// dans le controller pour faire le CRUD

}
