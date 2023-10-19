package ua.com.alevel;

import java.util.Random;

public class LoveLetterGenerator {

    public static void main(String[] args) {
        String[] openingLines = {"Дорога", "Люба", "Моя кохана"};
        String[] adjectives = {"чарівна", "найкраща", "унікальна"};
        String[] nouns = {"квіточка", "зірка", "радість"};
        String[] compliments = {"Ти завжди мене зачаровуєш.", "Твоя усмішка - це моє щастя.", "Я безмежно щасливий з тобою."};

        Random random = new Random();

        String openingLine = openingLines[random.nextInt(openingLines.length)];
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String noun = nouns[random.nextInt(nouns.length)];
        String compliment = compliments[random.nextInt(compliments.length)];

        String loveLetter = openingLine + " " + adjective + " " + noun + ",\n" + compliment + "\nТвій назавжди, \n[Ваше ім'я]";

        System.out.println(loveLetter);
    }
}