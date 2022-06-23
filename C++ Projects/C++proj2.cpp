#include <iostream>
#include <math.h>
#include <iomanip>
#include <vector>

//This function takes number of intervals as a parameter and returns a size 2 vector containing
//the computed pi and the error.
std::vector <long double> computePi(double intervals) {
    std::vector <long double> pianderror = {0,0};
    long double change_x = 1/intervals;//Computes the change in x.
    long double interval = change_x;
    long double sum = 1;
    long double error;
    int counter = 1;
   
    while (counter <= intervals - 1) {
        sum = sum + 2*(pow((1 - pow(interval, 2)),.5));//For each iteration, add f(x) = (1-x^2)^.5 where x = interval. 
        interval = interval + change_x;//Increment the interval by the change in x.
        counter = counter + 1;
    }
    sum = sum * (change_x/2)* 4;//After the summation, use this formula to estimate pi.
    error = abs(M_PI - sum);//Compute the error between the computed pi (sum) and the actual pi.
    pianderror[0] = sum;//Store these two elements in the vector.
    pianderror[1] = error;
    return pianderror;
}

//This function takes the tolerance as a paramter. It returns a size 3 vector containing
//the computed pi, error, and the estimated number of intervals required for the error to
//be less than the tolerance.
std::vector <long double> computePiBonus(long double tolerance) {
    std::vector <long double> pianderrorandintervals= {0,0,0};
    
    long double sum = 1;
    double intervals = 10;//Start with 10 intervals.
    long double error = 1;
   
    while (error > tolerance) {
        long double change_x = 1/intervals;//Similar code in the above function.
        long double interval = change_x;
        int counter = 1;
        while (counter <= intervals - 1) {
            sum = sum + 2*(pow((1 - pow(interval, 2)),.5));//Same formula as above.
            interval = interval + change_x;//Same function as above.
            counter = counter + 1;
        }
        sum = sum * (change_x/2)* 4;//Same function as above. 
        error = abs(M_PI - sum);//Same functino as above.
        
        pianderrorandintervals[0] = sum;////Store these two elements in the vector.
        pianderrorandintervals[1] = error;
        pianderrorandintervals[2] = intervals;
        intervals = intervals * 1.2;//Increments the intervals =.
    }
    return pianderrorandintervals;
}

//This function is used to print out the contents of the vectors returned from the above two functions.
void print_vector(std::vector<long double>& v) {
   
    
   for(int i=0; i < v.size(); i++) {//We are using a for loop to loop through the vector.
       if (i == v.size() - 1) {//If we reach the last element of the vector, then print it out but do not add a comma after it.
           std::cout << v.at(i);
       }
       else {//Otherwise print out the element with a comma after it.
           std::cout << std::setprecision(12) << v.at(i) << ',';
       }
       
   }
    
}

//This function is used to request for input and print the final results by calling the necessary functions from above.
int main() {
    double n;
    long double m;
    std::cout << "Enter the number of intervals: ";//The non-bonus part of the project.
    std::cin >> n; 
    std::vector<long double> computed_pi = computePi(n);
    std::cout << "Based on the number of intervals, we have the following...";
    std::cout << "\n";
    print_vector(computed_pi);
    std::cout << "\n";
    std::cout << "The first element is the computed value of pi and the second element is the error.";
    std::cout << "\n";
    std::cout << "Enter the tolerance (Example: 0.01, 0.0001, 0.00000001, etc.): ";//The bonus part of the project.
    std::cout << "\n";
    std::cin >> m;
    std::vector<long double> bonuscomputed_pi = computePiBonus(m);
    std::cout << "\n";
    print_vector(bonuscomputed_pi);
    std::cout << "\n";
    std::cout << "The first element is the computed value of pi, the second element is the error, and the third element is the number of intervals.";
   
}