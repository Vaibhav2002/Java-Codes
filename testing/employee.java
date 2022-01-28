package testing;

public class employee {
    String empname;
    int empcode;
    double basicpay;

    public employee() {
        empname = "";
        empcode = 0;
        basicpay = 0.0;
    }

    public employee(String n, int p, double q) {
        this.empname = n;
        this.empcode = p;
        this.basicpay = q;
    }

    double salarycall() {
        double salary = basicpay + 0.3 * basicpay + 0.4 * basicpay;
        double special;
        if (empcode <= 15 && salary <= 1500.00) {
            special = 0.2 * salary;
            if (special > 2500)
                special = 2500;
        } else
            special = 1000;
        return salary + special;
    }
}
