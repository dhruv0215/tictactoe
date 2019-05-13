public class Cell {
    int _row;
    int _column;
    CellType _type = CellType.EMPTY;

    public Cell(int row, int column) {
        _row = row;
        _column = column;
    }

    public void setType(CellType newType){
        _type = newType;
    }
}