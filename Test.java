

public class Test extends CQueue{

    public static void main(String[] args) {

        CQueue  my_favorites = new CQueue( 11 );
        int     i;

	for( i=0; i < my_favorites.size; i++ )
	    my_favorites.buffer[i] = (float) 1.1 * (i+1);

        System.out.println( "My favorites" );
        my_favorites.print();
		}
}