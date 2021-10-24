import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1672 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        int n = Integer.parseInt( br.readLine() );
        String dna = br.readLine();

        if ( n != 1 ) {
            for ( int i = 0; i < n-1; i++ ) {
                dna = dna.substring(0,n-2-i) + haedok( dna.charAt(n-2-i),dna.charAt(n-1-i));
                //System.out.println(dna);
            }
            System.out.println( dna );
        }
        else
            System.out.println( dna );


//        HashMap<String,String> map = new HashMap<>();
//        FillMap(map);
//
//        while( sb.length() > 1 ) {
//            StringBuffer temp = new StringBuffer( sb.substring(0,2) );
//            System.out.println(temp.toString());
//            // temp.reverse();
//            sb.replace(0,2 ,map.get(temp.toString()));
//            //System.out.println( sb );
//        }
//        System.out.println( sb );

    }

    private static char haedok( char a, char b ) {

        if ( a == b )
            return a;

        else if ( a == 'A' ) {
            if ( b == 'G' ) {
                return 'C';
            }
            else if ( b == 'C')
                return 'A';
            else if ( b== 'T' )
                return 'G';
        }

        else if ( a == 'G' ) {
            if ( b == 'A' ) {
                return 'C';
            }
            else if ( b == 'C')
                return 'T';
            else if ( b== 'T' )
                return 'A';
        }

        else if ( a == 'C' ) {
            if ( b == 'A' ) {
                return 'A';
            }
            else if ( b == 'G')
                return 'T';
            else if ( b== 'T' )
                return 'G';
        }

        else if ( a == 'T' ) {
            if ( b == 'A' ) {
                return 'G';
            }
            else if ( b == 'G')
                return 'A';
            else if ( b== 'C' )
                return 'G';
        }
        return 0;


//        map.put("AA","A");
//        map.put("GG","G");
//        map.put("CC","C");
//        map.put("TT","T");
//
//        map.put("AG","C");
//        map.put("GA","C");
//
//        map.put("AC","A");
//        map.put("CA","A");
//
//        map.put("CG","T");
//        map.put("GC","T");
//
//        map.put("TA","G");
//        map.put("AT","G");
//
//        map.put("TG","A");
//        map.put("GT","A");
//
//        map.put("TC","G");
//        map.put("CT","G");
    }
}
