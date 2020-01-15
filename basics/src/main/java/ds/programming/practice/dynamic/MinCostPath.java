package ds.programming.practice.dynamic;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}};
		System.out.println(minCost(cost, 2, 2));
		System.out.println(minCostPathDy(cost, 2, 2));
	}
	
	
	
	public static int minCost(int[][] cost , int m , int n){
		if(n< 0 || m <0){
			return Integer.MAX_VALUE;
		}
		if(m==0 && n ==0){
			return cost[m][n];
		}else{
			return cost[m][n] + MinCostPath.minValue(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1));
		}
	}
	
	public static int minValue(int x , int y , int z){
		if(x < y ){
			return x < z ? x : z  ;
		}else {
			return y < z ? y : z ;
		}
	}
	
	public static int minCostPathDy(int[][] cost , int m , int n){
		int[][] temp = new int[m+1][n+1];
		
		temp[0][0] = cost[0][0];
		
		for(int i=1 ; i <=m;i++){
			temp[i][0] = temp[i-1][0] + cost[i][0];
		}
		for(int j = 1 ; j<=n ; j++){
			temp[0][j] = temp[0][j-1] + cost[0][j];
		}
		for(int i =1 ; i <=m ;i++){
			for(int j = 1 ; j<=n ;j++){
				temp[i][j] = cost[i][j] + minValue(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
			}
		}
		return temp[m][n];
	}

}
