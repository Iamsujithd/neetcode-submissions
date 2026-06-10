class NumMatrix {

    public int[][] matrix;
    public int[][] prefix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        int sum=0;
        prefix=new int[matrix.length][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                prefix[i][j+1]=prefix[i][j]+matrix[i][j];
                
            }
            sum=0;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total=0,row;
        for(row=row1;row<=row2;row++){
            total+=prefix[row][col2+1]-prefix[row][col1];

        }
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */