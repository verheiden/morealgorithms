package apps.yuzaco.com.colorful;

import java.util.HashMap;

public class colorFul {
    public static void main(String args[]){
        colorFul obj = new colorFul();
        System.out.println(obj.power("16"));
    }
    public int power(String a) {
        String number = a;
        int digit;
        while ( number.length() > 1  )
        {
            digit = number.charAt(number.length() - 1 ) - '0';

            if ( (digit%2) != 0 )
                return 0;
            number = divideByTwo(number) ;
        }
        if ( number.length() == 1 )
        {
            digit = number.charAt(0)  - '0';
            if ( digit == 2 || digit == 4 || digit == 8 )
                return 1;
        }
        return 0;
    }
    String divideByTwo(String number)
    {
        boolean carry = false;
        StringBuffer buf = new StringBuffer();
        boolean leadingZero = true;
        for(int i = 0; i < number.length(); i++ )
        {
            int digit = number.charAt(i) - '0';
            if ( carry )
                digit += 10;
            carry = false;
            if ( digit %2 == 1)
            {
                carry = true;
            }
            else
                carry = false;
            digit /= 2;
            if ( leadingZero && digit == 0 )
                continue;
            else
                leadingZero = false;

            buf.append((char) (digit + '0') );
        }
        return buf.toString();
    }
    public int colorful(int a) {
        int number = Math.abs(a);
        String colorful = intToString(number);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = colorful.length();
        for ( int size = 1; size <= n; size++ )
        {
            for( int i = 0; i <= (n - size ); i++)
            {
                int product = 1;
                for ( int k = i; k < (i + size); k++)
                {
                    int digit = colorful.charAt(k) - '0';
                    product *= digit;
                }
                if ( map.containsKey(product) )
                {
                    return 0;
                }
                else
                    map.put(product, product);
            }
        }
        return 1;
    }
    String intToString(int number){
        StringBuffer buf = new StringBuffer();
        while(number > 0 )
        {
            int digit = number%10;
            number /= 10;
            buf.append((char) ( digit + '0'));
        }
        buf.reverse();
        return buf.toString();
    }
}
