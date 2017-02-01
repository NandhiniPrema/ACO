import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AntColonyMain {

	private final static int MAX_ITERATIONS = 100;
	private final static int ANTS = 10;
	private final static double ALPHA = 0.1;// 3.0;
	private final static double BETA = 2;// 2.0;
	private final static double RHO = 0.1;// 0.01;
	private final static double Q = 0.1;// 2.0;

	public static void main(String[] args) {
		String filename = "testcase.tsp";
		StringBuffer buffer = new StringBuffer();
		try {
			List<String> rawData = readfile(filename, 6);// readfile(filename,
															// 6);
			System.out.println("--------Input Data's----------");
			System.out.println(rawData);
			System.out.println("------------------");
			// converting the data(testcases) as the nodes//
			List<Node> nodes = convertToNodes(rawData);
			AntColony ac = new AntColonyArray();
			// AntColony ac = new AntColonyList();
			// start time by current system time//
			long start = System.currentTimeMillis();
			ac.solve(nodes, MAX_ITERATIONS, ANTS, ALPHA, BETA, RHO, Q);
			System.out.println("time: " + (System.currentTimeMillis() - start));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not read file");
		}
	}

	private static List<String> readfile(String filename, int skip) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		// skip header
		for (int i = 0; i < skip; i++) {
			br.readLine();
		}

		List<String> result = new ArrayList<String>();
		String line = null;
		while ((line = br.readLine()) != null) {
			result.add(line);
		}
		// remove EOF
		result.remove(result.size() - 1);
		br.close();
		return result;
	}

	private static List<Node> convertToNodes(List<String> data) {
		List<Node> nodes = new ArrayList<Node>();
		for (String s : data) {
			String[] tokens = s.split(" ");
			// spliting the data by tokens" "//
			Node node = new Node(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			nodes.add(node);
		}
		return nodes;
	}

}
