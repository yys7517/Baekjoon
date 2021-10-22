import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class BOJ_1076 {
    // 저항, 백준 1076
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        HashMap<String,String> om = new HashMap<String,String>();

        om.put("black","0");
        om.put("brown","1");
        om.put("red","2");
        om.put("orange","3");
        om.put("yellow","4");
        om.put("green","5");
        om.put("blue","6");
        om.put("violet","7");
        om.put("grey","8");
        om.put("white","9");

        HashMap<String, BigInteger> value = new HashMap<String,BigInteger>();
        value.put("black",new BigInteger("1"));
        value.put("brown",new BigInteger("10"));
        value.put("red",new BigInteger("100"));
        value.put("orange",new BigInteger("1000"));
        // value.put("yello",new BigInteger("10000"));      key 값에 오타 주의하자!
        value.put("yellow",new BigInteger("10000"));
        value.put("green",new BigInteger("100000"));
        value.put("blue",new BigInteger("1000000"));
        value.put("violet",new BigInteger("10000000"));
        value.put("grey",new BigInteger("100000000"));
        value.put("white",new BigInteger("1000000000"));

        String answer ="";

        answer += om.get( br.readLine() );
        answer += om.get( br.readLine() );

        // System.out.println(answer);

        BigInteger bi = BigInteger.valueOf( Long.parseLong(answer) );

        BigInteger bi2 = value.get( br.readLine() );

        System.out.println( bi.multiply(bi2) );

    }
}
