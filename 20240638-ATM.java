import java.util.Scanner;
Scanner sc = new Scanner(System.in);

public class Account {
    static boolean Acc=true;
    static int index;
    int[] Id = {1, 2, 3, 4, 5};
    String[] Person = {"NourEldin Islam", "Mohammed Amr", "Youssef Ibrahim", "Ebrahim Hassan", "Mohaned Islam"};
    int[] Pass = {1111, 2222, 3333, 4444, 5555};
    int[] Balance = {500, 800, 1000, 900, 2400};

    Account(int serial) {
        index = serial - 1;
        Login();
    };
    public void Login() {
        IO.print("Enter your Password: ");
       for (int k=0;k<3;k++){
           int Password = sc.nextInt();
           if(Pass[index]!=Password && k!=2){
               IO.println("ERROR! \nPlease try again");
           }else if(Pass[index]==Password){
               IO.println("--------------------------------------------------------------------\nLogin Successful \nWelcome " + Person[index]);
               break;
           }else{
           IO.println("You have been blocked for passing the limit \nPlease contact us");
           Acc=false;
           return ;
            }
        }
    };
};

class Service extends Account {

    Service(int serial) {
        super(serial);
    }

    void menu() {
        IO.println("--------------------------------------------------------------------\nChoose of the following: ");
        IO.println("1) Check Balance \n2) Collect Money \n3) Send Money \n4) Exit \n--------------------------------------------------------------------");
    };

    void order() {
        if (!Acc) {
            return;
        }
        while (true) {
            menu();
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    IO.println("Your account have: " + Balance[index]);
                    break;
                case 2:
                    IO.print("How Much you want to collect?: ");
                    while (true) {
                        int amount = sc.nextInt();
                        if(Balance[index]>=amount){
                            Balance[index]-=amount;
                            IO.println("Money converted successfully");
                            break;
                        }else{
                            IO.println("You don't have this amount!\nTry again");
                        }
                    }
                    break;
                case 3:
                    IO.print("Enter the amount to send: ");
                    int amount = sc.nextInt();
                    Balance[index]+=amount;
                    IO.println("Money has been sent successfully");
                    break;
                case 4:
                    IO.println("Thank you for choosing us wishing you all the best");
                    return;
            }
        }
    };
}
void main() {
    IO.print("Please Enter your card: ");
    int CardId=sc.nextInt();
    Service Trail =new Service(CardId);
    Trail.order();
}
