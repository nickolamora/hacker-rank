/**
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or .
 * The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
 * It is always possible to win the game.
 * <p>
 * For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.
 */
public class JumpingOnTheClouds {

  static int firstCumulusCloud(int[] c) {

    int cloudPathLength = c.length;
    int firstCumulusCloudIndex = 0;
    switch (cloudPathLength) {
      case 0:
        firstCumulusCloudIndex = -1;
        break;
      case 1:
        if (c[0] == 0) {
          firstCumulusCloudIndex = 0;
        } else {
          firstCumulusCloudIndex = -1;
        }
        break;
      default:
        boolean traversing = true;
        while (traversing) {
          for (int i = 0; i < cloudPathLength - 1; i++) {
            if (c[i] == 0) {
              firstCumulusCloudIndex = i;
              traversing = false;
            }
          }
        }
    }
    return firstCumulusCloudIndex;
  }

  static int jumpingOnClouds(int[] c) {

    int path = 0;
    int cloudPathLength = c.length;

    switch (cloudPathLength) {
      case 0:
        path = -1;
        break;
      case 1:
        if (c[0] == 0) {
          path = 0;
        } else if (c[0] == 1) {
          path = -1;
        }
        break;
      case 2:
        if (c[0] == 0 && c[1] == 0) {
          path = 1;
        } else if (c[0] == 0 && c[1] == 1) {
          path = 0;
        } else if (c[0] == 1 && c[1] == 0) {
          path = 0;
        } else if (c[0] == 1 && c[1] == 1) {
          path = -1;
        }
        break;
      default:
        int firstCumulusCloud = firstCumulusCloud(c);
        boolean traversing = true;
        int currentCloudIndex = firstCumulusCloud;
        while (traversing) {
          if (currentCloudIndex == cloudPathLength - 1) {
            traversing = false;
          } else if ((currentCloudIndex + 1) <= cloudPathLength - 1 && c[currentCloudIndex + 1] == 1) {
            traversing = false;
          } else if ((currentCloudIndex + 2) <= cloudPathLength - 1 && c[currentCloudIndex + 2] == 1) {
            traversing = false;
          } else {
            if ((currentCloudIndex + 2) <= cloudPathLength - 1 && c[currentCloudIndex + 2] == 0) {
              currentCloudIndex = currentCloudIndex + 2;
              path += 1;
            } else if ((currentCloudIndex + 1) <= cloudPathLength - 1 && c[currentCloudIndex + 1] == 0) {
              currentCloudIndex = currentCloudIndex + 1;
              path += 1;
            }
          }
        }
    }
    return path;
  }

  public static void main(String[] args) {

    System.out.println(JumpingOnTheClouds.jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0}));
  }
}
