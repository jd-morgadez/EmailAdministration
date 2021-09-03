import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "abccompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department --> return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randPass(defaultPasswordLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n " +
                         "1) Sales\n " +
                         "2) Development\n " +
                         "3) Accounting\n " +
                         "0) None\n " +
                         "\nEnter Department Code:");

        Scanner ux = new Scanner(System.in);
        int deptChoice = ux.nextInt();

        if(deptChoice == 1) {
            return "Sales";
        } else if(deptChoice == 2) {
            return "Development";
        } else if(deptChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randPass(int length) {
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        char[] password = new char[length];

        for(int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passSet.length());
            password[i] = passSet.charAt(rand);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // All the public methods that will access the properties
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nDEPARTMENT: " + department +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD: " + password +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
