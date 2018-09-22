package pl.easybud.backend.data;

public class ToolStatus {

  public static final String INACTIVE = "Nieaktywny";
  public static final String ASSIGNED ="Przypisany";
  public static final String FREE = "Wolny";

  private ToolStatus() {
  }

  public static String[] getAllToolStatus() {
    return new String[] {INACTIVE, ASSIGNED, FREE};
  }


}
