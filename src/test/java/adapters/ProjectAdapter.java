package adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import models.ProjectsResponse;

@Log4j2
public class ProjectAdapter extends BaseAdapter {

    @Step("Create project by Api with the name {project}")
    public Project createProject(Project project) {
        log.info("Fill info of project '{}'", project);
        String body = post(new Gson().toJson(project), "add_project");
        return new Gson().fromJson(body, Project.class);
    }

    @Step("Delete project by Api with {projectId}")
    public void deleteProject(int projectId) {
        log.info("Delete project with id '{}'", projectId);
        deleete("delete_project/" + projectId);
    }

    @Step("Get project with specific {projectId}")
    public String getProject(int projectId) {
        log.info("Get project with '{}'", projectId);
        String body = got("get_project/" + projectId);
        return new Gson().fromJson(body, Project.class).getName();
    }

    @Step("Get project id at project with the name {projectName}")
    public int getProjectId(String projectName) {
        log.info("Get project id with '{}'", projectName);
        int id = -1;
        String projects = got("get_projects");
        ProjectsResponse response = new Gson().fromJson(projects, ProjectsResponse.class);
        for (Project project : response.getProjects()) {
            if (project.getName().equals(projectName)) {
                id = project.getId();
            }
        }
        return id;
    }

    @Step("Confirm that project with the name {projectName} is already created")
    public boolean isProjectExist(String projectName) {
        log.info("Confirm that project with the name '{}' is exist" ,projectName);
        boolean isProjectExist = false;
        String projects = got("get_projects");
        ProjectsResponse response = new Gson().fromJson(projects, ProjectsResponse.class);
        for (Project project : response.getProjects()) {
            if (project.getName().equals(projectName)) {
                isProjectExist = true;
                break;
            }
        }
        return isProjectExist;
    }
}
