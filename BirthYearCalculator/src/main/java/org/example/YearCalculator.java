package org.example;

    public class YearCalculator {
      public int calculateBirthYear(int currentYear, String age)
        {
            try
            {
                int inputAge = Integer.parseInt(age);
                if (inputAge <0 || inputAge > currentYear)
                {
                    throw new Exception();
                }
                return currentYear - inputAge;
            }catch(Exception e)
            {
                return -1;
            }
        }
        public String printGreetings(String name, int birthYear)
        {
            if (name.isEmpty())
            {
                return "name is required";
            }
            else if(name.length()<200)
            {
                return "Hi " + name + ", Your were born in " + birthYear+".";
            }
            else
            {
                return "It is too long";

            }

        }
    }

