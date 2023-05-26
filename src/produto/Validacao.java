package produto;
/**
 * Fazer Validação das variáveis
 * 
 * 
 * **/
public class Validacao {

	/**Validar variáveis do tipo float**/
	public static boolean FloatTipo(String floatString){
		try{
			Float.parseFloat(floatString);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**Validar variáveis do tipo int**/
	public static boolean IntTipo(String intString){
		try{
			Integer.parseInt(intString);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
