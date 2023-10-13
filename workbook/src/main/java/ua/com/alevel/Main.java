package ua.com.alevel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String url = "https://jobs.dou.ua/vacancies/?category=Java";

        try {
            // Отримання вмісту веб-сторінки
            Document document = Jsoup.connect(url).get();

            // Вибір елементів, які містять вакансії (припустимо, що вони розміщені в елементах div з певним класом)
            Elements vacancyElements = document.select("div.l-items#vacancyListId");

            // Перегляд і виведення вакансій
            for (Element vacancyElement : vacancyElements) {
                // Отримання тексту або атрибутів для вакансії, наприклад:
                String title = vacancyElement.select("h2").text();
                String company = vacancyElement.select("p.company").text();
                String location = vacancyElement.select("p.location").text();

                System.out.println("Назва: " + title);
                System.out.println("Компанія: " + company);
                System.out.println("Місцезнаходження: " + location);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }



}































