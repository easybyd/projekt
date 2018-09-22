package pl.easybud.backend.data;

public class EmployeeStatus {
  public static final String INACTIVE = "Nieaktywny";
  public static final String ASSIGNED ="Przypisany";
  public static final String FREE = "Wolny";

  private EmployeeStatus() {
  }

  public static String[] getAllEmplStatus() {
    return new String[] {INACTIVE, ASSIGNED, FREE};
  }

}
