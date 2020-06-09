package symulator.app.person;

import symulator.app.company.Company;

public class Worker {

        private Integer id;
        private Double efficiency;
        private Double salary;
        private String position;

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

        //=============================================================================================================


}
