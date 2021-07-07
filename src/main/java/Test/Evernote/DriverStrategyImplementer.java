package Test.Evernote;

public class DriverStrategyImplementer {

	public static DriverStrategy chooseStrategy(String Strategy) {
		switch(Strategy)
		{
		case "chrome":
			return new chrome();
		default:
			return null;
		}
	}
}
