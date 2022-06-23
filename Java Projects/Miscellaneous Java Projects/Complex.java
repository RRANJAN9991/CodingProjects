package programs;

public class Complex {
    double realPart;
    double imaginaryPart;
    
    public Complex() {
        realPart = 0;
        imaginaryPart = 0;
    }
    
    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    
    public Complex add(Complex otherNumber) {
         Complex C = new Complex();
         C.realPart = realPart + otherNumber.realPart;
         C.imaginaryPart = imaginaryPart + otherNumber.imaginaryPart;
         return C;
    }
    
    public Complex subtract(Complex otherNumber) {
         Complex C = new Complex();
         C.realPart = realPart - otherNumber.realPart;
         C.imaginaryPart = imaginaryPart - otherNumber.imaginaryPart;
         return C;
    }
    
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }
    
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    public double getRealPart() {
        return realPart;
    }
    public double getImaginaryPart() {
        return imaginaryPart;
    }
    public String toString() {
        if (imaginaryPart >= 0) {
            System.out.println(realPart + " + " + imaginaryPart + "i");
        }
        else {
            System.out.println(realPart + " " + imaginaryPart + "i");
        }
        return "";
    }
}

class Complexdemo {
    
    public static void main(String [] arguements) {
        Complex C1 = new Complex(7, 3);
        Complex C2 = new Complex(8, 4);
        Complex C3 = new Complex();
        C3 = C1.add(C2);
        C3.toString();
        C3 = C1.subtract(C2);
        C3.toString();
    }
    
    
}
