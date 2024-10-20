import java.util.*;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String illness;
    
    public Patient(String name, int age, String gender, String illness) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.illness = illness;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getIllness() {
        return illness;
    }
}

class Hospital {
    private List<Patient> patientList;
    
    public Hospital() {
        patientList = new ArrayList<>();
    }
    
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
    
    public List<Patient> getAllPatients() {
        return patientList;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("\nEnter patient name: ");
                    String name = scanner.nextLine();
                    
                    // Age validation
                    int age;
                    while (true) {
                        System.out.print("Enter patient age: ");
                        age = scanner.nextInt();
                        if (age > 0) {
                            break;
                        } else {
                            System.out.println("Age must be a positive number. Please try again.");
                        }
                    }
                    scanner.nextLine(); 
                    
                   
                    String gender;
                    while (true) {
                        System.out.print("Enter patient gender (Male/Female/Other): ");
                        gender = scanner.nextLine();
                        if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other")) {
                            break;
                        } else {
                            System.out.println("Invalid gender! Please enter Male, Female, or Other.");
                        }
                    }
                    
                    System.out.print("Enter patient illness: ");
                    String illness = scanner.nextLine();
                    
                    Patient patient = new Patient(name, age, gender, illness);
                    hospital.addPatient(patient);
                    System.out.println("Patient added successfully!");
                    break;
                    
                case 2:
                    System.out.println("\nAll Patients:");
                    List<Patient> patients = hospital.getAllPatients();
                    if (patients.isEmpty()) {
                        System.out.println("No patients found!");
                    } else {
                        for (Patient p : patients) {
                            System.out.println("Name: " + p.getName());
                            System.out.println("Age: " + p.getAge());
                            System.out.println("Gender: " + p.getGender());
                            System.out.println("Illness: " + p.getIllness());
                            System.out.println();
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
