 import java.util.Scanner;
public class Palindrome {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter a Number:");
     int n =  sc.nextInt();
    int rev = 0;
    int temp = n;
     while(n > 0){
         int digit = n%10;
         rev=rev*10+digit;
         n/=10;
     }
     String str = (rev==temp) ? "Palindrome" : "Not a Palindrome";
     System.out.print(str);
     sc.close();
 }
}

    

