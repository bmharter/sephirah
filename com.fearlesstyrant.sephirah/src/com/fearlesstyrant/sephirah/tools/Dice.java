package com.fearlesstyrant.sephirah.tools;

import java.io.IOException;
import java.util.Random;

import org.random.api.RandomOrgClient;
import org.random.api.exception.RandomOrgBadHTTPResponseException;
import org.random.api.exception.RandomOrgInsufficientBitsError;
import org.random.api.exception.RandomOrgInsufficientRequestsError;
import org.random.api.exception.RandomOrgJSONRPCError;
import org.random.api.exception.RandomOrgKeyNotRunningError;
import org.random.api.exception.RandomOrgRANDOMORGError;
import org.random.api.exception.RandomOrgSendTimeoutException;

public class Dice {
	
	private static final String key = "27f01b94-7020-489f-bec2-21bcc534aae0";
	private static final int MIN = 1;
	
	private Dice() {
		
	}
	
	/**
	 * Simulates a dice roll where the results of each die are summed together.
	 * mod: modifier to add to final result.
	 * num: number of dice to roll.
	 * size: type of die, e.g. a d6, a d12, etc.
	 * @param mod
	 * @param num
	 * @param size
	 * @return
	 */
	

	
	public static int roll(int mod, int num, int size) {
		int result = 0;
		
		int[] rolls = DiceRng.getSource().ints(num, 1, size);
		
		//int[] rolls = trueRandom(num, MIN, size);
		
		if(rolls != null) {
			for(int face : rolls) {
				result += face;
			}
			
			return result;
		}
		
		
		Random die = new Random();
		
		
		for(int i = 1; i <= num; i++) {
			result += die.nextInt(size) + 1;
		}
		
		result += mod;
		
		return result;
	}
	
	public static int roll(int num, int size) {
		int result = 0;
		
		int[] rolls = trueRandom(num, MIN, size);
		
		if(rolls != null) {
			for(int face : rolls) {
				result += face;
			}
			
			return result;
		}
		
		Random die = new Random();

		
		for(int i = 1; i <= num; i++) {
			result += die.nextInt(size) + 1;
		}
		
		return result;
	}
	
	/** Simulates a dice roll with multiple types. In the Int[] ints, every even index contains 
	 * the number of the die, and every following odd index should contain their size.
	 * @param mod
	 * @param ints
	 * @return
	 */
	public static Integer roll(int mod, int...ints) {
		if(ints.length % 2 == 0) {
			System.out.print("Must have both a quantity and size for each die.");
			return null;
		}
		
		int[] rolls = ints;
		
		int result = 0;
		
		for(int i = 0; i < rolls.length; i += 2) {
			int [] roll = trueRandom(rolls[i], MIN, rolls[i+1]);
			
			if(roll != null) {
				for(int num : roll) {
					result += num;
				}
			}
		}
		
		if(result > 0) {
			result += mod;
			
			return result;
		} else if(result < 0) {
			result = 0;
		}
		
		Random die = new Random();
		
		for(int i = 0; i < ints.length; i+=2) {
			if(ints[i] != 0) {
				for(int j = 1; j <= ints[i]; j++) {
					result += die.nextInt(ints[i+1]) + 1;
				}
			} else {
				result += ints[i+1];
			}
		}
		
		result += mod;
		
		return result;
	}
	
	public static Integer roll(int...ints) {
		
		int[] rolls = ints;
		
		int result = 0;
		
		for(int i = 0; i < rolls.length; i += 2) {
			int [] roll = trueRandom(rolls[i], MIN, rolls[i+1]);
			
			if(roll != null) {
				for(int num : roll) {
					result += num;
				}
			}
		}
		
		if(result > 0) {
			return result;
		} else if(result < 0) {
			result = 0;
		}
		
		Random die = new Random();

		
		if(ints.length % 2 != 0) {
			System.out.print("Must have both a quantity and size for each die.");
			return null;
		} else {
			for(int i = 0; i < ints.length; i+=2) {
				if(ints[i] != 0) {
					for(int j = 1; j <= ints[i]; j++) {
						result += die.nextInt(ints[i+1]) + 1;
					}
				} else {
					result += ints[i+1];
				}
			}
			
			return result;
		}
	}
	
	public static int roll(int mod, Integer[][] ints) {
		Integer[][] rolls = ints;
		
		int result = 0;
		boolean hasNull = false;

		for(int i = 0; i < rolls.length; i++) {
			for(int j = 0; j < ints[i].length; j++) {
				if(rolls[i][j] == null) {
					hasNull = true;
				}
			}
		}
		
		if(hasNull == true) {
			System.out.print("Must have both a quantity and size for each die.");
			return -1;
		} 
		
		int[] roll = null;
		
		for(int i = 0; i < ints.length; i++) {
			roll = trueRandom(rolls[i][0], MIN, rolls[i][1]);
			
			for(int value : roll) {
				result += value;
			}
		}
		
		
		
		if(result > 0) {
			result += mod;
			return result;
		} else {
			result = 0;
		}
		
		Random die = new Random();
		
		for(int i = 0; i < ints.length; i++) {
			if(ints[i][0] > 0) {
				for(int j = 0; j <= ints[i][0]; j++) {
					result += die.nextInt(ints[i][1]) + 1;
				}
			} else {
				result += ints[i][1];
			}
		}
		result += mod;
		
		return result;
		
	}
	
	public static Integer roll(Integer[][] ints) {
		Random die = new Random();
		int result = 0;
		boolean hasNull = false;
		
		for(int i = 0; i < ints.length; i++) {
			for(int j = 0; j < ints[i].length; j++) {
				if(ints[i][j] == null) {
					hasNull = true;
				}
			}
		}
		
		if(hasNull == true) {
			System.out.print("Must have both a quantity and size for each die.");
			return null;
		} else {
			for(int i = 0; i < ints.length; i++) {
				if(ints[i][0] != 0) {
					for(int j = 0; j <= ints[i][0]; j++) {
						result += die.nextInt(ints[i][1]) + 1;
					}
				} else {
					result += ints[i][1];
				}
			}

			return result;
		}
	}
	
	public static int rollD6() {
		Random die = new Random();
		int result = die.nextInt(6) + 1;
		
		return result;
	}
	
	public static int rollD20() {
		Random die = new Random();
		int result = die.nextInt(20) + 1;
		
		return result;
	}
	
	public static int rollAbilityScore() {
		int a = rollD6();
		int b = rollD6();
		int c = rollD6();
		int d = rollD6();
		int result = 0;
		
		int[] rolls = new int[4];
		rolls[0] = a;
		rolls[1] = b;
		rolls[2] = c;
		rolls[3] = d;
		
		int ones = 0;
		
		for(int i : rolls) {
			if(rolls[i] == 1) {
				ones++;
			}
		}
		
		if(ones > 1) {
			rolls = rerollOnes(ones, rolls);	
		}
		
		rolls = removeLowest((rolls));
		
		result = sumRolls(rolls);
		
		return result;
	}
	
	private static int[] rerollOnes(int ones, int[] rolls) {
		int [] rerolls;	
		int idx = 0;
		

		rerolls = new int[ones];
			
		for(int i : rolls) {
			if(rolls[i] == 1) {
				rerolls[idx] = rolls[i];
				idx++;
			}
		}
			
		for(int i = 0; i < rerolls.length - 1; i++) {
			while(rolls[rerolls[i]] == 1) {
				rolls[rerolls[i]] = rollD6();
			}
		}
		
		return rolls;
	}
	
	private static int[] removeLowest(int[] rolls) {
		int[] lastRolls = new int[rolls.length - 1];
		int idx = 101;
		
		for(int i : rolls) {
			if(idx > rolls[i]) {
				idx = i;
			}
		}
		
		for(int i : rolls) {
			int j = 0;
			
			if(i == idx) {
				continue;
			} else {
				lastRolls[j] = rolls[i];
				j++;
			}
		}
		
		return lastRolls;
	}
	
	
	public static int sumRolls(int[] rolls) {
		
		int result = 0;
		
		for(int i : rolls) {
			result = result + rolls[i];
		}
		
		return result;
	}
	
	public static int sumRolls(Integer[] rolls) {
		
		int result = 0;
		
		for(int i : rolls) {
			result = result + rolls[i];
		}
		
		return result;
	}
	
	static int[] trueRandom(int num, int min, int max) {
		RandomOrgClient dice = RandomOrgClient.getRandomOrgClient(key);
		
		int[] rolls = null;
		
		try {
			rolls = dice.generateIntegers(num, min, max);
		} catch (RandomOrgSendTimeoutException | RandomOrgKeyNotRunningError | RandomOrgInsufficientRequestsError
				| RandomOrgInsufficientBitsError | RandomOrgBadHTTPResponseException | RandomOrgRANDOMORGError
				| RandomOrgJSONRPCError | IOException e) {
			System.out.println("Something went wrong in trueRandom()");
			e.printStackTrace();
		}
		
		return rolls;
	}
}