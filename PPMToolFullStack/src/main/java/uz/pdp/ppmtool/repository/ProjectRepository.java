package uz.pdp.ppmtool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.ppmtool.domain.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    Project findByProjectIdentifier(String projectId);
}
