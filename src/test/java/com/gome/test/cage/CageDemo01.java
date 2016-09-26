package com.gome.test.cage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.github.cage.Cage;
import com.github.cage.GCage;

public class CageDemo01 {

	public static void main(String[] args) throws IOException {
		Cage cage = new GCage();
		OutputStream os = new FileOutputStream("D:\\a.jpg",false);
		cage.draw(cage.getTokenGenerator().next(), os);
	}
}
