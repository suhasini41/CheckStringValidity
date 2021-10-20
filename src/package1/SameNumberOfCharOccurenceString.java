package package1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SameNumberOfCharOccurenceString 
{
	private String findValidStringOrNot(String s) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0;i<s.length();i++)
		{
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
		}
		System.out.println(map.toString());
	
		List<Integer> list = new ArrayList<>();
		for(Map.Entry<Character,Integer> e : map.entrySet())
		{
			list.add(e.getValue());
		}
		Collections.sort(list);
		boolean flag = false;
		String answer = "YES";
		if((list.get(list.size()-1))-list.get(0)<2)
		{
			for(int i=1; i<list.size();i++)
			{
				if(list.get(i)>list.get(0)&&(flag==false))
				{
					flag = true;
				}
				else if(list.get(i)>list.get(0)&&(flag==true))
				{
					answer = "NO";
					break;	
				}
				
			}
		}
		else
			answer = "NO";
		return answer;
	}
	@Test
	public void testCase1()
	{
		Assert.assertEquals(findValidStringOrNot("abc"),"YES");
	}
	@Test
	public void testCase2()
	{
		Assert.assertEquals(findValidStringOrNot("abcc"),"YES");
	}
	@Test
	public void testCase3()
	{
		Assert.assertEquals(findValidStringOrNot("abccc"),"NO");
	}
	@Test
	public void testCase4()
	{
		Assert.assertEquals(findValidStringOrNot("aabbcd"),"NO");
	}
	@Test
	public void testCase5()
	{
		Assert.assertEquals(findValidStringOrNot("aabbccddeefghi"),"NO");
	}
}
