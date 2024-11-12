package in.rtms.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rtms.main.entities.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Long>{

}
