package addparentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		// cache for memorization
		HashMap<String, List<Integer>> cache = new HashMap<String, List<Integer>>();
		return this.helper(input, cache);
	}

	List<Integer> helper(String s, HashMap<String, List<Integer>> cache) {
		if (cache.get(s) != null) {
			return cache.get(s);
		}
		boolean expression = false;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if ("+-*".indexOf(s.charAt(i)) != -1) {
				List<Integer> left = helper(s.substring(0, i), cache);
				List<Integer> right = helper(s.substring(i + 1), cache);
				for (Integer l : left) {
					for (Integer r : right) {
						result.add(cal(l, r, s.charAt(i)));
					}
				}
				expression = true;
			}
		}
		if (!expression) {
			result.add(Integer.parseInt(s));
		}
		cache.put(s, result);
		return result;
	}

	int cal(int l, int r, char op) {
		int result = 0;
		switch (op) {
		case '+':
			result = l + r;
			break;
		case '-':
			result = l - r;
			break;
		case '*':
			result = l * r;
			break;
		default:
			break;
		}
		return result;
	}
}