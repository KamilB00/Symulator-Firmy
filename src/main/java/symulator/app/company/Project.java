package symulator.app.company;

import java.util.Date;

public class Project implements Cloneable {

    private Double price;
    private Integer levelOfDifficulty;
    private Double projectTime;
    private String orderName;

    //----------------------------------------------------------------------------------------------------------------

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLevelOfDifficulty(Integer levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public void setProjectTime(Double projectTime) {
        this.projectTime = projectTime;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    //----------------------------------------------------------------------------------------------------------------

    public Project(Double price, Integer levelOfDifficulty, Double projectTime, String orderName) {
        this.price = price;
        this.levelOfDifficulty = levelOfDifficulty;
        this.projectTime = projectTime;
        this.orderName = orderName;
    }

    public Project() {
    }

    /**
     * DANE POJEDYŃCZEGO ZLECENIA
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Project project = new Project(this.price,this.levelOfDifficulty,this.projectTime,this.orderName);
        return project;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public Double getProjectTime() {
        return projectTime;
    }

    public String getOrderName() {
        return orderName;
    }
    //----------------------------------------------------------------------------------------------------------------


}
