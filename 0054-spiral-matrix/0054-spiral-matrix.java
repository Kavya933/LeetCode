class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int sRow = 0;
        int eRow = row-1;
        int sCol = 0;
        int eCol = col-1;
        int total = 0;           

        while(total < row * col){
            // add 1st row ele
            for(int i = sCol; i <= eCol && total < row * col; i++){
                ans.add(matrix[sRow][i]);
                total++;
            }
            sRow++;

            // add last col ele
            for(int i = sRow; i <= eRow && total < row * col; i++){
                ans.add(matrix[i][eCol]);
                total++;
            }
            eCol--;

            // add last row ele
            for(int i = eCol; i >= sCol && total < row * col; i--){
                ans.add(matrix[eRow][i]);
                total++;
            }
            eRow--;
            
            // add first col ele
            for(int i = eRow; i >= sRow && total < row * col; i--){
                ans.add(matrix[i][sCol]);
                total++;
            }
            sCol++;


        }
        return ans;

    }
}