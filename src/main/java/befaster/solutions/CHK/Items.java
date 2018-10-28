package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
| F    | 10    | 2F get one F free      |
| G    | 20    |                        |
| H    | 10    | 5H for 45, 10H for 80  |
| I    | 35    |                        |
| J    | 60    |                        |
| K    | 80    | 2K for 150             |
| L    | 90    |                        |
| M    | 15    |                        |
| N    | 40    | 3N get one M free      |
| O    | 10    |                        |
| P    | 50    | 5P for 200             |
| Q    | 30    | 3Q for 80              |
| R    | 50    | 3R get one Q free      |
| S    | 30    |                        |
| T    | 20    |                        |
| U    | 40    | 3U get one U free      |
| V    | 50    | 2V for 90, 3V for 130  |
| W    | 20    |                        |
| X    | 90    |                        |
| Y    | 10    |                        |
| Z    | 50    |                        |
+------+-------+------------------------+

 */
public class Items {

    public static final Item A = new Item('A', 50);
    public static final Item B = new Item('B', 30);
    public static final Item C = new Item('C', 20);
    public static final Item D = new Item('D', 15);
    public static final Item E = new Item('E', 40);
    public static final Item F = new Item('F', 10);
    public static final Item G = new Item('G', 20);
    public static final Item H = new Item('H', 10);
    public static final Item I = new Item('I', 35);
    public static final Item J = new Item('J', 60);
    public static final Item K = new Item('K', 80);
    public static final Item L = new Item('L', 90);
    public static final Item M = new Item('M', 15);
    public static final Item N = new Item('N', 40);
    public static final Item O = new Item('O', 10);
    public static final Item P = new Item('P', 50);
    public static final Item Q = new Item('Q', 30);
    public static final Item R = new Item('R', 50);
    public static final Item S = new Item('S', 30);
    public static final Item T = new Item('T', 20);
    public static final Item U = new Item('U', 40);
    public static final Item V = new Item('V', 50);
    public static final Item W = new Item('W', 20);
    public static final Item X = new Item('X', 90);
    public static final Item Y = new Item('Y', 10);
    public static final Item Z = new Item('Z', 50);


    public static final List<Item> allItems = Collections.unmodifiableList(Arrays.asList(
            A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
    ));

}
