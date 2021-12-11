package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CreateProjectApi extends BaseTest {

    @Test(description = "Create and delete project with Api")
    public void createProjectWithApi() {
        Project project = ProjectFactory.get();
        projectAdapter.createProject(project);
        int actualId = projectAdapter.getProjectId(project.getName());
        projectAdapter.getProject(actualId);
        projectAdapter.deleteProject(actualId);
        assertFalse(projectAdapter.isProjectExist(project.getName()), "Project wasn't deleted");
    }
}
