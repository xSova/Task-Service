public class Main {
    public static void main(String[] args) {
        Task bryce = new Task("123491234", "Test Task", "This is a test to test the task service.");
        System.out.println("Task name: " + bryce.getName());
        System.out.println("Description: " + bryce.getDescription());
    }
}
