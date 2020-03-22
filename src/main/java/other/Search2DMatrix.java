package other;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length <=0 ) return false;

        int row = 0;
        int column = matrix[0].length-1;

        while(row < matrix[0].length && column>=0) {
            if (row == matrix.length || column == matrix[0].length ) return false;
            if(matrix[row][column] == target) return true;
            if(matrix[row][column]>target){
                column--;
            } else if(matrix[row][column]<target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(searchMatrix(matrix,1));
    }
}
