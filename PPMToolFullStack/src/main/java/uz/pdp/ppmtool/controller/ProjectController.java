package uz.pdp.ppmtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ppmtool.domain.Project;
import uz.pdp.ppmtool.service.MapValidationErrorService;
import uz.pdp.ppmtool.service.ProjectService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    MapValidationErrorService errorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.getProjectByProjectId(projectId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
@GetMapping("/all")
    public Iterable<Project> getAllProject() {
        return projectService.getAll();
    }
}
