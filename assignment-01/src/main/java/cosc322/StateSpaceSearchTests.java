package cosc322;

import ygraph.ai.state_space_search.ActionFactory;
import ygraph.ai.state_space_search.BestFirstSearch;
import ygraph.ai.state_space_search.sliding_puzzle.StateNPuzzle;
import cosc322.sliding_puzzle.*;


public class StateSpaceSearchTests {
	
	public static void main(String[] args){
		int N = 8;
		int n = 3;
		
		int[][] g = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
		//int[][] a = {{3, 6, 0}, {2, 7, 4}, {1, 8, 5}};
		int[][] a = {{1, 2, 5}, {3, 4, 8}, {6, 7, 0}};
		
		StateNPuzzle goal = new StateNPuzzle(N, g);
		//System.out.println(goal);
		
		StateNPuzzle start = new StateNPuzzle(N, a);
		//System.out.println(start);
		
		StateSpaceNPuzzle sp = new StateSpaceNPuzzle(N); 
		
		//ActionFactory for standard N-puzzle. Change to ActionFactoryRelaxedNPuzzle 
		//that you implemented for the Gaschnig puzzle      
		ActionFactory<StateNPuzzle> actionFac = new ActionFactoryNPuzzle();
 
		sp.setActionFactory(actionFac);
		
		sp.setGoalState(goal);
		sp.setInitialState((StateNPuzzle) start);
		
		
		BestFirstSearch<StateNPuzzle> bfs = new BestFirstSearch<>(sp);
		String res = bfs.startSearchSession(true); // true to turn the tracer on
		System.out.println(res);
		 
	}

}
