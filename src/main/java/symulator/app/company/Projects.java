package symulator.app.company;

public class Projects {
    private static Projects INSTANCE = null;
    private Projects(){}
    public static Projects getInstance(){
        if(INSTANCE==null)
            INSTANCE = new Projects();
        return INSTANCE;
    }
    private Integer numberOfProjects;
    private Double price;
    private Integer levelOfDifficulty;
    private Integer projectTime;

    //----------------------------------------------------------------------------------------------------------------

    public void setNumberOfProjects(Integer numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLevelOfDifficulty(Integer levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public void setProjectTime(Integer projectTime) {
        this.projectTime = projectTime;
    }

    //----------------------------------------------------------------------------------------------------------------

    public Integer getNumberOfProjects() {
        return numberOfProjects;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public Integer getProjectTime() {
        return projectTime;
    }

    //----------------------------------------------------------------------------------------------------------------

}
