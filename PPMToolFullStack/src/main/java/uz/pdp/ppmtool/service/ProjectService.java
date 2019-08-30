package uz.pdp.ppmtool.service;

import uz.pdp.ppmtool.domain.Project;

public interface ProjectService {
    Project saveOrUpdateProject(Project project);
    Project getProjectByProjectId(String projectId);
    Iterable<Project>getAll();
}
