package es.abelfgdeveloper.petclinic.specialty.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataSpecialtyRepository
    extends JpaRepository<SpecialtyEntity, String>, JpaSpecificationExecutor<SpecialtyEntity> {

  Optional<SpecialtyEntity> findByName(String name);
}
