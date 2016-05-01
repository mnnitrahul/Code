package array;

public class EggFloor {
	public int getMinimumTrials(int eggs, int floor) {
		int m = eggs+1;
		int n = floor+1;
		int[][] arr = new int[eggs+1][floor+1]; 
		for (int j = 1;j<= floor; ++j) {
			arr[1][j] = j;
		}
		for (int i = 1;i<=eggs;++i) {
			arr[i][1] = 1;
			arr[i][0] = 0;
		}
		for (int i = 2;i<= eggs;++i) {
			for (int j = 2; j<= floor; ++j) {
				arr[i][j] = floor + 2;
				for (int k = 1; k<= j; ++k) {
					int res = 1 + max(arr[i][j-k], arr[i-1][k-1]);
					if (res < arr[i][j]) {
						arr[i][j] = res;
					}
				}
			}
		}
		return arr[eggs][floor];
	}
	private int max (int i, int j) {
		if (i > j) {
			return i;
		}
		return j;
	}
	public static void main(String[] args) {
		EggFloor eggFloor = new EggFloor();
		int result = eggFloor.getMinimumTrials(2, 36);
		System.out.println("result is " + result);
	}
}
