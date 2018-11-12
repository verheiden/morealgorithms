package apps.yuzaco.com.reversedigits;

public class reverseDigits {
    public static void main(String args[]){
        int a = 12345678;
        reverseDigits  obj = new reverseDigits();
        System.out.println("Reverse of " + a + " : " + obj.reverse(a));
    }
    int reverse(int a){
        boolean negative = false;
        if ( a < 0 ) {
            negative = true;
            a *= -1;
        }
        int rNum = 0;
        while( a > 0 ){
            int digit = a%10;

            if ( rNum > ( Integer.MAX_VALUE/10) &&
                ( rNum == (Integer.MAX_VALUE/10) && ( digit > Integer.MAX_VALUE%10 )))
            {
                return 0;
            }
            rNum = rNum*10 + digit;
            a /= 10;
        }
        if ( negative )
            rNum *= -1;
        return rNum;
    }
}
