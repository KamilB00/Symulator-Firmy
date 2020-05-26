package symulator.app.person;

    public class Worker {
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
        //=============================================================================================================
        public Worker(String position, Double salary, Double efficiency) {
        setSalary(salary);
        setPosition(position);
        setEfficiency(efficiency);
        }
        public Worker(){}
}
