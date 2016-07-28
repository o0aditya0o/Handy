package com.example.sarthak.share_and_control_it;

/**
 * Created by nikhil on 3/4/16.
 */
public class MouseCoordinate {
    private int x;
    private int y;
    private String cmd;
    MouseCoordinate(int _x, int _y) {
        x = _x;
        y = _y;
        cmd = "";
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getCommand() {
        cmd += "Mm ";
        int digX = 0,digY = 0;
        int n = Math.abs(x);
        if (x == 0) {
            digX = 1;
        }
        if (y == 0) {
            digY = 1;
        }
        while (n > 0) {
            digX++;
            n /= 10;
        }
        n = Math.abs(y);
        while (n > 0) {
            digY++;
            n /= 10;
        }

        if (x >= 0) {
            cmd += "+";
            for (int i = 0; i < 4-digX ; i++) {
                cmd += "0";
            }
            cmd += x + " ";
        }
        else {
            cmd += "-";
            for (int i = 0; i < 4-digX ; i++) {
                cmd += "0";
            }
            cmd += -x + " ";
        }

        if (y >= 0) {
            cmd += "+";
            for (int i = 0; i < 4-digY ; i++) {
                cmd += "0";
            }
            cmd += y + " ";
        }
        else {
            cmd += "-";
            for (int i = 0; i < 4-digY ; i++) {
                cmd += "0";
            }
            cmd += -y + " ";
        }
        return cmd;
    }
}
