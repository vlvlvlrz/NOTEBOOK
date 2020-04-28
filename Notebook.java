package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Ezha.NewNote("1", "11", "10-11-2012");
        Ezha.NewNote("22", "22", "11-11-2012");
        Ezha.NewNote("333", "333", "12-11-2012");
        Ezha.NewNote("4444", "4444", "13-11-2012");
        Ezha.NewNote("55555", "55555", "14-11-2012");
        System.out.println("Выберите действие:\n1. Вывести список заметок\n2. Открыть заметку\n3. Добавить заметку\n4. Удалить заметку");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        while (nAge != 0) {
            switch (nAge) {
                case 1:
                    Ezha.ListNotes();
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Введите заголовок заметки, которую хотите открыть: \n");
                    String sTemp = reader.readLine();
                    Ezha.CheckNote(sTemp);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("Введите:\n1. Заголовок новой заметки\n2. Текст заметки\n3. Дату создания заметки в формате 'ДД-ММ-ГГГГ'\n");
                    String sTemp1 = reader.readLine();
                    String sTemp2 = reader.readLine();
                    String sTemp3 = reader.readLine();
                    Ezha.NewNote(sTemp1, sTemp2, sTemp3);
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("Введите заголовок заметки, которую требуется удалить: ");
                    sTemp = reader.readLine();
                    Ezha.RemoveNote(sTemp);
                    break;

                default:
                    break;
            }
            System.out.println("Выберите действие:\n1. Вывести список заметок\n2. Открыть заметку\n3. Добавить заметку\n4. Удалить заметку");
            sAge = reader.readLine();
            nAge = Integer.parseInt(sAge);
        }
    }
}

 class Ezha
{
    static ArrayList<String> head = new ArrayList<>();
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayList<Integer> dateDay = new ArrayList<>();
    static ArrayList<Integer> dateMonth = new ArrayList<>();
    static ArrayList<Integer> dateYear = new ArrayList<>();


    public static void NewNote(String headline, String addedNote, String addedDate)
    {
        String[] str = new String[3];
        int counter = 0;
        for (String temp : addedDate.split("-")) {
            str[counter] = temp;
            counter++;
        }
        head.add(headline);
        notes.add(addedNote);
        dateDay.add(Integer.parseInt(str[0]));
        dateMonth.add(Integer.parseInt(str[1]));
        dateYear.add(Integer.parseInt(str[2]));

    }

    public static void ListNotes()
    {
        for (int i = 0; i < notes.size(); i++)
        {

            System.out.print("Заголовок: " + head.get(i) + " ");
            System.out.print("Дата создания: " + dateDay.get(i) + "." + dateMonth.get(i) + "." + dateYear.get(i));
            System.out.println();
        }
    }

    public static void CheckNote(String headline)
    {
        System.out.println(notes.get(head.indexOf(headline)));
    }

    public static void RemoveNote(String headline)
    {
        Ezha.dateYear.remove(Ezha.head.indexOf(headline));
        Ezha.dateMonth.remove(Ezha.head.indexOf(headline));
        Ezha.dateDay.remove(Ezha.head.indexOf(headline));
        Ezha.notes.remove(Ezha.head.indexOf(headline));
        Ezha.head.remove(Ezha.head.indexOf(headline));
    }
}
