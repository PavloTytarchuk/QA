package tytarchuk;


public enum ColumnNames {
    PLAYED(1), WINS(2), DRAWS(3), LOSES(4), GOALDIFFERNCE(5), POINTS(6);

    private int columnNumber;

    ColumnNames(int columnName) {
        this.columnNumber = columnName;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
