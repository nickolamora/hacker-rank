/**
 * An avid hiker keeps meticulous records of their hikes.
 * During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step.
 * Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude.
 * We define the following terms:
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 */
class CountingValleys {

  public static int countingValleys(int steps, String path) {
    // Write your code here
    int currentElevation = 0;
    int valleyCounter = 0;
    for (char elevationStep : path.toCharArray()) {
      if (elevationStep == 'U') {
        currentElevation += 1;
      }
      if (elevationStep == 'D') {
        currentElevation -= 1;
      }
      if (elevationStep == 'U' && currentElevation == 0) {
        valleyCounter += 1;
      }
    }
    return valleyCounter;
  }

  public static void main(String[] args) {

    System.out.println(CountingValleys.countingValleys(8, "DDUUDDUDUUUD"));
  }
}