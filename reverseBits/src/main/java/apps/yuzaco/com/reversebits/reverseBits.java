package apps.yuzaco.com.reversebits;

public class reverseBits {
    public static void main(String args[])
    {
        reverseBits obj = new reverseBits();
        //System.out.println(obj.arrange("WBWB", 2));
        obj.reverse(3);
    }
    public long reverse(long a) {
        long ans = (long) 0x0;
        for ( int i = 0; i < 32; i++)
        {
            ans <<= 1;
            if ( (a & 1<<i) != 0 )
        }
        return ans;
    }   
}
