package symulator.gui;

import javafx.beans.property.SimpleStringProperty;

public class Groups {
    private SimpleStringProperty group;
    private SimpleStringProperty project;
    private SimpleStringProperty time;
    private SimpleStringProperty efficiency;

    public Groups(String group, String project, String time, String efficiency) {
        this.group = new SimpleStringProperty(group);
        this.project = new SimpleStringProperty(project);
        this.time = new SimpleStringProperty(time);
        this.efficiency = new SimpleStringProperty(efficiency);
    }

    public String getGroup() {
        return group.get();
    }

    public SimpleStringProperty groupProperty() {
        return group;
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public String getProject() {
        return project.get();
    }

    public SimpleStringProperty projectProperty() {
        return project;
    }

    public void setProject(String project) {
        this.project.set(project);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getEfficiency() {
        return efficiency.get();
    }

    public SimpleStringProperty efficiencyProperty() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency.set(efficiency);
    }
}
