package newBegin;

import java.util.Stack;

public class OneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {

        int l = bits.length;
        if (bits.length == 1) {
            return true;
        }
        if (bits[l - 1] == bits[l - 2]) {
            return true;
        }
        int count = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }
        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
