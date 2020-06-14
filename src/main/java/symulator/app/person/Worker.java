package symulator.app.person;


public class Worker {

        private Integer id;
        private Double efficiency;
        private Double salary;
        private String position;
        private Integer availability;
        private Double experience;

    public void setEfficiency(Double efficiency) {
            this.efficiency = efficiency;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        public void setSalary(Double salary) {
            this.salary = salary;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public void setAvailability(Integer availability) {
        this.availability = availability;
    }
        public void setExperience(Double experience) {
        this.experience = experience;
    }
    //=============================================================================================================

        public Double getEfficiency() {
            return efficiency;
        }

        public Double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public Integer getId() {
            return id;
        }

        public Integer getAvailability() {
        return availability;
    }

        public Double getExperience() {
        return experience;
    }
    //=============================================================================================================


}
