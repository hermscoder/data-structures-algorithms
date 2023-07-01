package com.hermscoder.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable myHt = new HashTable();

        myHt.set("nails", 100);
        myHt.set("tile", 50);
        myHt.set("lumber", 80);

        myHt.set("bolts", 200);
        myHt.set("screws", 140);

        myHt.printTable();

        System.out.println("Keys:");
        System.out.println(myHt.keys());
    }
}

/* EXPECTED OUTPUT

0:
1:
2:
3:
	{ screws:140 }
4:
	{ bolts:200 }
5:
6:
	{ nails:100 }
	{ tile:50 }
	{ lumber:80 }
Keys:
[screws, bolts, nails, tile, lumber]
 */