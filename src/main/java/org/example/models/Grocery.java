package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List <String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int number;
        do {
        System.out.println("Listeye eleman eklemek için 1, çıkarmak için 2, çıkmak için ise 0'a basınız.");
        number = scanner.nextInt();
        scanner.nextLine();
            switch (number) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsAdd = scanner.nextLine();

                    addItems(itemsAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsRemove = scanner.nextLine();

                    removeItems(itemsRemove);
                    printSorted();
                    break;
            }
        } while (number != 0);
        System.out.println("Liste tamamlandı.");
        scanner.close();
    }



        public static void addItems(String itemsAdd){
            String[] itemsGetToAdd = itemsAdd.split(",");

            for (String itemGet : itemsGetToAdd) {
                if (!checkItemIsInList(itemGet)) {
                    groceryList.add(itemGet);
                } else {
                    System.out.println("Girilen eleman zaten listede mevcut: " + itemGet);
                }
            }
            printSorted();
        }

        public static void removeItems(String itemsRemove){
            String[] itemsGetToRemove = itemsRemove.split(",");
            for (String itemGet : itemsGetToRemove) {
                if (checkItemIsInList(itemGet)) {
                    groceryList.remove(itemGet);
                } else {
                    System.out.println("Böyle bir eleman zaten listede yok: " + itemGet);
                }
            }
            printSorted();
        }

        private static boolean checkItemIsInList (String item){
            return groceryList.contains(item);
        }

        public static void printSorted () {
            Collections.sort(groceryList);

            System.out.println("Pazar Listesi: ");

            for (String item : groceryList) {
                System.out.println(item);
            }
        }
    }
