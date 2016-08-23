import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WordCount {

    private List list = null;
    private int cutoff;
    private int[] frequency;
    private  String fileName;
    public WordCount(String fileName,int cutoff) throws IOException {
        setName(fileName);
        setThreshold(cutoff);
    }

    public void wordCount() throws IOException {
        String singleLine = "";
        String fullDataFromFile = "";

        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
            singleLine = reader.readLine();

        while (singleLine != null) {
            fullDataFromFile = fullDataFromFile + singleLine;
            singleLine = reader.readLine();
        }
        System.out.println(fullDataFromFile);
        String[] splitStr = fullDataFromFile.split(" ");
        int counter = 0;
        int storeFrequency = 0;
        List<String> list = new ArrayList<>();
        for (String s : splitStr) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        int[] frequency = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < splitStr.length; j++) {
                if (list.get(i).equals(splitStr[j])) {

                    storeFrequency = ++counter;

                }


            }

            frequency[i] = storeFrequency;
            counter = 0;
            this.frequency = frequency;
            this.list = list;
        }

    }
   public  void setName(String filename) throws IOException

   {
       if (checkFilenameEmpty(filename)) {
           if (checkFilenameValid(filename)) {
               if (fileIsDirectory(filename)) {
                   if (checkFileContent(filename)) {
                        this.fileName = filename;
                   }else
                       throw new IllegalArgumentException("File is empty...");
               }else
                   throw new IllegalArgumentException("Is a directory...");
           }else
               throw new FileNotFoundException("Enter valid string ...");
       }
       else
           throw new NullPointerException("file name should not be null..");
   }

   public void setThreshold(int cutoff) throws IOException
   {
      if(!checkCutoffPositive(cutoff)){
          throw new IllegalArgumentException("Threshold cannot be less than zero..");
      }
      this.cutoff=cutoff;
   }
    public static String getFileName()  {

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the name of your file .... ");
        String fileName;

        fileName = reader.nextLine();


        return fileName;
    }

    public static boolean checkFilenameEmpty(String fileName) {

       boolean flag = true;


       if (fileName.isEmpty()) {
           flag = false;

       } else
           flag = true;
       return flag;


   }

    public static boolean checkFilenameValid(String fileName) {
        boolean flag = true;
        File file;
        file = new File(fileName);
        if (!file.exists()) {
            flag = false;

        } else
            flag = true;
        return flag;
    }


    public static boolean checkFileContent(String fileName) {
        boolean flag = true;
        File file;
        file = new File(fileName);
        if (file.length() == 0)
            flag = false;
        else
            flag = true;
        return flag;
    }


    public static boolean fileIsDirectory(String fileName) {
        File file;
        file = new File(fileName);
        boolean flag = true;
        if (file.isDirectory()) {
            flag = false;
        } else
            flag = true;
        return flag;
    }
    /*
    public  int getThreshold() {


        Scanner reader = new Scanner(System.in);
        int threshold = 0;


        System.out.println("please enter threshold");


        threshold = Integer.parseInt(reader.next());

        return threshold;
    }
*/
    public static boolean checkCutoffPositive(int cutoff) {
        boolean flag = true;

        if (cutoff <= 0)
            flag = false;
        else
            flag = true;
        return flag;
    }


    public void display() {
        for (int iterator = 0; iterator < list.size(); iterator++) {
            if (frequency[iterator] >= cutoff)
                System.out.println("Occurrence of " + list.get(iterator) + " is " + frequency[iterator] + " times.");


        }
    }
}