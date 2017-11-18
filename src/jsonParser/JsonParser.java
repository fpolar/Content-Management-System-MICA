package jsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import objects.*;

public class JsonParser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileReader fr = new FileReader("mica.json");
		BufferedReader bufferedReader = new BufferedReader(fr);
		Gson gson = new Gson();
		JsonObject json = gson.fromJson(bufferedReader, JsonObject.class);
		ArrayList<Project> projects = getProjects(json);
		HashMap<String, ArrayList<Person>> people = getPeople(json);
		ArrayList<Slide> slides = getSlides(json);
		ArrayList<Page> pages = getPages(json);
		String aboutUs = getAboutUs(json);

		printInfo(projects, people, slides, aboutUs);

		HttpSession session = request.getSession();

		session.setAttribute("projects", projects);
		session.setAttribute("people", people);
		session.setAttribute("slides", slides);
		session.setAttribute("aboutUs", aboutUs);

		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

	public static void setAttributesFromJson(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("/mica.json");
			 System.out.println("path - "+path);
			FileReader fr = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fr);
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(bufferedReader, JsonObject.class);
			ArrayList<Project> projects = JsonParser.getProjects(json);
			HashMap<String, ArrayList<Person>> people = JsonParser.getPeople(json);
			ArrayList<Slide> slides = JsonParser.getSlides(json);
			String aboutUs = JsonParser.getAboutUs(json);

			HttpSession session = request.getSession();

			session.setAttribute("projects", projects);
			session.setAttribute("people", people);
			session.setAttribute("slides", slides);
			session.setAttribute("aboutUs", aboutUs);
		} catch (IOException e) {
			System.out.println("error in setAttributesFromJson - " + e.getMessage() + "\n" + request.getContextPath());
		}
	}

	private void printInfo(ArrayList<Project> projects, HashMap<String, ArrayList<Person>> people,
			ArrayList<Slide> slides, String aboutUs) {
		System.out.println("----------\nPROJECTS\n");
		for (Project p : projects) {
			System.out.println(p);
		}
		System.out.println("----------\nPEOPLE\n");
		for (Entry<String, ArrayList<Person>> e : people.entrySet()) {
			System.out.println("----------\n" + e.getKey());
			for (Person p : e.getValue()) {
				System.out.println(p);
			}
		}
		System.out.println("----------\nSLIDES\n");
		for (Slide s : slides) {
			System.out.println(s);
		}
		System.out.println("----------\nABOUT US\n" + aboutUs);
	}

	/*
	 * Takes The JSON object(containing entire files data) and returns an arraylist
	 * of projects from that json file
	 */
	public static ArrayList<Project> getProjects(JsonObject json) {
		ArrayList<Project> out = new ArrayList<Project>();
		JsonArray projects = json.getAsJsonArray("projects");
		for (JsonElement p : projects) {
			JsonObject project = p.getAsJsonObject();
			String title = project.get("title").getAsString();
			String desc = project.get("description").getAsString();
			ArrayList<String> instructions = getInstructions(project);
			ArrayList<Demo> demos = getDemos(project);
			Project temp = new Project(title, desc);
			temp.setInstructions(instructions);
			temp.setDemos(demos);
			out.add(temp);
		}
		return out;
	}
	/*
	 * Takes The JSON object(containing entire files data) and returns an arraylist
	 * of pages from that json file
	 */
	public static ArrayList<Page> getPages(JsonObject json) {
		ArrayList<Page> out = new ArrayList<Page>();
		JsonArray pages = json.getAsJsonArray("pages");
		for (JsonElement p : pages) {
			JsonObject page = p.getAsJsonObject();
			String title = page.get("title").getAsString();
			String link = page.get("link").getAsString();
			Page temp = new Page(title, link);
			out.add(temp);
		}
		return out;
	}

	/*
	 * takes a jsonObject representing a project field in the labs json file and
	 * returns an array with that projects instruction set
	 */
	private static ArrayList<String> getInstructions(JsonObject project) {
		ArrayList<String> out = new ArrayList<String>();
		JsonArray instructions = project.getAsJsonArray("instructions");
		int num = 1;
		for (JsonElement i : instructions) {
			JsonObject instruction = i.getAsJsonObject();
			out.add(instruction.get("" + num++).getAsString());
		}
		return out;
	}

	/*
	 * takes a jsonObject representing a project field in the labs json file and
	 * returns an array with that projects set of demos
	 */
	private static ArrayList<Demo> getDemos(JsonObject project) {
		ArrayList<Demo> out = new ArrayList<Demo>();
		JsonArray demos = project.getAsJsonArray("demos");
		for (JsonElement d : demos) {
			JsonObject demo = d.getAsJsonObject();
			String type = demo.get("type").getAsString();
			String title = demo.get("title").getAsString();
			String id = demo.get("id").getAsString();
			Demo temp;
			if (type.equals("iframe")) {
				String iframe = demo.get("iframe").getAsString();
				temp = new iframeDemo(type, title, id, iframe);
			} else if (type.equals("script_iframe")) {
				String iframe = demo.get("iframe").getAsString();
				String script = demo.get("script").getAsString();
				temp = new script_iframeDemo(type, title, id, iframe, script);
			} else if (type.equals("video")) {
				String link = demo.get("link").getAsString();
				temp = new videoDemo(type, title, id, link);
			} else {
				temp = new Demo(type, title, id);
			}
			out.add(temp);
		}
		return out;
	}

	/*
	 * Takes The JSON object(containing entire files data) and returns a hashmap
	 * with the key being a string with the type of person and the value is an
	 * arraylist of people of that type
	 */
	public static HashMap<String, ArrayList<Person>> getPeople(JsonObject json) {
		HashMap<String, ArrayList<Person>> out = new HashMap<String, ArrayList<Person>>();
		JsonArray personGroups = json.getAsJsonArray("people");
		for (JsonElement pg : personGroups) {
			JsonObject personGroup = pg.getAsJsonObject();
			String type = personGroup.get("type").getAsString();
			JsonArray people = personGroup.get("personList").getAsJsonArray();

			ArrayList<Person> tempArray = new ArrayList<Person>();
			for (JsonElement p : people) {
				JsonObject person = p.getAsJsonObject();
				String name = person.get("name").getAsString();
				String img = person.get("img").getAsString();
				String title = person.get("title").getAsString();
				String school = person.get("school").getAsString();
				String contact = person.get("contact").getAsString();
				Person temp = new Person(name, img, title, school, contact);
				tempArray.add(temp);
			}
			out.put(type, tempArray);
		}
		return out;
	}

	/*
	 * Takes The JSON object(containing entire files data) and returns an arraylist
	 * of slides from that json file
	 */
	public static ArrayList<Slide> getSlides(JsonObject json) {
		ArrayList<Slide> out = new ArrayList<Slide>();
		JsonArray slides = json.get("slides").getAsJsonArray();
		for (JsonElement s : slides) {
			JsonObject slide = s.getAsJsonObject();
			String name = slide.get("name").getAsString();
			String img = slide.get("img").getAsString();
			String desc = slide.get("desc").getAsString();
			Slide temp = new Slide(name, img, desc);
			out.add(temp);
		}
		return out;
	}

	/*
	 * Takes The JSON object(containing entire files data) and returns a string with
	 * the about us information of the lab
	 */
	public static String getAboutUs(JsonObject json) {
		return json.get("aboutUs").getAsString();
	}
}
