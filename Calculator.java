import java.util.Scanner;
class calc{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char op = in.next().charAt(0);
        int n = in.nextInt();
        int arr[];
        arr = new int[n];
        int c=0,e=1,d;
        double f,temp;
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Given Operation:"+op);
        System.out.println("Given Numbers:");
        for(int i =0; i<n; i++){
        System.out.println(arr[i]);
        }
        switch (op){
            case '+':
                for(int i=0; i<n; i++){
                    c+=arr[i];
                }
                System.out.println("Addition of given numbers:"+c);
                break;
            case '-':
                 d = arr[0];
                for(int i=1; i<n; i++){
                    d-=arr[i];
                }
                System.out.println("Substraction of given numbers:"+d);
            break;
            case '*':
                for(int i=0; i<n; i++){
                    e*=arr[i];
                }
                System.out.println("Multiplication of given numbers:"+e);
                break;
            case '/':
                f=arr[0];
                for(int i =1; i<n; i++){
                    if(arr[i] != 0)
                    {
                        f=f/arr[i];
                        temp=f;
                        f=temp;
                    }
                    if(arr[i] == 0){
                        System.out.println("Division Is Not Possible!!");
                        break;
                    }
                
                    System.out.println("Division of given numbers:"+f);
                }
                    break;
                    default :
                    System.out.println("X--Illegal Operation--X");
                    break;
            
                
        }
        
    }

    
}
