enum CellType { 
    EMPTY(" "), CROSS("X"), CIRCLE("O"); 

    private String _name;
    private CellType(String name){
        _name = name;
    }

    @Override
    public String toString(){
        return _name;
    }
}