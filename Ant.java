
import java.util.ArrayList;
import java.util.List;

public class Ant {
	/* trails is stored in the list */

	private List<Integer> trail;

	// index of the node is added in trail//
	public Ant(int indexOfStartNode) {
		trail = new ArrayList<Integer>();
		trail.add(indexOfStartNode);
	}

	public Ant(List<Integer> trail) {
		this.trail = trail;
	}

	public List<Integer> getTrail() {
		return trail;
	}

	public int getCurrentNodeIndex() {
		return trail.get(trail.size() - 1);
	}

	public void addTrailNode(int index) {
		trail.add(index);
	}

	public int getStartNodeIndex() {
		return trail.get(0);
	}

	// trail consists of start and stop//
	public boolean containsTrail(int start, int stop) {
		int index = trail.indexOf(start);
		return index > -1 && trail.get(index + 1) == stop;
	}
}
