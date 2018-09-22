package pl.easybud.backend.data;

public class Role {
	public static final String EMPLOYEE = "pracownik";
	public static final String MANAGER = "kierownik";
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] {EMPLOYEE, MANAGER, ADMIN };
	}

}
