import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Date test = new Date();
        Show ex=new Show();

        ex.ShowInfo();
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        test.InputDate();
        switch (n){
            case 1:
                test.SetDays();
                test.InputAdd();
                test.AddDay();
                System.out.println("기준 일로부터 "+test.add_day
                        +" 일 후는 "+test.year+"."+test.month+"."+test.day+"이다");
                break; // 더할때는 기준일을 포함해서 더한다
            case 2:
                test.SetDays();;
                test.Inputsub();
                test.SubDay();
                System.out.println("기준 일로부터 "+test.sub_day+
                        " 일 전은 "+test.year+"."+test.month+"."+test.day+"이다");
                break; // 빼기 같은 경우 기준일을 포함하지 않는다.
        } //switch의 끝
    } //main함수의 끝
}
