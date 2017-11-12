package jsonParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import objects.Person;
import objects.Project;
import objects.Slide;

public class SerializeData {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("mica.json");

			BufferedReader bufferedReader = new BufferedReader(fr);
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(bufferedReader, JsonObject.class);
			ArrayList<Project> projects = JsonParser.getProjects(json);
			HashMap<String, ArrayList<Person>> people = JsonParser.getPeople(json);
			ArrayList<Slide> slides = JsonParser.getSlides(json);
			String aboutUs = JsonParser.getAboutUs(json);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mica.ser"));

			oos.writeObject(projects);
			oos.writeObject(people);
			oos.writeObject(slides);
			oos.writeObject(aboutUs);
			oos.flush();
			oos.close();

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mica.ser"));
			test(ois);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test(ObjectInputStream ois) {
		try {
			ArrayList<Project> projects = (ArrayList<Project>) ois.readObject();
			HashMap<String, ArrayList<Person>> people = (HashMap<String, ArrayList<Person>>) ois.readObject();
			ArrayList<Slide> slides = (ArrayList<Slide>) ois.readObject();
			String aboutUs = (String) ois.readObject();

			for (Project p : projects) {
				System.out.println(p);
			}
			for (Entry<String, ArrayList<Person>> e : people.entrySet()) {
				System.out.println("----------\n" + e.getKey());
				for (Person p : e.getValue()) {
					System.out.println(p);
				}
			}
			for (Slide s : slides) {
				System.out.println(s);
			}
			System.out.println(aboutUs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
