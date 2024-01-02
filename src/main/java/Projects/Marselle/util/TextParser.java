package Projects.Marselle.util;

import Projects.Marselle.models.furniture.Delivery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TextParser {

    public static boolean hasOnlyNumbers(String str) {
        // Проверяем, что строка не пуста
        if (str == null || str.length() == 0) {
            return false;
        }

        // Проверяем каждый символ строки
        for (int i = 0; i < str.length(); i++) {
            // Если найден нецифровой символ, возвращаем false
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        // Если все символы строки являются цифрами, возвращаем true
        return true;
    }

    public static void main(String[] args) {
        String str = "adasjkh1";
        String str1 = "dasds";
        String str2 = "232";

        System.out.println(TextParser.hasOnlyNumbers(str));
        System.out.println(TextParser.hasOnlyNumbers(str1));
        System.out.println(TextParser.hasOnlyNumbers(str2));
    }

    public static List<Delivery> parseDeliveries(String text) {

            // Если район 1
            List<Delivery> otherDeliveryList = new ArrayList<>();

            if (text.split(",").length == 1) {
                String[] line = text.split(" ");

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < (line.length - 1); i++) {
                    stringBuilder.append(line[i]);
                    stringBuilder.append(" ");
                }

                String resultPoint = stringBuilder.toString().trim();

                String countOfPoint = line[line.length - 1].trim();

                if (!TextParser.hasOnlyNumbers(countOfPoint)) {

                    System.out.println("Other delivery error");
                    return null;    //TODO здесь лучше исключение выбрасывать
                }
                else {
                    Delivery delivery = new Delivery();

                    delivery.setCount(Integer.parseInt(countOfPoint));
                    delivery.setDate(new Date());
                    delivery.setDistrict(resultPoint);
                    otherDeliveryList.add(delivery);

                    return otherDeliveryList;
//                    System.out.println("Other district - " + resultPoint + ", count - " + countOfPoint);
                }
            }

            //Если районов несколько
            if (text.split(",").length > 1) {
                String[] deliveryList = text.split(",");
                for (String address : deliveryList) {
                    String[] line = address.split(" ");

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < (line.length - 1); i++) {
                        stringBuilder.append(line[i]);
                        stringBuilder.append(" ");
                    }

                    String resultPoint = stringBuilder.toString().trim();

                    String countOfPoint = line[line.length - 1].trim();

                    if (!TextParser.hasOnlyNumbers(countOfPoint)) {
                        System.out.println("Other delivery error");
                        return null; //TODO здесь лучше исключение выбрасывать
                    }
                    else {
                        Delivery delivery1 = new Delivery();

                        delivery1.setCount(Integer.parseInt(countOfPoint));
                        delivery1.setDate(new Date());
                        delivery1.setDistrict(resultPoint);
                        otherDeliveryList.add(delivery1);
//                        System.out.println("Other district - " + resultPoint + ", count - " + countOfPoint);
                    }


                }
            }

            return otherDeliveryList;

    }
}
