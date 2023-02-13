
public class MagicSquareFactory {

    private int row;
    private int column;
    private int i;
    private int squaresFilled;
    private int oldRow;
    private int oldColumn;

    public MagicSquareFactory() {
        row = 0;
        column = 0;
        i = 1;
        squaresFilled = 0;
        oldRow = 0;
        oldColumn = 0;
    }

    public MagicSquare createMagicSquare(int size) {
        this.column = ((1 + size) / 2) - 1; // center column of square

        if (size % 1 == 0 && size > 2) {
            MagicSquare square = new MagicSquare(size);

            square.placeValue(column, row, i++);
            squaresFilled++;

            while (squaresFilled < (square.getWidth() * square.getHeight())) {
                up(square);
            }

            return square;
        }
        return null;
    }

    private void up(MagicSquare square) {
        oldRow = row;

        if (row - 1 == -1) {
            row = square.getWidth() - 1;
        } else {
            row -= 1;
        }

        right(square);
    }

    private void right(MagicSquare square) {
        oldColumn = column;

        if (column + 1 >= square.getHeight()) {
            column = 0;
        } else {
            column++;
        }

        if (square.readValue(column, row) ==  0) {
            square.placeValue(column,row,i++);
            squaresFilled++;
        } else {
            down(square);
        }
    }

    private void down(MagicSquare square) {
        square.placeValue(oldColumn,oldRow + 1, i++);
        squaresFilled++;
        row = oldRow + 1;
        column = oldColumn;
    }

}
