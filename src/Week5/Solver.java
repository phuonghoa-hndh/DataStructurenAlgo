package Week5;
import java.util.*;

public class Solver {
//	public class Solver {
//	public Solver(Board initial) // tìm lời giải bằng thuật toán A*
//	public boolean isSolvable() //ma trận ban đầu có giải đượcc k
//	public int moves() // số bước dịch chuyển nếu giải được, k giải được = -1
//	public Iterable<Board> solution() // dãy may trận trong loiwg giải, null nếu k giải được
//	public static void main(String[] args)
//	}
	private boolean isSolvable;
    private Stack<Board> solution = new Stack<Board>();

    private final class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final int moves;
        private final SearchNode previous;

        SearchNode(Board board, SearchNode previous) {
            this.board = board;
            this.previous = previous;

            if (previous == null)
                moves = 0;
            else
                moves = previous.moves + 1;
        }

        private int priority() {
            return board.manhattan() + moves;
        }

        public int compareTo(SearchNode that) {
            return Integer.signum(priority() - that.priority());
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twinpq = new MinPQ<SearchNode>();

        pq.insert(new SearchNode(initial, null));
        twinpq.insert(new SearchNode(initial.twin(), null));

        MinPQ<SearchNode> queue = pq;
        SearchNode node;

        while (true) {
            if (!queue.isEmpty()) {
                node = queue.delMin();

                for (Board neighbor: node.board.neighbors()) {
                    if (node.previous == null || !neighbor.equals(node.previous.board))
                        queue.insert(new SearchNode(neighbor, node));

                if (node.board.isGoal()) {
                    isSolvable = queue == pq;

                    if (!isSolvable) return;

                    while (node != null) {
                        solution.push(node.board);
                        node = node.previous;
                    }

                    return;
                }
            }

            if (queue == pq)
                queue = twinpq;
            else
                queue = pq;
            }
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if no solution
    public int moves() {
        return solution.size() - 1;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() {
        if (isSolvable)
            return solution;
        else
            return null;
    }
    // solve a slider puzzle (given below)
    public static void main(String[] args) {
    	try (// create initial board from a text file
		Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[][] blocks = new int[3][3];
			for(int i =0; i<n; i++) {
				for(int j =0; j<n; j++) {
					blocks[i][j] = sc.nextInt();
				}
			}
			for(int i =0; i<n; i++) {
				for(int j =0; j<n; j++) {
					System.out.println(blocks[i][j] + " ");
				}
				System.out.println();
			}
			Board initial = new Board(blocks);
			// solve the puzzle
			Solver solver = new Solver(initial);
			// print solution to standard output
			if (!solver.isSolvable())
			System.out.println("No solution possible");
			else {
			System.out.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
			System.out.println(board);
			}
		}
    	}
}