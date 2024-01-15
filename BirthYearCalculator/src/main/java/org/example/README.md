In **YearCalculator** class i use two methods
1) The first one is calculateBirthYear method  which takes two parameters
   currentYear and age to calculate birth year by assigning values to age. In this method
   I convert String age to int inputAge and I put the if condition for inputage and inputage should be positive and we can get the positive
   value in the form of years.

   `public int calculateBirthYear(int currentYear, String age)
   {
   try
   {
   int inputAge = Integer.parseInt(age);
   if (inputAge < 0 || inputAge > currentYear)
   {
   throw new Exception();
   }
   return currentYear - inputAge;
   }catch(Exception e)
   {
   return -1;
   }
   }`

2) The second one is PrintGreetings method which takes two parameters name and birtYear
   the method return the string to print greeting.I put if condition for String if string is
   empty then it will print  "name is required" and if String length is less than 200 it will print  greeting.

 `  public String PrintGreetings(String name, int birthYear) 
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
   }`

In the class **BirthYearCalculator**
I imported java.util.Scanner package so program can take user impute and java.util.Calendar package so it can provide current year.
I created class instance yearCalculator and called both methods calculateBirthYear and
printGreetings


1) Below I put if condition on birthYear because if user enters age which is greater than
   current year then birth year will become negative .
   `if (birthYear < 0) {
   System.out.println("invalid age");
   } else {
   System.out.println(yearCalculator.PrintGreetings(name, birthYear));
   }`
                **The class TestBirthYearCalculator** 
                        I wrote 5 test cases

1) In the following test case I tested the method with valid age to check weather
method is functioning correctly by comparing birth year with expected birth year.
This test verifies the  functionality of the birth year calculation.

   `@Test
   TestBirthYearWhenPassValidAge()
   {
   int currentYear = Calendar.getInstance().get(Calendar.YEAR);
   YearCalculator testCalculator=new YearCalculator();
   int result= testCalculator.calculateBirthYear(currentYear,40);
   assertEquals(currentYear-40, result);
   }`
2) This is the case of limitations. In the following test case I tested the method with 
negative age to check how the system handles a negative age. In this case, a negative age
is not valid and unrealistic, and the method is expected to return a specified error code (e.g., -1).
`@Test
TestBirthYearWhenPassNegativeAge()
{
int currentYear = Calendar.getInstance().get(Calendar.YEAR);
YearCalculator testCalculator=new YearCalculator();
int result= testCalculator.calculateBirthYear(currentYear,-40);
assertEquals(-1,result);
}
`
3) In the following test case I tested the method to ensures that the printGreetings method correctly formats the greeting message.
   
  ` public void TestprintGreetings()
   {
   YearCalculator testCalculator=new YearCalculator();
   String result= testCalculator.printGreetings("Dipti",1983);
   assertEquals("Hi Dipti, Your were born in 1983.",result);
   }`
4) In the following test case I tested the method with empty String to check how the code deals with a scenario where the name parameter is empty.In this
case method is expected to return an error message.

   `@Test
   public void TestprintGreetingsWithEmptyName(){
   YearCalculator testCalculator=new YearCalculator();
   String result= testCalculator.printGreetings("",1983);
   assertEquals("name is required",result);
   }`
5) This is the case of limitations. In the following test case I tested the method with age which is greater than current year to ensure that How method deals with a 
scenario where the calculated birth year is not realistic and return a specified error code (e.g., -1).

`@Test
   public void TestAgeWhenPassNumberGreaterThenCurrentYear()
   {
   int currentYear = Calendar.getInstance().get(Calendar.YEAR);
   YearCalculator testCalculator=new YearCalculator();
   int result= testCalculator.calculateBirthYear(currentYear,5000);
   assertEquals(-1,result);
   }`
6) In the following test case I tested the method where I passed String to age and check how the method deals with a non numeric value.
   `@Test
   public void TestBirthYearWhenPassStringAge() {
   int currentYear = Calendar.getInstance().get(Calendar.YEAR);
   YearCalculator testCalculator = new YearCalculator();
   int result = testCalculator.calculateBirthYear(currentYear, "abc");
   assertEquals(-1, result);
`
7) This is the case of limitation. In the following method I tested how method will deal when name lenght is longer then allowed.
   `@Test
   public void TestPrintGreetingsInvalidLengthOfName() {
   YearCalculator testCalculator = new YearCalculator();
   String result = testCalculator.printGreetings("Hi im Dipti .I am going to show a very big name, which contains more then 200 charecters and will show you a massage .Hi i am Dipti .I am going to show a very big name, which contains more then 200 charecters and will show you  a massage ", 1983);
   assertEquals("It is too long", result);
   }`
