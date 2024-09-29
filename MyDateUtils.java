class MyDateUtils { 
  public static boolean isWeekEnd(String aDate) {
      // Runtime validation for production
      if (!isValidDate(aDate)) {
          throw new IllegalArgumentException("Invalid date passed to isWeekEnd");
      }
      
      // Assertion for development
      assert isValidDate(aDate) : "Invalid date passed to isWeekEnd";
  
      // Proceed with the logic once the input is validated
      return dayOfTheWeek(aDate) == SUNDAY || dayOfTheWeek(aDate) == SATURDAY;
  }
  
  private static int dayOfTheWeek(String aDate) {
      // Development-time assertion to ensure the method is called with valid input
      assert isValidDate(aDate) : "Invalid date passed to dayOfTheWeek";
      
      // Logic to calculate and return the day of the week
      // Assuming SUNDAY = 1, MONDAY = 2, ..., SATURDAY = 7
      return calculateDayOfWeek(aDate);  // Placeholder for actual logic
  }
}
