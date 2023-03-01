package org.yg.Efimenko3;

public class EndOfLessons {
    public void timeOfLesson(int lessonNumber) {
        int start = 9 * 60;
        int countOfBreaks = lessonNumber - 1;
        int minutesOfDay = start + countOfBreaks * 5 + ((countOfBreaks / 2) * 10) + lessonNumber * 45;
        int hours = minutesOfDay / 60;
        int minutes = minutesOfDay - (hours * 60);
        System.out.println("end of lessons - " + hours + " : " + minutes);
    }
}
