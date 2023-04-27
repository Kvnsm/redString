package fr.schoolbyhiit.portailformation.persistence;

import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
