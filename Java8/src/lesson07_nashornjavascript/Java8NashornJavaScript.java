package lesson07_nashornjavascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Java8NashornJavaScript {

	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		
		String name = "Dao";
		Integer result = null;
		
		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		} catch (Exception e) {
			System.out.println("Error executing script: " + e.getMessage());
		}
		System.out.println(result.toString());
	}

}
