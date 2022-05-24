package es.abelfgdeveloper.petclinic.vet.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataVetRepository
    extends JpaRepository<VetEntity, String>, JpaSpecificationExecutor<VetEntity> {}
