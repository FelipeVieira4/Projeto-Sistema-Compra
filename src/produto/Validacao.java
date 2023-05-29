package produto;
/**
 * Fazer Validacao das variaveis
 * 
 * 
 * **/
public class Validacao {

	/**tipo float**/
	public static boolean FloatTipo(String floatString){
		try{
			Float.parseFloat(floatString);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**tipo int**/
	public static boolean IntTipo(String intString){
		try{
			Integer.parseInt(intString);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
