package ua.com.alevel;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String url = "https://jobs.dou.ua/vacancies/?category=Java";

        try {
            // Отримання вмісту веб-сторінки
            Document document = Jsoup.connect(url).get();

            // Вибір елементів, які містять вакансії
            Elements vacancyElements = document.select("li.l-vacancy");
            System.out.println("vac elements: \n" + vacancyElements.size());

            List<String> vacancies = new ArrayList<>();
            // Перегляд і виведення вакансій
            for (Element vacancyElement : vacancyElements) {
                String title = vacancyElement.select("a.vt").text();
                String company = vacancyElement.select("a.company").text();
                String location = vacancyElement.select("span.cities").text();
                String description1 = vacancyElement.select("div.sh-info").text();
                String vacancyUrl = vacancyElement.select("a.vt").attr("href");

                // Отримання повного опису вакансії за посиланням
                Document vacancyPage = Jsoup.connect(vacancyUrl).get();
                String description2 = vacancyPage.select("div.text").text();

//                System.out.println("Назва: " + title);
//                System.out.println("Компанія: " + company);
//                System.out.println("Місцезнаходження: " + location);
//                System.out.println("Опис: " + description1);
//                System.out.println("Повний опис: " + description2);
//                System.out.println();
                vacancies.add(title);
                vacancies.add(company);
                vacancies.add(location);

            }
//            System.out.println("\n" + vacancies);
            for (String i : vacancies) {
                System.out.println(i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }




}































