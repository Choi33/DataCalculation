import java.util.Scanner; // Scanner 사용을 위해 필요

public class Date {

    public int month;
    public int year;
    public int day;
    public int month_day; // 각 달의 끝 날짜
    public int add_day; // 기준일에 더할 값
    public int sub_day; // 기준일에서 뺄 값

    public void InputDate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("년도를 입력하세요");
        year=sc.nextInt();
        System.out.println("달을 입력하세요.");
        month=sc.nextInt();
        System.out.println("일을 입력하세요.");
        day=sc.nextInt();
        System.out.println(year+"."+month+"."+day);
    }

    public void InputAdd(){
        Scanner sc2=new Scanner(System.in);
        System.out.println("며칠 후를 구하시겠습니까? 숫자만 입력해주세요.");
        add_day=sc2.nextInt();
    }


    public void SetDays(){
        int [] days ={28,29,30,31};

        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            month_day=days[3];
        }

        if(month==4 || month==6 || month==9 || month==11){
            month_day=days[2];
        }

        if(month==2){
            if(year % 4==0){
                if(year % 100 == 0){
                    if(year % 400 == 0) month_day=days[1]; // 100과 400으로 나눠떨어지면 윤년
                    else month_day=days[0]; //아니면 윤년 X
                }
                else month_day=days[1]; //100으로 나눠떨어지지 않고 4로 나눠떨어짐 → 윤년
            }
            else{
                month_day=days[0]; //윤년 X
            }
        }
    }//SetDays 함수 끝

    public void AddDay() {
        day += add_day;
        int tmp;
        while (day > month_day) { //각 달의 끝 날의 숫자보다 더한 값이 클 때
            if (month == 12) {
                year++;
                month = 1;
                tmp = day - month_day;
                day = tmp;
            }
            else {
                month++;
                tmp = day - month_day;
                day = tmp;
                SetDays();
            }
        }
        day--;
        if(day==0) {
            month--;
            SetDays();
            day=month_day;
        }
    } //AddDay끝

    public void Inputsub(){
        Scanner sc2=new Scanner(System.in);
        System.out.println("며칠 전을 구하시겠습니까? 숫자만 입력해주세요.");
        sub_day=sc2.nextInt();
    }

    public void SubDay(){
        day -= sub_day;
        int tmp2;
        while(day<1){ // sub_day를 빼고 day가 음수가 나오면
            if(month==1){
                year--;
                month=12;
                tmp2 = month_day + day;
                day = tmp2;
                SetDays();
            }
            else {
                month--;
                tmp2 = month_day + day;
                day = tmp2;
                SetDays();
            }
        }
    } //SubDay 끝
}//클래스 끝



