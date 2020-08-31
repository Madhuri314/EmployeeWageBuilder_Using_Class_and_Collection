import java.util.List;
import java.util.ArrayList;
public class EmpWageBuilderMultipleCompany {

        private List<Company> companies;

        public EmpWageBuilderMultipleCompany() {
                companies = new ArrayList<Company>();
        }

        public static void main(String[] args) {
                final EmpWageBuilderMultipleCompany empBuilder = new EmpWageBuilderMultipleCompany();
                empBuilder.addCompany("TATA", 20, 20, 100);
                empBuilder.addCompany("BATA", 15, 25, 100);

                empBuilder.computeEmpWage();
        }

        public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
                companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
        }

        private void computeEmpWage(){
                for(int i = 0; i< companies.size(); i++){
                	final Company company = companies.get(i);
                        final int totalWage = computeEmpWage(company);
                        company.setTotalEmpWage(totalWage);
                        System.out.println(company);
                }
        }
        /**
         * calculate total employee wages
         * @param company The Company
         * @return total employee wages.
         */
        private int computeEmpWage(final Company company) {
                int totalWage = 0;
                int totalEmpHrs = 0;
                int totalWorkingDays = 0;
                while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
                        totalWorkingDays++;

                        final int empHrs = getEmpHrs();
                        final int empWage = empHrs*company.getEmpRate();
                        totalEmpHrs+=empHrs;
                        totalWage+=empWage;
                        //System.out.println("Emp DAY : "+totalWorkingDays+" wages : "+empWage);
                }
                return totalWage;
        }

        /**
         * Get employee hours.
         * @return employee hrs
         */
        public int getEmpHrs() {

                final int isFullTime = 1;
                final int isPartTime = 2;
                int empHrs = 0;

                //get random value
                final double randomValue = Math.floor(Math.random()*10)%3;

                switch((int)randomValue) {

                        case isFullTime:
                                empHrs = 8;
                                break;
                        case isPartTime:
                                empHrs = 4;
                                break;
                        default:
                                break;
                }
                return empHrs;
        }


}

/**
 * CompanyEmpWage
 */
class Company {

        private String name;
        private int empRate;
        private int numOfWorkingDays;
        private int maxHrsInMonth;
        private int totalEmpWage;

        public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
                this.name = name;
                this.empRate = empRate;
                this.numOfWorkingDays = numOfWorkingDays;
                this.maxHrsInMonth = maxHrsInMonth;
        }

        public String getName(){
                return this.name;
        }

        public int getEmpRate(){
                return this.empRate;
        }

        public int getNumOfWorkingDays(){
                return this.numOfWorkingDays;
        }

        public int getMaxHrsInMonth(){
                return this.maxHrsInMonth;
        }

        public void setTotalEmpWage(final int totalEmpWage){
                this.totalEmpWage=totalEmpWage;
        }

        @Override
        public String toString(){
                return "Total emp wage for company: "+name+" is "+ totalEmpWage;
        }

}
