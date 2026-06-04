class NumMatrix {
    
    // The prefix sum matrix. It is strictly 1 larger in both dimensions 
    // to provide a border of zeros, eliminating all boundary edge cases.
    private int[][] prefixSum;

    /**
     * Initializes the object with the integer matrix.
     * Precomputes the 2D prefix sums to enable O(1) region queries.
     * 
     * @param matrix The original 2D integer array.
     */
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Initialize with 1-based indexing dimensions
        prefixSum = new int[rows + 1][cols + 1];
        
        // Build the prefix sum matrix dynamically
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Formula: Current Cell + Area Above + Area Left - Overlapping Top-Left Area
                prefixSum[r + 1][c + 1] = matrix[r][c] 
                                        + prefixSum[r][c + 1] 
                                        + prefixSum[r + 1][c] 
                                        - prefixSum[r][c];
            }
        }
    }
    
    /**
     * Calculates the sum of elements inside the specified bounding rectangle.
     * 
     * @param row1 Top boundary of the rectangle
     * @param col1 Left boundary of the rectangle
     * @param row2 Bottom boundary of the rectangle
     * @param col2 Right boundary of the rectangle
     * @return The absolute sum of the target region
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Since our prefixSum matrix is 1-indexed relative to the original matrix,
        // we offset the bottom-right coordinates by +1. 
        // The top-left coordinates serve inherently as the boundaries to subtract.
        
        int totalArea = prefixSum[row2 + 1][col2 + 1];
        int areaAbove = prefixSum[row1][col2 + 1];
        int areaLeft  = prefixSum[row2 + 1][col1];
        int overlappingTopLeft = prefixSum[row1][col1];
        
        // Inclusion-Exclusion Formula
        return totalArea - areaAbove - areaLeft + overlappingTopLeft;
    }
}

/**
 * Usage standard:
 * NumMatrix obj = new NumMatrix(matrix);
 * int result = obj.sumRegion(row1, col1, row2, col2);
 */