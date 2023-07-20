package FITBUDDY;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Details implements General
{

    static float weight, height, goalweight, BMI;
    static int goal, active, gender, weeklygoal, age, helpful1=0, health=0, fit=0;
    static String name, country;
    Details() {}
    Details(String name, int gender, float weight, float height, int age) throws IOException
    {
        this.age= age;
        this.height= height;
        this.weight= weight;
        this.gender= gender;
        this.name= name;
    System.out.println("\nWELCOME TO FITBUDDY\n");
    System.out.println("Easily view diet and exercise tips, learn how to lead a healthy life.\n");
    System.out.println("Keep your goals in view and stay motivated!\n");
    System.out.println("Reach your health and fitness goals without the struggle!\n");
    System.out.println("Name: "+ name);
    System.out.println("Age: " + age);
    System.out.println("Height: " + height);
    System.out.println("Weight: " + weight);
    calculate();
    display();
    }
    public void display()
    {
        int a=0, b=0, c=0;
        int choice=0;
        while(choice!=5)
        {
        System.out.println("\n\n1. HEALTH TIPS\t 2. FITNESS TIPS\t 3. MY BMI ANALYSIS\t 4. FEEDBACK\t 5.EXIT\n");
        System.out.println("At FitBuddy, we have compiled a set of articles and tips to get you started on your journey based on the information you have provided us. \n");
        System.out.println("Enter your choice: \n");
        Scanner get= new Scanner(System.in);
        choice= get.nextInt();
        switch(choice)
        {
            case 1: Health ch= new Health();
                    ch.feedback();
                    ch.display();
                    break;
            case 2: Fitness fi= new Fitness();
                    fi.display();
                    fi.feedback();
                    break;
            case 3: bmi_analysis();
                    feedback();
                    break;
            case 4: Feedback ob= new Feedback();
                    break;
            case 5: System.out.println("Thank you for using FITBUDDY!");
                    return;
        }
        }
    }
    static void bmi_analysis()
    {
        System.out.println("YOUR BMI IS: "+ BMI);
            if(BMI<18.5)
                System.out.println("A BMI below 18.5 is considered underweight.\n ");
            else if (BMI<24.9 && BMI>=18.5)
                System.out.println("A BMI of 18.5 to 24.9 is considered healthy.\n");
            else if (BMI>25 && BMI<29.9)
                System.out.println("A BMI of 25 to 29.9 is considered overweight.\n");
            else if(BMI>=30)
                System.out.println("A BMI of 30 or higher is considered obese.\n");
                int i = 0;
        FileInputStream fin = null;
            try
            {
                        fin= new FileInputStream("bmianalysis.txt");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File Not Found\n");
                return;
            }
            do
            {
                try {
                    i= fin.read();
                } catch (IOException ex) {
                    Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(i!=-1)
                    System.out.print((char) i);
            }while(i!=-1);
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
     void calculate()
     {
        float heightm;
        heightm= height/100;
        BMI = weight/ (heightm*heightm);
        System.out.println("YOUR BMI IS: "+ BMI);
     }
     public int feedback()
         {
             System.out.println("\n\n Please give us your feedback on the above information displayed?\n");
             System.out.println("1. Quite Helpful \t 2. Very Helpful \t 3. Not Helpful\n ");
             Scanner in= new Scanner(System.in);
             helpful1= in.nextInt();
             System.out.println("Thank you for your feedback!\n");
             return helpful1; 
         }   
}

interface General
{
    void display();
    int feedback();
}

class Health extends Details implements General
{
    int adult=0;
    public void display()
    {
        System.out.println("Hello, " + name+ "! Welcome to the Health Section!\n");
        System.out.println("Here, you will learn all that you need to maintain a good, nutritious life\n");
        System.out.println("We will display a few health tips based on the information that you have provided us.\n");
        int i = 0;
        FileInputStream fin = null;
            try
            {

                if(age<15)
                        fin= new FileInputStream("childrenhealth.txt");
                else if(age>=65)
                        fin= new FileInputStream("healthseniors.txt");
                else
                {
                    if(gender==1)
                        fin= new FileInputStream("healthmen.txt");
                    else if(gender==2)
                        fin= new FileInputStream("healthwomen.txt");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File Not Found\n");
                return;
            }
            do
            {
                try {
                    i= fin.read();
                } catch (IOException ex) {
                    Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(i!=-1)
                    System.out.print((char) i);
            }while(i!=-1);
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        public int feedback()
         {
             System.out.println("\n\n Please give us your feedback on the above information displayed?\n");
             System.out.println("1. Quite Helpful \t 2. Very Helpful \t 3. Not at all Helpful\n ");
             Scanner in= new Scanner(System.in);
             health= in.nextInt();
             System.out.println("Thank you for your feedback!\n");
             return health;

         }
    }
class Fitness extends Details
{
    int helpful=0;
    public void display()
    {
        System.out.println("Hello, " + name+ "! Welcome to the Fitness Section!\n");
        System.out.println("FitBuddy will guide you through various custom workouts and other exercise tips that will guide you through your journey!\n");
        System.out.println("We will display a few articles based on the information that you have provided us.\n");
        int i = 0;
        FileInputStream fin = null;
            try
            {

                if(age<15)
                        fin= new FileInputStream("fitkids.txt");
                else if(age>=65)
                        fin= new FileInputStream("fitseniors.txt");
                else
                {
                    if(gender==1)
                        fin= new FileInputStream("fitnessmen.txt");
                    else if(gender==2)
                        fin= new FileInputStream("fitnesswomen.txt");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File Not Found\n");
                return;
            }
            do
            {
                try {
                    i= fin.read();
                } catch (IOException ex) {
                    Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(i!=-1)
                    System.out.print((char) i);
            }while(i!=-1);
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         public int feedback()
         {
             System.out.println("\n\n Please give us your feedback on the above information displayed?\n");
             System.out.println("1. Quite Helpful \t 2. Very Helpful \t 3. Not Helpful\n ");
             Scanner in= new Scanner(System.in);
             fit= in.nextInt();
             System.out.println("Thank you for your feedback!\n");
             return fit;
         }
    }

class Feedback extends Details
{
    String feed;
    Feedback()
    {
          try{
                     PrintWriter writer = new PrintWriter(new FileWriter("feedback.txt", true));
                     if(health==1)
                             writer.println("\n" + name + " found Health Tips quite helpful.\n");
                         if(health==2)
                             writer.println(name + " found Health Tips very helpful.\n");
                         if(health==3)
                             writer.println(name + " did not find Health Tips helpful.\n");
                         if(fit==1)
                             writer.println(name + " found Fitness Tips quite helpful.\n");
                         if(fit==2)
                             writer.println(name + " found Fitness Tips very helpful.\n");
                         if(fit==3)
                             writer.println(name + " did not find Fitness Tips helpful.\n");
                         if(helpful1==1)
                             writer.println(name + " found BMI Information quite helpful.\n");
                         if(helpful1==2)
                             writer.println(name + " found BMI Information very helpful.\n");
                         if(helpful1==3)
                             writer.println(name + " did not find BMI Information helpful.\n");
                     System.out.println("Please give us your general feedback so we can improve our system and make it better: \n");
                     Scanner in= new Scanner(System.in);
                     feed= in.nextLine();
                     writer.println("General Feedback: \n");
                     writer.println(feed + "\n");
                     writer.close();
                } catch (IOException e) {
                            System.out.println("File not created\n");
                    }
    }
}





public class Register extends Details 
{
    public static void main(String args[]) throws IOException
    {
    }
}

