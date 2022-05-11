import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void pdf(int n) {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(com.itextpdf.text.PageSize.A4.rotate());

        Font font = com.itextpdf.text.FontFactory.getFont("C:/Windows/Fonts/arial.ttf", "cp1251", com.itextpdf.text.pdf.BaseFont.EMBEDDED, 8);
        try (FileOutputStream fs = new FileOutputStream("People-Table.pdf")) {
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, fs);

            document.open();

            com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(14);

            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Имя", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Фамилия", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Отчесвто", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Возраст", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Пол", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Дата рождения", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Место рождения", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Индекс", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Страна", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Область", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Город", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Улица", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Дом", font)));
            table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Квартира", font)));
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            table.setSpacingAfter(10f);

            for (int i = 0; i < n; i++) {

                String DoB = randomBirthday();
                String gender = getRandom(gender());

                String[] tAs = townsAndStates();

                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(getRandom(name(gender)), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(getRandom(lastName(gender)), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(getRandom(fatherName(gender)), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(age(DoB), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(gender, font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(DoB, font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(getRandom(towns(), 1), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(index(), font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("Россия", font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(tAs[0], font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(tAs[1], font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph("k", font)));
                table.addCell(new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Paragraph(building(), font)));
                table.addCell(new PdfPCell(new com.itextpdf.text.Paragraph(apartment(), font)));
            }

            document.add(table);

            document.close();
        }
        catch (DocumentException exc) {
        }
        catch (IOException exc) {
        }
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
        if (sex.equals("ЖЕН"))
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
        if (sex.equals("ЖЕН"))
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

        if (sex.equals("ЖЕН"))
            return fathernamesW;
        else
            return fathernamesM;
    }

    public static String[] gender(){
        String[] gender ={"МУЖ","ЖЕН"};
        return gender;
    }

    public static String[] townsAndStates(){
        String[] tAndS = getRandom(towns());
        return tAndS;
    }

    public static String[][] towns(){
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
        return town;
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

    public static String getRandom(String[][] myArray, int column) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(myArray.length);
        return myArray[randomIndex][column];
    }

    public static String[] getRandom(String[][] myArray) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(myArray.length);
        return myArray[randomIndex];
    }

    public static String index(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(999998)+1;
        return String.valueOf(randomIndex);
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

        pdf(n);
    }
}