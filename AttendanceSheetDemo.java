class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            return;
        }

        // Avoid duplicate counting
        if (isPresent(studentName)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
        } else {
            System.out.println("Class is full. Cannot mark " + studentName + " present.");
        }
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return presentCount;
    }
}

public class AttendanceSheetDemo {

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, ignored

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Is Ben Present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen Present? " + sheet.isPresent("Chen"));
    }
}