package Projects.Marselle.util;

import java.util.Date;
import java.util.HashMap;

public class SalaryCalculating {
    private HashMap<Date, Integer> salary;

    public SalaryCalculating(HashMap<Date, Integer> salary) {
        this.salary = salary;
    }

    public Integer getDaySalary(Date date) {
        return salary.get(date);
    }
}
