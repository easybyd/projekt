package pl.easybud.backend.data;

public class JobStatus {
    public static final String DONE = "Zrealizowano";
    public static final String ACTIVE = "W trakcie";
    public static final String CLOSE = "Zamknięte";
    public static final String INACTIVE = "Oczekuję";

    public JobStatus() {
    }

    public static String[] getAllJobStatus() {
        return new String[] {DONE, ACTIVE, INACTIVE, CLOSE };
    }
}
