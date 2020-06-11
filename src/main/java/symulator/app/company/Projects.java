package symulator.app.company;

import java.util.Date;

public class Projects {

    private Double price;
    private Integer levelOfDifficulty;
    private Integer projectTime;
    private String orderName;

    //----------------------------------------------------------------------------------------------------------------

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLevelOfDifficulty(Integer levelOfDifficulty) {
        this.levelOfDifficulty = levelOfDifficulty;
    }

    public void setProjectTime(Integer projectTime) {
        this.projectTime = projectTime;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    //----------------------------------------------------------------------------------------------------------------


    public Double getPrice() {
        return price;
    }

    public Integer getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public Integer getProjectTime() {
        return projectTime;
    }

    public String getOrderName() {
        return orderName;
    }
    //----------------------------------------------------------------------------------------------------------------


}
