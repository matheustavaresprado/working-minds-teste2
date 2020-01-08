package teste2;

public class Main {

	public static void main(String[] args) {
		
		int n = 6;
		
		int[][] matrix = matrix(n);
		
		printMatrix(matrix);
	}

	public static int[][] matrix(int n) {
		int[][] matrix = new int[n][n];
		
		int number = 1;
		int limitMinI = 0;
		int limitMaxI = n;
		int limitMinJ = 0;
		int limitMaxJ = n;
		int i = 0, j = 0;
		
		/*
		 * O algoritmo constroi a expiral por camadas (de fora para dentro).
		 * primeiro percorro a primeira linha, ajusto o limiteMin de i para 
		 * não entrar novamente nesta linha. Depois percorro a coluna direita,
		 * ajustando o limiteMax de j para não entrar mais nesta coluna, depois
		 * vou fazendo analogamente para as outras partes, sempre ajustando os limites
		 * minimos e maximos para que não entremos novamente no mesmo lugar.
		 * */
		while(number <= n*n) {
			
			for(j = limitMinJ; j < limitMaxJ; j++) {
				matrix[i][j] = number++;
			}
			
			j--; //ajustando j para não passar do length da matriz
			limitMinI++;
			
			for(i = limitMinI; i<limitMaxI; i++) {
				matrix[i][j] = number++;
			}
			
			j--;
			i--;//ajustando i para não passar do length da matriz
			limitMaxJ--;
			
			while(j >= limitMinJ) {
				matrix[i][j] = number++;
				j--;
			}
			
			limitMaxI--;
			j++;//ajustando j para não passar do length da matriz
			i--;
			
			while(i >= limitMinI) {
				matrix[i][j] = number++;
				i--;
			}
			
			limitMinJ++;
			i++;//ajustando i para não passar do length da matriz
		}
		
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
