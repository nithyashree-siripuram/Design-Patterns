package Singleton;

class Logger {

  // One private static instance
  private static Logger instance;

  // Private constructor prevents outside object creation
  private Logger() {
    System.out.println("New Logger Instance Created");
  }

  // Public method to access the single instance
  public static Logger getInstance() {

    if (instance == null) {
      instance = new Logger();
    } else {
      System.out.println("Existing Logger Instance Reused");
    }

    return instance;
  }

  // Method to display messages
  public void log(String message) {
    System.out.println("Log: " + message);
  }
}

public class Main {

  public static void main(String[] args) {

    // Student module
    Logger studentLogger = Logger.getInstance();
    studentLogger.log("Student module accessed");

    // Faculty module
    Logger facultyLogger = Logger.getInstance();
    facultyLogger.log("Faculty module accessed");

    // Examination module
    Logger examLogger = Logger.getInstance();
    examLogger.log("Examination module accessed");

    // Verify that all references point to the same object
    System.out.println(
        "Same Instance? " +
            (studentLogger == facultyLogger &&
                facultyLogger == examLogger));
  }
}
