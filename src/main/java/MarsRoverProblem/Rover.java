package MarsRoverProblem;

public class Rover {
	
    Integer upperRightX; 
	
	Integer upperRightY;
	
	Integer xPosition;
	
	Integer yPosition;
	
	String orientation;
	
	private enum CommandEnum
	{ 
		L('L'),
		R('R'),
		M('M');
		
		private char command;
		
		CommandEnum(char command)
		{
			this.command = command;
		}

		public char getCommand() {
			return command;
		}

		
	}
	
	Rover(Integer upperRightX, Integer upperRightY)
	{
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
	}
	
	void setCurrentLocation(Integer x, Integer y, String ornt)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.orientation = ornt;
	}
	
	void navigate(String commandStr)
	{
		StringBuffer sb = new StringBuffer(commandStr);
		int length = sb.length();
		char commandChar;
		for(int index=0; index<length; index++)
		{
			commandChar = commandStr.charAt(index);
			
			
		}
		
		
		
	}
}


