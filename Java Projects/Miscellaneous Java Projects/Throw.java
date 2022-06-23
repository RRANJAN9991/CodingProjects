package programs;

public class Throw {
    public int test(int a,int b) throws Exception {
        int c;
        c = a/b;
        return c;
    }
    public static void main(String[] arguements) {
        try {
            Throw T = new Throw();
            int x = T.test(10,0);
            System.out.print("Result" + x);
        }
        catch (Exception e) {
            System.out.print("Exception is" + e);
        }
        
    } 
}
