public class SoNguyen
{
    private int value ;
    public SoNguyen( int value )
    {
        this.value = value ;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public SoNguyen add( SoNguyen other )
    {
        return new SoNguyen( this.value + other.getValue() );
    }
    public SoNguyen sub( SoNguyen other )
    {
        return new SoNguyen( this.value - other.getValue() ) ;
    }
    public SoNguyen mutil( SoNguyen other )
    {
        return new SoNguyen( this.value*other.getValue() ) ;
    }
    public SoNguyen chia_du( SoNguyen other )
    {
        return new SoNguyen( this.value%other.getValue() ) ;
    }
    public SoNguyen chia_nguyen( SoNguyen other )
    {
        return new SoNguyen( this.value/other.getValue() ) ;
    }
    public boolean equals ( SoNguyen other )
    {
        if ( other == null ) return false ;
        return this.value == other.getValue();
    }
    public int CompareTo( SoNguyen other )
    {
        return Integer.compare(this.value , other.getValue()) ;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value) ;
    }
}
