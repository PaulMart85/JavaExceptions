package Seminar3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetPrivateData {

    private static final int COUNT_OF_DATA;

    static String sentPath;
    
    static Scanner sc = new Scanner(System.in);

    static {
        COUNT_OF_DATA = 6; // количество введенных данных
        sentPath = "Seminar3/res/"; // путь на директорию данных
    }

    public static void main(String[] args) {

        while (true) {
            String takenString = takeData();
            
            try {
                PrivateData privateData = verifyData(takenString);
                System.out.println(sendData(privateData));
                break;
            } catch (MyException me) {
                System.out.println(me.getMessage());
            }
            
            System.out.println("Повторить ввод данных? Введите <Abort> для отказа или нажмите <Enter> для подтверждения.");
            if (sc.nextLine().toLowerCase().equals("abort")) break;
        }

        sc.close();
    }

    /**
     * Запрашивает у пользователя данные в произвольном порядке, разделенные пробелом:
     * Фамилия Имя Отчество дата_рождения номер_телефона пол;
     * фамилия, имя, отчество - строки;
     * дата_рождения - строка формата dd.mm.yyyy;
     * номер_телефона - целое беззнаковое число без форматирования;
     * пол - символ латиницей f или m.
     * @return строку с данными пользователя, разделенными пробелом.
     */
    private static String takeData() {
        
        System.out.println("Введите следующие данные в произвольном порядке " + 
                            "в одну строку, разделенные пробелом. По окончании " + 
                            "ввода нажмите ENTER\n" +
                            "При этом Фамилия должна начинаться с прописной буквы, " +
                            "а остальные строчные; " +
                            "имя должно быть записано строчными; а отчествО - " +
                            "строчными и заканчиваться прописной.\n" +   
                            "Фамилия имя отчествО дата_рождения номер_телефона пол");  
        
        return sc.nextLine();
    }

    /**
     * Проверяет введенные данные
     * @param data
     * @return экземпляр класса, содержащего приватные данные.
     * @throws MyException
     */
    private static PrivateData verifyData(String data) throws MyException {

        String[] splittedString = data.split(" ");

        if(splittedString.length < COUNT_OF_DATA)
            throw new MyException(ErrorCode.LESS_DATA);

        if(splittedString.length > COUNT_OF_DATA)
            throw new MyException(ErrorCode.MORE_DATA);

        return parseData(splittedString);

    }

    /**
     * Парсит полученные данные
     * @param data
     * @return экземпляр класса, содержащего приватные данные.
     * @throws MyException
     */
    private static PrivateData parseData(String[] data) throws MyException {

        List<String> list = new ArrayList<>(Arrays.asList(data));
        boolean flag = true;

        PrivateData pd = new PrivateData();
        
        // ищем дату рождения
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        sdf.setLenient(false);
        for (String elem : list) {
            try {
                pd.birthDate = sdf.parse(elem);
            } catch (ParseException e) {
                continue;
            }
            list.remove(elem);
            flag = false;
            break;
        }
        if (flag)
            throw new MyException(ErrorCode.NO_BIRTH_DATE);
        
        // ищем номер телефона
        flag = true;
        for (String elem : list) {
            try {
                pd.phoneNumber = Long.parseUnsignedLong(elem);
            } catch (NumberFormatException e) {
                continue;
            }
            list.remove(elem);
            flag = false;
            break;
        }
        if (flag)
            throw new MyException(ErrorCode.NO_PHONE_NUMBER);

        // ищем гендер
        flag = true;
        for (String elem : list) {
            if (elem.equals("f") || elem.equals("m")) 
                pd.sex = elem.charAt(0);
            else continue;
            
            list.remove(elem);
            flag = false;
            break;
        }
        if (flag)
            throw new MyException(ErrorCode.NO_SEX);

        // ищем ФИО
        // имя
        flag = true;
        for (String elem : list) {
            if (elem.matches("^[a-z]+$"))
                pd.firstName = elem.substring(0, 1).toUpperCase() + elem.substring(1);
            else continue;
            
            list.remove(elem);
            flag = false;
            break;
        }
        if (flag)
            throw new MyException(ErrorCode.NO_FIRST_NAME);

        // фамилия
        flag = true;
        for (String elem : list) {
            if (elem.substring(1).matches("^[a-z]+$") && Character.isUpperCase(elem.charAt(0)))
                pd.lastName = elem;
            else continue;
            
            list.remove(elem);
            flag = false;
            break;
        }
        if (flag)
            throw new MyException(ErrorCode.NO_LAST_NAME);

        // отчество
        String elem = list.get(0);
        if (elem.substring(0, elem.length()-1).matches("^[a-z]+$") && Character.isUpperCase(elem.charAt(elem.length()-1)))
            pd.patronymic = elem.substring(0, 1).toUpperCase() + elem.substring(1, elem.length()-1) + elem.substring(elem.length()-1).toLowerCase();
        else throw new MyException(ErrorCode.NO_PATRONYMIC);            

        return pd;
    }

    /**
     * Записывает полученные данные в файл с названием, равным фамилии
     * @param data
     * @return 'sent', если запись данных произошла успешно.
     * @throws MyException
     */
    private static String sendData(PrivateData data) throws MyException {

        File file = new File(sentPath + data.lastName).getAbsoluteFile();
        String ss = String.format("%s %s %s %s %s %s\n", data.lastName, data.firstName, data.patronymic, 
                    new SimpleDateFormat("dd.mm.yyyy").format(data.birthDate), data.phoneNumber, data.sex);

        try(FileWriter writer = new FileWriter(file, true)) {
            writer.append(ss);
            writer.flush();
        } catch(IOException ex){
            throw new MyException(ErrorCode.WRONG_FILE, ex);
        }

        return "Данные отправлены в файл (закройте его вручную после просмотра, чтобы увидеть обновления): " + file;

    }

}