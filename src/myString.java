public class myString
{
    private char[] chars = null ;
    private int length ;
    public myString(char[] chars )
    {
        this.length = chars.length ;
        this.chars = new char[length] ;
        System.arraycopy(chars , 0 , this.chars , 0 , this.length);
    }
    public myString( String string )
    {
        this.length = string.length() ;
        this.chars = string.toCharArray() ;
    }

    public char[] getChars() {
        return chars;
    }

    public int getLength() {
        return length;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
        this.length = chars.length ;
    }
    public char CharAt ( int index )
    {
        if ( index < 0 || index > this.length )
            throw new IndexOutOfBoundsException("Vị trí không hợp lệ: " + index);
        else
        {
            return this.chars[index] ;
        }
    }
    public myString concat (myString other )
    {
        if (other == null || other.getLength() == 0) return null ;
        int new_length = this.length + other.getLength() ;
        char[] new_chars = new char[new_length] ;
        System.arraycopy( this.chars , 0 , new_chars , 0 , this.length);
        System.arraycopy(other.getChars() , 0 , new_chars , this.length , other.length);
        return new myString(new_chars);
    }
    public myString substring ( int start , int end )
    {
        if ( start < 0 || end > this.length || start > end ) {
            throw new IndexOutOfBoundsException("Khoảng cắt không hợp lệ");
        }
        int sublength = end - start ;
        char[] sub_str = new char[sublength] ;
        System.arraycopy( this.getChars() , start , sub_str , 0 , sublength );
        return new myString(sub_str) ;
    }
    public boolean squals ( myString other )
    {
        if (other == null || this.length != other.getLength()) {
            return false;
        }
        for ( int i = 0 ; i < this.length ; i++ )
        {
            if ( this.chars[i] != other.CharAt(i))
                return false ;
        }
        return true ;
    }
    @Override
    public String toString() {
        return new String(this.chars) ;
    }
}