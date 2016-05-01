package QueryParser;

public class Main {
	public static void main(String[] args) {
		String[]  inputs = {"1",
				          "employee_id, employee_name, employee_salary, department_id",
				          "employee_id, employee_name where (employee_id > 1 and employee_salary = 1000) or (department_id = 5 and employee_salary = 5000) or department_id = 5) "};
	
		int noOfQueries = Integer.parseInt(inputs[0]);
		
		VerifyInterface vc = new VerifyColumns(inputs[1]);
		VerifyInterface vs = new VerifySimpleQuery();
		VerifyInterface v = new VerifyCompleteQuery(vc, vs);
		for (int i = 0; i < noOfQueries;i++ ) {
			v.varify(inputs[i+2]);
		}
	}
}
