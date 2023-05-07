# Binero

The Binero is a derivative of sudoku, where the boxes contain only 0 and 1.

Here are the rules:
- Each row and column must contain as much as 1 to 0.
- It can't be more than two 0 or two 1 following.
- There can not be two identical lines or two identical columns.

# Solver
This solver uses backtracking.
You only have to update the "Main" class with the grid you would like to solve. Set "-1" for empty cell.
