package uz.pdp.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ppmtool.domain.Project;
import uz.pdp.ppmtool.exception.ProjectIdException;
import uz.pdp.ppmtool.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;


    @Override
    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project identifier " + project.getProjectIdentifier() + " already exists.");
        }
    }

    @Override
    public Project getProjectByProjectId(String projectId) {
        Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project==null ){
            throw new ProjectIdException("Project ID "+projectId + " does not exist.");
        }
        return project;
    }

    @Override
    public Iterable<Project> getAll() {
        return  projectRepository.findAll();
    }
}
