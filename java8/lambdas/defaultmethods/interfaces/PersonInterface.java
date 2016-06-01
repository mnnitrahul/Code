package lambdas.defaultmethods.interfaces;

public interface PersonInterface {
	
	String getName();
	void setName(String name);
	int getAge();
	void setAge(int age);

	/**
	 *
	 * lAMBDA Default function
     */
	default String getPersonInfo() {
		return getName() + " (" + getAge() + ")";
	}
}
