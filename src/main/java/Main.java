import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class Main {

    public static String[][] table(String[][] tableData){
        String[] columnHeaders ={"Имя", "Фамилия", "Отчество", "Возраст", "Пол", "Дата рождения",
                "Место рождения", "Индекс", "Страна", "Область", "Город",
                "Улица", "Дом", "Квартира"};

        JFrame frame = new JFrame("Люди");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable jtableFIO = new JTable(tableData, columnHeaders);
        JScrollPane scroll = new JScrollPane(jtableFIO);
        jtableFIO.setPreferredScrollableViewportSize(new Dimension(1200, 600));
        frame.getContentPane().add(scroll);
        frame.setVisible(true);

        return tableData;
    }

    public static String[][] getData(int n){
        String[][] tableData = new String[n][14];
        for (int i=0; i<n; i++) {
            tableData[i][4] = getRandom(gender());
            String sex;
            if (tableData[i][4] == "ЖЕН") {
                sex = "W";
            } else {
                sex = "M";
            }
            tableData[i][0] = getRandom(name(sex));
            tableData[i][1] = getRandom(lastName(sex));
            tableData[i][2] = getRandom(fatherName(sex));
            tableData[i][5] = randomBirthday();
            tableData[i][3] = age(tableData[i][5]);
            tableData[i][8] = "Россия";
            tableData[i][12] = building();
            tableData[i][13] = apartment();
               /*         else if (i==6){//место роаждения
                }
                else if (i==7){//индекс
                }
                else if (i==9){//Область
                }
                else if (i==10){//город
                }
                else if (i==11){//улица
                }
 */
        }
        return tableData;
    }

    public static String[] name(String sex){
        String[] namesW = {
                "Галина",
                "Мария",
                "Елизавета",
                "Екатерина",
                "Анастасия",
                "Наталья",
                "Анна",
                "Ксения",
                "Кристина",
                "Карина"
        };
        String[] namesM = {
                "Максим",
                "Виктор",
                "Егор",
                "Сергей",
                "Андрей",
                "Юрий",
                "Дмитрий",
                "Константин",
                "Валерий",
                "Александр"
        };
        if (sex=="W")
            return namesW;
        else
            return namesM;
    }

    public static String[] lastName(String sex){
        String[] lastnamesW = {
                "Винокурова",
                "Петрова",
                "Иванова",
                "Козлова",
                "Бородина",
                "Максакова",
                "Жукова",
                "Некрасова",
                "Белая",
                "Деткова"
        };
        String[] lastnamesM = {
                "Винокуров",
                "Петров",
                "Иванов",
                "Козлов",
                "Бородин",
                "Максаков",
                "Жуков",
                "Некрасов",
                "Бела",
                "Детков"
        };
        if (sex=="W")
            return lastnamesW;
        else
            return lastnamesM;
    }

    public static String[] fatherName(String sex){
        String[] fathernamesW = {
                "Викторовна",
                "Петровна",
                "Ивановна",
                "Валерьевна",
                "Юрьевна",
                "Максимовна",
                "Романовна",
                "Алексеевна",
                "Александровна",
                "Васильевна"
        };
        String[] fathernamesM = {
                "Викторович",
                "Петрович",
                "Иванович",
                "Валерьевич",
                "Юрьевич",
                "Максимович",
                "Романович",
                "Алексеевич",
                "Александрович",
                "Васильевич"
        };

        if (sex=="W")
            return fathernamesW;
        else
            return fathernamesM;
    }

    public static String[] gender(){
        String[] gender ={"МУЖ","ЖЕН"};
        return gender;
    }

    public static String building(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(99)+1;
        return String.valueOf(randomIndex);
    }

    public static String apartment(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(199)+1;
        return String.valueOf(randomIndex);
    }

    public static String getRandom(String[] myArray) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(myArray.length);
        return myArray[randomIndex];
    }

    public static String randomBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateBD = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        return dateBD.format(formatter);
    }

    public static String age(String DoB){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate DoBLD = LocalDate.parse(DoB,formatter);
        int years = Period.between(DoBLD, LocalDate.now()).getYears();
        return String.valueOf(years);
    }

    public static String towns(){
        String[][]town = {
                {"Орловская область","Орел"},
                {"Воронежская область","Воронеж"},
                {"Московская область","Москва"},
                {"Кабардино-Балкарская Республика","Нальчик"},
                {"Кабардино-Балкарская Республика","Эльбрус"},
                {"Московская область","Серпухов"},
                {"Ленинградская область","Санкт-Петербург"},
                {"Республика Татарстан","Казань"},
                {"Республика Татарстан","Набережные Челны"},
                {"Московская область","Нахабино"}
        };
        String h = town[0][0];
        return h;
    }

    public static int numOfLines(){
        Scanner sc = new Scanner(System.in);
        int n=0;
        while ((n > 30) || (n <= 0)){
            System.out.println("Введите число от 1 до 30 включительно:");
            n = sc.nextInt();
        }
        return n;
    }

    public static void main(String[] args) {

        int n = numOfLines();

        String[][] tableData = getData(n);

        table(tableData);
    }
}